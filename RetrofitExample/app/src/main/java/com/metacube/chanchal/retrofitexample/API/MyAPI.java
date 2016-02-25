package com.metacube.chanchal.retrofitexample.API;

import com.metacube.chanchal.retrofitexample.model.Example;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Chanchal on 25-02-2016.
 */
public interface MyAPI {
    @GET("2.2/search")
    Call<Example> getItems(@Query("site")String site,@Query("tagged")String tag);
}
