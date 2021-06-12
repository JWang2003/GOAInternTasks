package com.example.imageapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class ImagePage extends AppCompatActivity {

    // Backend properties
    int imageResource;

    // XML Views
    ImageView image;
    ImageButton backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_page);
        getSupportActionBar().hide();

        getIntents();
        connectXML();
        onClickSetup();
    }

    private void getIntents() {
        imageResource = getIntent().getIntExtra("imageId", 0);
    }

    private void connectXML() {
        image = findViewById(R.id.image);
        image.setImageResource(imageResource);
        backButton = findViewById(R.id.backButton);
    }

    private void onClickSetup() {
        backButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(ImagePage.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
