package saidur.demo.app;

import android.content.Context;

import androidx.multidex.MultiDexApplication;


public class DemoApplication extends MultiDexApplication {
    private static DemoApplication instance;
    private DemoModule appModule;
    private DemoComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        instance = this;
        appModule = new DemoModule(this);
        appComponent = DaggerDemoComponent.builder()
                .demoModule(appModule)
                .build();
    }

    public static DemoApplication getInstance(final Context mContext) {
        return (DemoApplication) mContext.getApplicationContext();
    }

    public static DemoApplication getInstance() {
        return instance;
    }

    public DemoModule getAppModule(){
        return appModule;
    }

    public DemoComponent getAppComponent(){
        return appComponent;
    }
}
