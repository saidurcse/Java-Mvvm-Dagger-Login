package saidur.demo.app.view.login;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import java.util.Objects;

import saidur.demo.app.DemoApplication;
import saidur.demo.app.R;
import saidur.demo.app.database.DatabaseSingleton;
import saidur.demo.app.databinding.ActivityLoginBinding;
import saidur.demo.app.view.landing.LandingActivity;
import saidur.demo.app.view.login.model.LoginRequest;
import saidur.demo.app.view.login.view.LoginViewModel;

public class LoginActivity extends AppCompatActivity {

    private ActivityLoginBinding binding;
    private LoginComponent loginComponent;

    private LoginViewModel loginViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);

        loginViewModel = ViewModelProviders.of(this).get(LoginViewModel.class);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_login);

        final DemoApplication application = DemoApplication.getInstance(this);
        loginComponent = DaggerLoginComponent.builder()
                .demoComponent(application.getAppComponent())
                .loginModule(new LoginModule(this))
                .build();
        loginComponent.inject(this);

        binding.setLifecycleOwner(this);
        binding.setViewModel(loginViewModel);

        loginViewModel.getUser().observe(this, new Observer<LoginRequest>() {
            @Override
            public void onChanged(@Nullable LoginRequest loginRequest) {

                if (TextUtils.isEmpty(Objects.requireNonNull(loginRequest).getEmail())) {
                    binding.EmailSignUp.setError("Enter an E-Mail Address");
                    binding.EmailSignUp.requestFocus();
                } else if (!loginRequest.isEmailValid()) {
                    binding.EmailSignUp.setError("Enter a Valid E-mail Address");
                    binding.EmailSignUp.requestFocus();
                } else if (TextUtils.isEmpty(Objects.requireNonNull(loginRequest).getPassword())) {
                    binding.PasswordSignUp.setError("Enter a Password");
                    binding.PasswordSignUp.requestFocus();
                } else if (!loginRequest.isPasswordLengthGreaterThan5()) {
                    binding.PasswordSignUp.setError("Enter at least 6 Digit password");
                    binding.PasswordSignUp.requestFocus();
                } else {
                    LoginRequest loginRequest1 = DatabaseSingleton.GetDatabase(getApplicationContext()).signupDAO().GetUser(loginRequest.getEmail(), loginRequest.getPassword());
                    if(loginRequest1.getEmail().equals(loginRequest.getEmail()) && loginRequest1.getPassword().equals(loginRequest.getPassword())){
                        Toast.makeText(getApplicationContext(), "Success", Toast.LENGTH_LONG);
                        binding.SignUpConfirm.setText("Success");
                        Intent openLandingPage = new Intent(LoginActivity.this, LandingActivity.class);
                        startActivity(openLandingPage);
                    } else{
                        Toast.makeText(getApplicationContext(), "Please check again", Toast.LENGTH_LONG);
                    }
                }
            }
        });
    }
}
