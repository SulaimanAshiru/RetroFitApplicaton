package com.example.retrofitapplicaton.adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.retrofitapplicaton.R;
import com.example.retrofitapplicaton.R;

import org.w3c.dom.Text;

import java.util.List;

// Created Class and extend it to RecyclerView and extending an inner class (Adapter) in class (Recycler View)
public class ShibeAdapter extends RecyclerView.Adapter<ShibeAdapter.ShibeViewHolder> {

    // Declaring a list of strings and context
    private List<String> shibeUrls;
    private Context context;


    //Constructor to create a new instance of ShibeAdapter
    public ShibeAdapter(List<String> shibeUrls) {
        //initializing
        this.shibeUrls = shibeUrls;
    }


    // Implements methods from Adapter
    @NonNull
    @Override
    //Create view holder. gave it a layout and
    public ShibeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View view = LayoutInflater.from(context).inflate(
                R.layout.shibe_item,
                parent,
                false);
        return new ShibeViewHolder(view);
    }
    //Takes list and view and puts it together
    @Override
    public void onBindViewHolder(@NonNull ShibeViewHolder holder, int position) {
        String shibeUrl = shibeUrls.get(position);
        //loading image
        Glide.with(context).load(shibeUrl).into(holder.ivShibeImage);
    }
    // Getting the amount of items from the string
    @Override
    public int getItemCount() {
        return shibeUrls.size();
    }

    //Declaring and initializing views in layout
    class ShibeViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView ivShibeImage;

        ShibeViewHolder(@NonNull View itemView) {
            super(itemView);
            ivShibeImage = itemView.findViewById(R.id.iv_shibe_image);
        }

        @Override
        public void onClick(View view) {

        }
    }
}