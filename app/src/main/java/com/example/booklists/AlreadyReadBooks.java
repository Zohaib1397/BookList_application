package com.example.booklists;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

public class AlreadyReadBooks extends AppCompatActivity {
    private RecyclerView booksList;
    private BookRecViewAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_already_read_books);
        booksList=findViewById(R.id.alreadyReadRecView);
        adapter = new BookRecViewAdapter(this,this);
        booksList.setAdapter(adapter);
        adapter.setBooks(Utils.getInstance(this).getAlreadyReadBooks());
        booksList.setLayoutManager(new LinearLayoutManager(this));
    }
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(AlreadyReadBooks.this,MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}