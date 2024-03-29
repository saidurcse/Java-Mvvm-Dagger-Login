package saidur.demo.app.retrofit;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import okhttp3.Cache;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import saidur.demo.app.DemoApplication;
import saidur.demo.app.util.Config;

public class ServiceGenerator {

    private static final String API_BASE_URL = Config.DEV_URL;
    private static int cacheSize = 10 * 1024 * 1024; // 10 MB

    private static Cache cache = new Cache(DemoApplication.getInstance().getCacheDir(), cacheSize);

    private static OkHttpClient okHttpClient = new OkHttpClient.Builder()
            .cache(cache)
            .build();

    private static Gson gson = new GsonBuilder()
            .setLenient()
            .create();

    private static Retrofit.Builder builder = new Retrofit.Builder()
            .baseUrl(API_BASE_URL)
            .client(okHttpClient)  //getUnsafeOkHttpClient().build()//okHttpClient
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create(gson));

    private static Retrofit retrofit = builder.build();

    public static <S> S createService(Class<S> serviceClass) {
        return retrofit.create(serviceClass);
    }
}
