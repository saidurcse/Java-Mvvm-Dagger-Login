package saidur.demo.app.view.landing;


import dagger.Component;
import saidur.demo.app.DemoComponent;
import saidur.demo.app.view.landing.view.LandingViewModel;

@LandingScope
@Component(dependencies = DemoComponent.class, modules = {LandingModule.class})
public interface LandingComponent extends LandingGraph{

    void inject(LandingActivity landingActivity);

    void inject(LandingViewModel landingViewModel);
}