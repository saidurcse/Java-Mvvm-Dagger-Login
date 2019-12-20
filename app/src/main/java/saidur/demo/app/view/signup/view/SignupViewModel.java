package saidur.demo.app.view.signup.view;

import android.content.Context;
import android.view.View;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import javax.inject.Inject;
import saidur.demo.app.util.SharedPrefsHelper;
import saidur.demo.app.view.signup.model.SignupRequest;

public class SignupViewModel extends ViewModel {
    @Inject
    SharedPrefsHelper sharedPrefsHelper;
    @Inject
    protected Context context;

    public MutableLiveData<String> email = new MutableLiveData<>();
    public MutableLiveData<String> password = new MutableLiveData<>();

    private MutableLiveData<SignupRequest> userMutableLiveData;

    public MutableLiveData<SignupRequest> getUser() {

        if (userMutableLiveData == null) {
            userMutableLiveData = new MutableLiveData<>();
        }
        return userMutableLiveData;
    }

    public void onClick(View view) {
        SignupRequest signupUser = new SignupRequest(email.getValue(), password.getValue());

        userMutableLiveData.setValue(signupUser);
    }
}
