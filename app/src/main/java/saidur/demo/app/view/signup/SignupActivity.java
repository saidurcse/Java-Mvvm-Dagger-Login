package saidur.demo.app.view.signup;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.Window;
import android.view.WindowManager;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import java.util.Objects;

import saidur.demo.app.DemoApplication;
import saidur.demo.app.R;
import saidur.demo.app.database.DatabaseSingleton;
import saidur.demo.app.databinding.ActivitySignupBinding;
import saidur.demo.app.view.signup.model.SignupRequest;
import saidur.demo.app.view.signup.view.SignupViewModel;
import saidur.demo.app.view.signup.view.SignupViewModel_MembersInjector;

public class SignupActivity extends AppCompatActivity {

    private ActivitySignupBinding binding;
    private SignupComponent signupComponent;

    private SignupViewModel signupViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);

        signupViewModel = ViewModelProviders.of(this).get(SignupViewModel.class);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_signup);

        final DemoApplication application = DemoApplication.getInstance(this);
        signupComponent = DaggerSignupComponent.builder()
                .demoComponent(application.getAppComponent())
                .signupModule(new SignupModule(this))
                .build();
        signupComponent.inject(this);

        binding.setLifecycleOwner(this);
        binding.setViewModel(signupViewModel);

        signupViewModel.getUser().observe(this, new Observer<SignupRequest>() {
            @Override
            public void onChanged(@Nullable SignupRequest signupRequest) {

                if (TextUtils.isEmpty(Objects.requireNonNull(signupRequest).getEmail())) {
                    binding.EmailSignUp.setError("Enter an E-Mail Address");
                    binding.EmailSignUp.requestFocus();
                } else if (!signupRequest.isEmailValid()) {
                    binding.EmailSignUp.setError("Enter a Valid E-mail Address");
                    binding.EmailSignUp.requestFocus();
                } else if (TextUtils.isEmpty(Objects.requireNonNull(signupRequest).getPassword())) {
                    binding.PasswordSignUp.setError("Enter a Password");
                    binding.PasswordSignUp.requestFocus();
                } else if (!signupRequest.isPasswordLengthGreaterThan5()) {
                    binding.PasswordSignUp.setError("Enter at least 6 Digit password");
                    binding.PasswordSignUp.requestFocus();
                } else {
                    //binding.EmailSignUp.setText(signupRequest.getEmail());
                    //binding.PasswordSignUp.setText(signupRequest.getPassword());
                    SignupRequest signupUser = new SignupRequest(signupRequest.getEmail(), signupRequest.getPassword());
                    DatabaseSingleton.GetDatabase(getApplicationContext()).signupDAO().AddUser(signupUser);
                }
            }
        });

    }
}
