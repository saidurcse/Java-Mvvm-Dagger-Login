package saidur.demo.app.retrofit;

import saidur.demo.app.retrofit.model.ResponseType;

public interface OnRestCompleteListener<T> {

    void onComplete(ResponseType responseType, T result, String message);
}
