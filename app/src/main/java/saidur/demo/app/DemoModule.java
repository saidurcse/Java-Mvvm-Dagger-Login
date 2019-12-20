package saidur.demo.app;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.google.gson.Gson;

import dagger.Module;
import dagger.Provides;
import saidur.demo.app.model.DaggerTestClass;
import saidur.demo.app.model.ObjectManager;

@Module
public class DemoModule {

    private Context context;

    public DemoModule(Context context){
        this.context = context;
    }

    @DemoScope @Provides
    public Context provideContext(){
        return context;
    }

    @DemoScope @Provides
    public Gson provideGson(){
        return new Gson();
    }

    @DemoScope @Provides
    public SharedPreferences provideSharedPreferences(Context context){
        return PreferenceManager.getDefaultSharedPreferences(context);
    }

    @DemoScope @Provides
    public ObjectManager provideObjectManager(SharedPreferences sharedPreferences, Gson gson){
        return new ObjectManager(sharedPreferences, gson);
    }

    @Provides
    @DemoScope
    DaggerTestClass provideDaggerTestClass(){
        return new DaggerTestClass();
    }
}
