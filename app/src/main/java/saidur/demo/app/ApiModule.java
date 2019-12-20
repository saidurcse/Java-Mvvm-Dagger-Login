package saidur.demo.app;

import com.facebook.stetho.okhttp3.StethoInterceptor;
import com.google.gson.Gson;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.util.concurrent.TimeUnit;

import dagger.Module;
import dagger.Provides;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import saidur.demo.app.retrofit.endpoint.DemoEndPoint;
import saidur.demo.app.util.Config;

@Module
public class ApiModule {
    private final HttpUrl PRODUCTION_API_URL = HttpUrl.parse(Config.DEV_URL);

    @Provides
    @DemoScope
    HttpUrl provideBaseUrl() {
        return PRODUCTION_API_URL;
    }

    @Provides
    @DemoScope
    OkHttpClient provideOkHttpClient() {
        final OkHttpClient mClint = new OkHttpClient.Builder()
                .addNetworkInterceptor(new StethoInterceptor())
                .connectTimeout(120, TimeUnit.SECONDS)
                .readTimeout(120, TimeUnit.SECONDS)
                .writeTimeout(120, TimeUnit.SECONDS)
                .build();
        return mClint;
    }

    @Provides
    @DemoScope
    Retrofit provideRetrofit(HttpUrl mBaseUrl, OkHttpClient mClient, Gson gson) {
        return new Retrofit.Builder()
                .client(mClient)
                .baseUrl(mBaseUrl)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    @Provides
    @DemoScope
    DemoEndPoint provideApiService(Retrofit mRetrofit) {
        return mRetrofit.create(DemoEndPoint.class);
    }
}
