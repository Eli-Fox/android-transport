package com.lisway.transport.api;

import com.lisway.transport.BuildConfig;
import com.lisway.transport.api.gson.GsonWrapper;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.logging.HttpLoggingInterceptor;

import retrofit.GsonConverterFactory;
import retrofit.Retrofit;
import retrofit.RxJavaCallAdapterFactory;

public class ServiceFactory {
    private static OkHttpClient client;

    static {
        client = new OkHttpClient();
        HttpLoggingInterceptor logInterceptor = new HttpLoggingInterceptor();
        logInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        client.interceptors().add(logInterceptor);
    }

    private ServiceFactory() {
        // Factory
    }

    public static <S> S newService(Class<S> serviceClass) {
        Retrofit.Builder builder = new Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .client(client)
            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create(GsonWrapper.getGson()));

        return builder.build().create(serviceClass);
    }
}
