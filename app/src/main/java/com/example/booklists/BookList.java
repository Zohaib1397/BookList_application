package com.example.booklists;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class BookList extends AppCompatActivity {
    private RecyclerView bookRecView;
    private BookRecViewAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_list);
        bookRecView=findViewById(R.id.recycleViewList);
        adapter = new BookRecViewAdapter(this);
        bookRecView.setAdapter(adapter);
        adapter.setBooks(Utils.getInstance().getAllBooks());
        bookRecView.setLayoutManager(new LinearLayoutManager(this));
    }
}