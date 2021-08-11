package com.example.booklists;

import android.content.Context;
import android.content.SharedPreferences;
import android.gesture.Gesture;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;

public class Utils {
    private static final String ALL_BOOKS="all_books";
    private static final String ALREADY_READ_BOOKS="already_read_books";
    private static final String WANT_TO_READ_BOOKS="want_to_read_books";
    private static final String FAVORITE_BOOKS="favorite_books";
    private static final String CURRENTLY_READING_BOOKS="currently_reading_books";
    private SharedPreferences sharedPreferences;
    private static Utils instance;
//    private static ArrayList<Book>allBooks;
//    private static ArrayList<Book>alreadyReadBooks;
//    private static ArrayList<Book>wantToReadBooks;
//    private static ArrayList<Book>currentlyReadingBooks;
//    private static ArrayList<Book> favoriteBook;
    private Utils(Context context) {
        sharedPreferences=context.getSharedPreferences("alternate_db",Context.MODE_PRIVATE);
//        if(null==allBooks){
//            allBooks=new ArrayList<>();
//            initData();
//        }
        if(null==getAllBooks()){
            initData();
        }
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();
//        if(null ==alreadyReadBooks){
//            alreadyReadBooks=new ArrayList<>();
//        }
        if(null ==getAlreadyReadBooks()){
            editor.putString(ALREADY_READ_BOOKS,gson.toJson(new ArrayList<Book>()));
            editor.apply();
        }
//        if(null ==wantToReadBooks){
//            wantToReadBooks=new ArrayList<>();
//        }
        if(null ==getWantToReadBooks()){
            editor.putString(WANT_TO_READ_BOOKS,gson.toJson(new ArrayList<Book>()));
            editor.apply();
        }
//        if(null ==currentlyReadingBooks){
//            currentlyReadingBooks=new ArrayList<>();
//        }
        if(null ==getCurrentlyReadingBooks()){
            editor.putString(CURRENTLY_READING_BOOKS,gson.toJson(new ArrayList<Book>()));
            editor.apply();
        }
//        if(null ==favoriteBook){
//            favoriteBook=new ArrayList<>();
//        }
        if(null ==getFavoriteBook()){
            editor.putString(FAVORITE_BOOKS,gson.toJson(new ArrayList<Book>()));
            editor.apply();
        }
    }
    public static Utils getInstance(Context context) {
        if(null == instance){
            instance = new Utils(context);
            return instance;
        }else{
            return instance;
        }
    }
    public ArrayList<Book> getAllBooks() {
        Gson gson=new Gson();
        ArrayList<Book>get_books=gson.fromJson(sharedPreferences.getString(ALL_BOOKS,null),new TypeToken<ArrayList<Book>>(){}.getType());
        return get_books;
//        return allBooks;
    }
    public ArrayList<Book> getAlreadyReadBooks() {
        Gson gson=new Gson();
        return gson.fromJson(sharedPreferences.getString(ALREADY_READ_BOOKS,null),new TypeToken<ArrayList<Book>>(){}.getType());
//        return alreadyReadBooks;
    }
    public ArrayList<Book> getWantToReadBooks() {
        Gson gson=new Gson();
        Type type = new TypeToken<ArrayList<Book>>(){}.getType();
        ArrayList<Book>get_books=gson.fromJson(sharedPreferences.getString(WANT_TO_READ_BOOKS,null),type);
        return get_books;
//        return wantToReadBooks;
    }
    public ArrayList<Book> getCurrentlyReadingBooks() {
        Gson gson=new Gson();
        Type type = new TypeToken<ArrayList<Book>>(){}.getType();
        ArrayList<Book>get_books=gson.fromJson(sharedPreferences.getString(CURRENTLY_READING_BOOKS,null),type);
        return get_books;
//        return currentlyReadingBooks;
    }
    public ArrayList<Book> getFavoriteBook() {
        Gson gson=new Gson();
        Type type = new TypeToken<ArrayList<Book>>(){}.getType();
        ArrayList<Book>get_books=gson.fromJson(sharedPreferences.getString(FAVORITE_BOOKS,null),type);
        return get_books;
//        return favoriteBook;
    }
    private void initData(){
//        allBooks.add(new Book("Miracle Morning","Hal Elrod","2017","https://m.media-amazon.com/images/I/51AIz1GrKwL._SL500_.jpg"));
//        allBooks.add(new Book("Show Your Work","Austin","2019","https://images-na.ssl-images-amazon.com/images/I/71MTgEEjNVL.jpg"));
        ArrayList<Book>books=new ArrayList<>();
        books.add(new Book("Miracle Morning","Hal Elrod","2017","https://m.media-amazon.com/images/I/51AIz1GrKwL._SL500_.jpg"));
        books.add(new Book("Show Your Work","Austin","2019","https://images-na.ssl-images-amazon.com/images/I/71MTgEEjNVL.jpg"));
        SharedPreferences.Editor editor= sharedPreferences.edit();
        Gson gson = new Gson();
        editor.putString(ALL_BOOKS,gson.toJson(books));
        editor.apply();
    }
    public Book getBookByName(String name){
        ArrayList<Book>books=getAllBooks();
        if(null != books) {
            for (Book b : books) {
                if (b.getName().equals(name)) {
                    return b;
                }
            }
        }
        return null;
    }
    public boolean saveToAlreadyRead(Book book){
        ArrayList<Book>books=getAlreadyReadBooks();
        if(books!=null){
            if(books.add(book)){
                SharedPreferences.Editor editor= sharedPreferences.edit();
                editor.remove(ALREADY_READ_BOOKS);
                editor.putString(ALREADY_READ_BOOKS,new Gson().toJson(books));
                editor.apply();
                return true;
            }
        }
        return false;
    }
    public boolean saveToWantToRead(Book book){
        ArrayList<Book>books=getWantToReadBooks();
        if(books!=null){
            if(books.add(book)){
                SharedPreferences.Editor editor= sharedPreferences.edit();
                editor.remove(WANT_TO_READ_BOOKS);
                editor.putString(WANT_TO_READ_BOOKS,new Gson().toJson(books));
                editor.apply();
                return true;
            }
        }
        return false;
    }
    public boolean saveToFavoriteBooks(Book book){
        ArrayList<Book>books=getFavoriteBook();
        if(books!=null){
            if(books.add(book)){
                SharedPreferences.Editor editor= sharedPreferences.edit();
                editor.remove(FAVORITE_BOOKS);
                editor.putString(FAVORITE_BOOKS,new Gson().toJson(books));
                editor.apply();
                return true;
            }
        }
        return false;
    }
    public boolean saveToCurrentlyReadingBooks(Book book){
        ArrayList<Book>books=getCurrentlyReadingBooks();
        if(books!=null){
            if(books.add(book)){
                SharedPreferences.Editor editor= sharedPreferences.edit();
                editor.remove(CURRENTLY_READING_BOOKS);
                editor.putString(CURRENTLY_READING_BOOKS,new Gson().toJson(books));
                editor.apply();
                return true;
            }
        }
        return false;
    }
    public boolean removeAlreadyRead(Book book){
        ArrayList<Book>books=getAlreadyReadBooks();
        if(books!=null) {
            for (Book b : books) {
                if (b.getName().equals(book.getName())) {
                    if (books.remove(b)) {
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.remove(ALREADY_READ_BOOKS);
                        editor.putString(ALREADY_READ_BOOKS, new Gson().toJson(books));
                        editor.apply();
                        return true;
                    }
                }
            }
        }
        return false;
    }
    public boolean removeWantToRead(Book book){
        ArrayList<Book>books=getWantToReadBooks();
        if(books!=null) {
            for (Book b : books) {
                if (b.getName().equals(book.getName())) {
                    if (books.remove(b)) {
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.remove(WANT_TO_READ_BOOKS);
                        editor.putString(WANT_TO_READ_BOOKS, new Gson().toJson(books));
                        editor.apply();
                        return true;
                    }
                }
            }
        }
        return false;
    }
    public boolean removeFavorite(Book book){
        ArrayList<Book>books=getFavoriteBook();
        if(books!=null) {
            for (Book b : books) {
                if (b.getName().equals(book.getName())) {
                    if (books.remove(b)) {
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.remove(FAVORITE_BOOKS);
                        editor.putString(FAVORITE_BOOKS, new Gson().toJson(books));
                        editor.apply();
                        return true;
                    }
                }
            }
        }
        return false;
    }
    public boolean removeCurrentlyReading(Book book){
        ArrayList<Book>books=getCurrentlyReadingBooks();
        if(books!=null) {
            for (Book b : books) {
                if (b.getName().equals(book.getName())) {
                    if (books.remove(b)) {
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.remove(CURRENTLY_READING_BOOKS);
                        editor.putString(CURRENTLY_READING_BOOKS, new Gson().toJson(books));
                        editor.apply();
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
