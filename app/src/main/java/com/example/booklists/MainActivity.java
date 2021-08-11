package com.example.booklists;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private Button btnShowAllaBooks,btnCurrentlyReadingBooks,btnWantToReadBooks,btnAlreadyReadBooks,btnFavoriteBooks,btnAbout;
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
        btnCurrentlyReadingBooks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,CurrentlyReadingBooks.class);
                startActivity(intent);
            }
        });
        btnWantToReadBooks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,WantToReadBooks.class);
                startActivity(intent);
            }
        });
        btnAlreadyReadBooks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,AlreadyReadBooks.class);
                startActivity(intent);
            }
        });
        btnFavoriteBooks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,FavoriteBooks.class);
                startActivity(intent);
            }
        });
        btnAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder =new AlertDialog.Builder(MainActivity.this);
                builder.setTitle(getString(R.string.app_name));
                builder.setMessage("This App is Developed my Zohaib Ahmed. just for simple practice.\n if you want to check more of my work don't hesitate to visit my webpage.");
                builder.setNegativeButton("Dismiss", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                builder.setPositiveButton("Visit", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent=new Intent(MainActivity.this,WebActivity.class);
                        intent.putExtra("url","https://github.com/Zohaib1397");
                        startActivity(intent);
                    }
                });
                builder.create().show();
            }
        });
        Utils.getInstance(this);
    }
    private void initView(){
        btnShowAllaBooks=findViewById(R.id.btnShowAllBooks);
        btnCurrentlyReadingBooks=findViewById(R.id.btnCurrentlyReadingBooks);
        btnWantToReadBooks=findViewById(R.id.btnWantToReadBooks);
        btnFavoriteBooks=findViewById(R.id.btnFavoriteBooks2);
        btnAlreadyReadBooks=findViewById(R.id.btnAlreadyReadBooks);
        profileImage=findViewById(R.id.profileImage);
        profileImage.setImageResource(R.mipmap.profile_image);
        btnAbout=findViewById(R.id.btnAbout);
    }
}