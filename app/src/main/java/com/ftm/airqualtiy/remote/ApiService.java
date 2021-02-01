package com.ftm.airqualtiy.remote;

import com.ftm.airqualtiy.model.ResponseAirHere;

import com.ftm.airqualtiy.model.search.ResponseSearch;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {
    @GET("/feed/here/")
    Call<ResponseAirHere> getHereAirQuality(@Query("token") String token);


    @GET("search/")
    Call<ResponseSearch> getSearchData(@Query("keyword") String keyword, @Query("token") String token);
}
