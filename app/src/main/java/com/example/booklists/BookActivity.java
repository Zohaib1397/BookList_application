package com.example.booklists;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class BookActivity extends AppCompatActivity {
    private ImageView imageBookActivity;
    private TextView txtName,txtAuthorName,txtDate;
    private Button btnReading,btnWantToRead,btnAlreadyRead,btnToFavorite;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);
        intiView();
        Intent intent = getIntent();
        if(null!=intent){
            String bookName=intent.getStringExtra("bookName");
            Book incomingBook=Utils.getInstance(this).getBookByName(bookName);
            if(null!=incomingBook) {
                getSupportActionBar().setDisplayHomeAsUpEnabled(true);
                setData(incomingBook);
                handleAlreadyReadBooks(incomingBook);
                handleWantToReadBooks(incomingBook);
                handleFavoriteBooks(incomingBook);
                handleCurrentlyReadingBooks(incomingBook);
            }

        }
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case android.R.id.home:
                onBackPressed();
                break;
            default:break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void handleCurrentlyReadingBooks(Book book) {
        ArrayList<Book>currentlyReadingBooks=Utils.getInstance(BookActivity.this).getCurrentlyReadingBooks();
        boolean currentlyReadingCheck=false;
        for(Book b:currentlyReadingBooks){
            if(b.getName().equals(book.getName())){
                currentlyReadingCheck=true;
            }
        }
        if(currentlyReadingCheck){
            btnReading.setEnabled(false);
        }else{
            btnReading.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(Utils.getInstance(BookActivity.this).saveToCurrentlyReadingBooks(book)) {
                        btnReading.setEnabled(false);
                        Toast.makeText(BookActivity.this, "Added to Currently Reading", Toast.LENGTH_SHORT).show();
                        Intent intent=new Intent(BookActivity.this,CurrentlyReadingBooks.class);
                        startActivity(intent);
                    }
                }
            });
        }
    }

    private void handleFavoriteBooks(Book book) {
        ArrayList<Book>favoriteBooks=Utils.getInstance(BookActivity.this).getFavoriteBook();
        boolean favoriteBookCheck=false;
        for(Book b:favoriteBooks){
            if(b.getName().equals(book.getName())){
                favoriteBookCheck=true;
            }
        }
        if(favoriteBookCheck){
            btnToFavorite.setEnabled(false);
        }else{
            btnToFavorite.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(Utils.getInstance(BookActivity.this).saveToFavoriteBooks(book)) {
                        btnToFavorite.setEnabled(false);
                        Toast.makeText(BookActivity.this, "Added to Favorites", Toast.LENGTH_SHORT).show();
                        Intent intent=new Intent(BookActivity.this,FavoriteBooks.class);
                        startActivity(intent);
                    }
                }
            });
        }
    }

    private void handleWantToReadBooks(Book book) {
        ArrayList<Book>wantToRead=Utils.getInstance(BookActivity.this).getWantToReadBooks();
        boolean wantToReadCheck=false;
        for(Book b:wantToRead){
            if(b.getName().equals(book.getName())){
                wantToReadCheck=true;
            }
        }
        if(wantToReadCheck){
            btnWantToRead.setEnabled(false);
        }else{
            btnWantToRead.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(Utils.getInstance(BookActivity.this).saveToWantToRead(book)) {
                        btnWantToRead.setEnabled(false);
                        Toast.makeText(BookActivity.this, "Added to Want To Read", Toast.LENGTH_SHORT).show();
                        Intent intent=new Intent(BookActivity.this,WantToReadBooks.class);
                        startActivity(intent);
                    }
                }
            });
        }
    }

    private void handleAlreadyReadBooks(Book book) {
        ArrayList<Book>alreadyReadBooks=Utils.getInstance(BookActivity.this).getAlreadyReadBooks();
        boolean isAlreadyRead=false;
        for(Book b:alreadyReadBooks){
            if(b.getName().equals(book.getName())){
                isAlreadyRead=true;
            }
        }
        if(isAlreadyRead){
            btnAlreadyRead.setEnabled(false);
        }else{
            btnAlreadyRead.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(Utils.getInstance(BookActivity.this).saveToAlreadyRead(book)) {
                        btnAlreadyRead.setEnabled(false);
                        Toast.makeText(BookActivity.this, "Saved to Already Read", Toast.LENGTH_SHORT).show();
                        Intent intent=new Intent(BookActivity.this,AlreadyReadBooks.class);
                        startActivity(intent);
                    }
                }
            });
        }
    }

    /**
     * setData is used to set the desired book data to the BookActivity
     * Glide is for image
     * @param books
     */
    private void setData(Book books) {
        Glide.with(this)
                .asBitmap()
                .load(books.getImgURL())
                .into(imageBookActivity);
        txtName.setText(books.getName());
        txtAuthorName.setText(books.getAuthor());
        txtDate.setText(books.getDate());
    }

    private void intiView() {
        imageBookActivity=findViewById(R.id.imageBookActivity);
        txtName=findViewById(R.id.txtBookActivityName);
        txtAuthorName=findViewById(R.id.txtBookActivityAuthor);
        txtDate=findViewById(R.id.txtBookActivityDate);
        btnReading=findViewById(R.id.btnCurrentlyReading);
        btnAlreadyRead=findViewById(R.id.btnAlreadyRead);
        btnToFavorite=findViewById(R.id.btnToFavorites);
        btnWantToRead=findViewById(R.id.btnWantToRead);
    }
}