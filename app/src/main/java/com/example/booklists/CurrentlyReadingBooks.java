package com.example.booklists;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

public class CurrentlyReadingBooks extends AppCompatActivity {
    private RecyclerView booksList;
    private BookRecViewAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_currently_reading_books);
        booksList=findViewById(R.id.currentlyReadingBooksRecView);
        adapter = new BookRecViewAdapter(this,this);
        booksList.setAdapter(adapter);
        adapter.setBooks(Utils.getInstance(this).getCurrentlyReadingBooks());
        booksList.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(CurrentlyReadingBooks.this,MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}