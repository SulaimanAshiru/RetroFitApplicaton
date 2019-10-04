package com.example.retrofitapplicaton.repository;

import com.example.retrofitapplicaton.retrofit.RetroFitInstance;
import com.example.retrofitapplicaton.retrofit.ShibeService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;

public class Repository {


    //Create private Constructor to ensure Singleton
    private Repository() { }


    //Implement public static method that returns Repository
    public static Repository getInstance() {
        return RepostitoryInstanceHolder.INSTANCE;
    }

    //Implement static class method to access Instanceholder of Repository
    static class RepostitoryInstanceHolder {
        static Repository INSTANCE = new Repository();
    }
    //Call method to get list of string in Shibes
    public Call<List<String>> getShibes(int count) {
       return RetroFitInstance.getInstance()
                .create(ShibeService.class)
                .getShibes(count);
    }
}
