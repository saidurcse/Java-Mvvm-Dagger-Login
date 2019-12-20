package saidur.demo.app.view.signup.view;

import android.content.Context;
import androidx.lifecycle.ViewModel;
import javax.inject.Inject;
import saidur.demo.app.util.SharedPrefsHelper;

public class SignupViewModel extends ViewModel {
    @Inject
    SharedPrefsHelper sharedPrefsHelper;
    @Inject
    protected Context context;

   /* private RegisteredLoginRequest credential;
    private CompositeDisposable disposable;

    public LoginViewModel(){
        disposable = new CompositeDisposable();
        credential = new RegisteredLoginRequest();
    }

    public void signUp() {
        sendLoginInfo();
    }

    public RegisteredLoginRequest getCredential() {
        return credential;
    }

    public void onStop() {
        disposable.clear();
    }

    private void sendLoginInfo() {

        RegisteredLoginRequest test = new RegisteredLoginRequest("saidur@polyfins.com","123456");
        endPoint = ServiceGenerator.createService(DemoEndPoint.class);
        disposable.add(
                endPoint
                        .getRegisteredUserLogin(test)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribeWith(new DisposableSingleObserver<RegisteredLoginResponse>() {
                            @Override
                            public void onSuccess(RegisteredLoginResponse registeredLoginResponse) {
                                Toast.makeText(context, "Registration successful.", Toast.LENGTH_LONG).show();
                               *//* if(registeredLoginResponse.getMessage.equals("success")) {
                                    //String meesage = result.getMessage();
                                    String token = bdUserResponse.getData().getAccessToken();
                                    //Toast.makeText(getApplicationContext(), "Success.", Toast.LENGTH_SHORT).show();
                                    myPreferences.setToken(token);
                                    myPreferences.setSocialLoginStatus(true);
                                    myPreferences.setUserName(context.getString(R.string.registered_user));
                                    myPreferences.setUserEmail("Facebook Registered User");
                                    view.showProgressIndicator(false);
                                    view.forwardToLandingActivity();
                                } else {
                                    Toast.makeText(context, "Registration not successful. Please try again.", Toast.LENGTH_LONG).show();
                                }*//*
                            }

                            @Override
                            public void onError(Throwable e) {
                                //e.printStackTrace();
                                Toast.makeText(context, "Registration not successful. Please try again.", Toast.LENGTH_LONG).show();
                            }
                        }));


    }*/
}
