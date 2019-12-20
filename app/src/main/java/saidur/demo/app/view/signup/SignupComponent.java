package saidur.demo.app.view.signup;

import dagger.Component;
import saidur.demo.app.DemoComponent;
import saidur.demo.app.view.login.LoginGraph;
import saidur.demo.app.view.signup.view.SignupViewModel;

@SignupScope
@Component(dependencies = DemoComponent.class, modules = {SignupModule.class})
public interface SignupComponent extends LoginGraph{

    void inject(SignupActivity signupActivity);

    void inject(SignupViewModel signupViewModel);
}