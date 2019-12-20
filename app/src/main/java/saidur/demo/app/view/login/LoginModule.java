package saidur.demo.app.view.login;

import android.content.Context;

import dagger.Module;
import dagger.Provides;
import saidur.demo.app.util.SharedPrefsHelper;

@Module
public class LoginModule {
    private Context mContext;

    public LoginModule(Context mContext) {
        this.mContext = mContext;
    }

    @Provides
    @LoginScope
    Context provideContext() {
        return this.mContext;
    }

    @Provides
    @LoginScope
    SharedPrefsHelper provideSharedPrefsHelper(Context mContext) {
        return new SharedPrefsHelper(mContext);
    }
}