package saidur.demo.app.view.landing;

import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;

import saidur.demo.app.DemoApplication;
import saidur.demo.app.R;
import saidur.demo.app.databinding.ActivityLandingBinding;
import saidur.demo.app.view.landing.view.LandingViewModel;

public class LandingActivity extends AppCompatActivity {

    private ActivityLandingBinding binding;
    private LandingComponent landingComponent;

    private LandingViewModel landingViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);

        landingViewModel = ViewModelProviders.of(this).get(LandingViewModel.class);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_landing);

        final DemoApplication application = DemoApplication.getInstance(this);
        landingComponent = DaggerLandingComponent.builder()
                .demoComponent(application.getAppComponent())
                .landingModule(new LandingModule(this))
                .build();
        landingComponent.inject(this);

        binding.setLifecycleOwner(this);
        binding.setViewModel(landingViewModel);
    }
}
