package saidur.demo.app.view.login;

import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import saidur.demo.app.DemoApplication;
import saidur.demo.app.R;
import saidur.demo.app.databinding.ActivityLoginBinding;

public class LoginActivity extends AppCompatActivity {

    private ActivityLoginBinding binding;
    private LoginComponent loginComponent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login);

        /*final DemoApplication application = DemoApplication.getInstance(this);
        loginComponent = DaggerLoginComponent.builder()
                .demoComponent(application.getAppComponent())
                .loginModule(new LoginModule(this))
                .build();
        loginComponent.inject(this);

        loadFragment(LoginFragment.newInstance());*/
    }

    private void loadFragment(Fragment selectedFragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.loin_fragment_container, selectedFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}
