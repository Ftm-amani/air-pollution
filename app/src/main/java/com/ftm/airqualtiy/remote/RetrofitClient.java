package com.ftm.airqualtiy.remote;

import com.ftm.airqualtiy.BuildConfig;
import com.ihsanbal.logging.Level;
import com.ihsanbal.logging.LoggingInterceptor;

import okhttp3.OkHttpClient;
import okhttp3.internal.platform.Platform;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public abstract class RetrofitClient {


    private final static String BASE_URL = "https://api.waqi.info/";
    private static Retrofit retrofit= null;

    public static Retrofit getClient(){

        LoggingInterceptor interceptor1= new LoggingInterceptor.Builder()
                .loggable(BuildConfig.DEBUG)
                .setLevel(Level.BASIC)
                .log(Platform.INFO)
                .request("Request")
                .response("Response")
                .addHeader("version", BuildConfig.VERSION_NAME)
                .addQueryParam("query", "0")
                .build();




        OkHttpClient okHttpClient = new OkHttpClient.Builder().addInterceptor(interceptor1).build();

        if (retrofit==null){

            retrofit =  new  Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .client(okHttpClient)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return retrofit;



    }

}
