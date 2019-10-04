package com.example.retrofitapplicaton.retrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

//change class to interface
public interface ShibeService {

    //Passing the path
    @GET(Constants.SHIBE_PATH)
    Call<List<String>> getShibes(@Query("count") int count);
}
