package com.example.booklists;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private Button btnShowAllaBooks;
    private ImageView profileImage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        btnShowAllaBooks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,BookList.class);
                startActivity(intent);
            }
        });
    }
    private void initView(){
        btnShowAllaBooks=findViewById(R.id.btnShowAllBooks);
        profileImage=findViewById(R.id.profileImage);
        profileImage.setImageResource(R.mipmap.profile_image);
    }
}