package com.example.imageapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ProgressBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //Properties
    GalleryAdapter galleryAdapter;
    ArrayList<Integer> galleryList = new ArrayList<>();

    //XML Views
    RecyclerView galleryRecyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();

        arrayListSetup();
        initViews();
        recyclerViewSetup();
    }

    private void arrayListSetup() {
        galleryList.add(R.drawable.image1);
        galleryList.add(R.drawable.image2);
        galleryList.add(R.drawable.image3);
        galleryList.add(R.drawable.image4);
//        System.out.println(galleryList);
    }

    private void initViews() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MainActivity.this, RecyclerView.VERTICAL, false);
        galleryRecyclerView = findViewById(R.id.recycle);
        galleryRecyclerView.setLayoutManager(linearLayoutManager);
    }

    private void recyclerViewSetup() {
        galleryAdapter = new GalleryAdapter(this,  galleryList);
        galleryRecyclerView.setAdapter(galleryAdapter);
        galleryRecyclerView.setHasFixedSize(true);
        galleryAdapter.setOnItemClickListener(new GalleryAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Intent intent = new Intent(MainActivity.this, ImagePage.class);
                intent.putExtra("imageId", galleryList.get(position));
                startActivity(intent);
            }
        });
    }







}