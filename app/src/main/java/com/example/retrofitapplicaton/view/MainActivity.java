package com.example.retrofitapplicaton.view;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.retrofitapplicaton.R;
import com.example.retrofitapplicaton.adapter.ShibeAdapter;
import com.example.retrofitapplicaton.repository.Repository;
import com.example.retrofitapplicaton.viewmodel.MainViewModel;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

//extent AppCompactivity
public class MainActivity extends AppCompatActivity  {

    //Declare my MainViewModel
    private MainViewModel viewModel;
    private RecyclerView rvShibes;
    private ShibeAdapter shibeAdapter;

    //Declare Button
    @BindView(R.id.btn_switch) Button btn_switch;

    //Declare recyclerview layout
    private LinearLayoutManager linearLayoutManager;

    //Declare GridLayout
    private GridLayoutManager gridLayoutManager;




    // Create on Create
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Set Content View
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        btn_switch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (rvShibes.getLayoutManager()==linearLayoutManager) {
                    rvShibes.setLayoutManager(gridLayoutManager);
                }
                else {
                    rvShibes.setLayoutManager(linearLayoutManager);
                }

                Toast.makeText(MainActivity.this, "Switch", Toast.LENGTH_SHORT).show();
            }
        });

        //Initiate viewmodel classes
        viewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        rvShibes = findViewById(R.id.rvShibes);



        Context context;
         linearLayoutManager = new LinearLayoutManager(this);
         gridLayoutManager = new GridLayoutManager(this,2 );
        rvShibes.setHasFixedSize(true);
        rvShibes.setLayoutManager(linearLayoutManager);


        viewModel.getShibes(10).enqueue(new Callback<List<String>>() {
            @Override
            public void onResponse(Call<List<String>> call, Response<List<String>> response) {
                ShibeAdapter adapter = new ShibeAdapter(response.body());
                rvShibes.setAdapter(adapter);

            }

            @Override
            public void onFailure(Call<List<String>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "FAILED", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
