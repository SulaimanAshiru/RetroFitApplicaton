package com.example.retrofitapplicaton.retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetroFitInstance {


    //Created to a private Constructor to ensure Singleton
    private RetroFitInstance() {
    }

    //Innerclass to create instance of retrofit
    private static class RetroFitInstanceHolder {

        //Create Instance
        static Retrofit INSTANCE = new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
        // Create public method to access the instance of Retrofit
        public static Retrofit getInstance () {
            return RetroFitInstanceHolder.INSTANCE;

        }
        //Optimized way for Retrofit
        public static <S> S createService (Class<S> serviceClass) {
            return RetroFitInstanceHolder.INSTANCE.create(serviceClass);
        }


}



