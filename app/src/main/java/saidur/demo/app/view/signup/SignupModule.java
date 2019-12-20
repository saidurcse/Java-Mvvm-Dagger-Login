package saidur.demo.app.view.signup;

import android.content.Context;

import dagger.Module;
import dagger.Provides;
import saidur.demo.app.util.SharedPrefsHelper;
import saidur.demo.app.view.login.LoginScope;

@Module
public class SignupModule {
    private Context mContext;

    public SignupModule(Context mContext) {
        this.mContext = mContext;
    }

    @Provides
    @SignupScope
    Context provideContext() {
        return this.mContext;
    }

    @Provides
    @SignupScope
    SharedPrefsHelper provideSharedPrefsHelper(Context mContext) {
        return new SharedPrefsHelper(mContext);
    }
}