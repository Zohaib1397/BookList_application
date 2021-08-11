package com.example.booklists;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.DragEvent;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.slider.Slider;

import java.util.ArrayList;

public class BookList extends AppCompatActivity {
    private RecyclerView bookRecView;
    private BookRecViewAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_list);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        bookRecView=findViewById(R.id.recycleViewList);
        adapter = new BookRecViewAdapter(this,this);
        bookRecView.setAdapter(adapter);
        adapter.setBooks(Utils.getInstance(this).getAllBooks());
        bookRecView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case android.R.id.home:
                onBackPressed();break;
            default:break;
        }
        return super.onOptionsItemSelected(item);
    }
}