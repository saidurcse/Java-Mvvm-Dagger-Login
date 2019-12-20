package saidur.demo.app;

import dagger.Component;
import saidur.demo.app.view.splash.SplashActivity;

@DemoScope
@Component(modules = {DemoModule.class, ApiModule.class})
public interface DemoComponent extends DemoGraph{

    void inject(SplashActivity activity);
}
