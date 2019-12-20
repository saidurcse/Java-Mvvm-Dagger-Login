package saidur.demo.app.view.login;

import dagger.Component;
import saidur.demo.app.DemoComponent;
import saidur.demo.app.view.login.view.LoginViewModel;

@LoginScope
@Component(dependencies = DemoComponent.class, modules = {LoginModule.class})
public interface LoginComponent extends LoginGraph{

    void inject(LoginActivity loginActivity);

    void inject(LoginViewModel loginViewModel);
}