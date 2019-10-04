package com.example.retrofitapplicaton.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.example.retrofitapplicaton.repository.Repository;

import java.util.List;

import retrofit2.Call;

//extend to AndroidView model
public class MainViewModel extends AndroidViewModel {

    //Constructor
    public MainViewModel(@NonNull Application application) {
        super(application);
    }


    public Call<List<String>> getShibes(int count){
        return Repository.getInstance().getShibes(count);
    }
}
