package saidur.demo.app.view.login.view;

import android.content.Context;
import android.view.View;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import javax.inject.Inject;

import saidur.demo.app.util.SharedPrefsHelper;
import saidur.demo.app.view.login.model.LoginRequest;

public class LoginViewModel extends ViewModel {
    @Inject
    SharedPrefsHelper sharedPrefsHelper;
    @Inject
    protected Context context;

    public MutableLiveData<String> email = new MutableLiveData<>();
    public MutableLiveData<String> password = new MutableLiveData<>();

    private MutableLiveData<LoginRequest> userMutableLiveData;


    public MutableLiveData<LoginRequest> getUser() {

        if (userMutableLiveData == null) {
            userMutableLiveData = new MutableLiveData<>();
        }
        return userMutableLiveData;
    }

    public void onClick(View view) {
        LoginRequest loginRequest = new LoginRequest(email.getValue(), password.getValue());

        userMutableLiveData.setValue(loginRequest);
    }
}
