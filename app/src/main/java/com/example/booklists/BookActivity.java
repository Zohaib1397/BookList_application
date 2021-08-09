package com.example.booklists;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

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
            Book incomingBook=Utils.getInstance().getBookByName(bookName);
            if(null!=incomingBook) {
                setData(incomingBook);
            }

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