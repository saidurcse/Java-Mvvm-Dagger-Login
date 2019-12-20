package saidur.demo.app.view.signup;

import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import saidur.demo.app.DemoApplication;
import saidur.demo.app.R;
import saidur.demo.app.databinding.ActivitySignupBinding;

public class SignupActivity extends AppCompatActivity {

    private ActivitySignupBinding binding;
    private SignupComponent signupComponent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_signup);

        final DemoApplication application = DemoApplication.getInstance(this);
        signupComponent = DaggerSignupComponent.builder()
                .demoComponent(application.getAppComponent())
                .signupModule(new SignupModule(this))
                .build();
        signupComponent.inject(this);
    }
}
