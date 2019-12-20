package saidur.demo.app;

import retrofit2.Retrofit;
import saidur.demo.app.retrofit.endpoint.DemoEndPoint;

public interface DemoGraph {

    Retrofit retrofit();

    DemoEndPoint endPoint();
}
