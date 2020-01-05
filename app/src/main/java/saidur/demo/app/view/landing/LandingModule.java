package saidur.demo.app.view.landing;

import android.content.Context;

import dagger.Module;
import dagger.Provides;
import saidur.demo.app.util.SharedPrefsHelper;


@Module
public class LandingModule {
    private Context mContext;

    public LandingModule(Context mContext) {
        this.mContext = mContext;
    }

    @Provides
    @LandingScope
    Context provideContext() {
        return this.mContext;
    }

    @Provides
    @LandingScope
    SharedPrefsHelper provideSharedPrefsHelper(Context mContext) {
        return new SharedPrefsHelper(mContext);
    }
}