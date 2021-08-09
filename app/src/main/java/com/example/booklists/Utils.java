package com.example.booklists;

import java.util.ArrayList;

public class Utils {
    private static Utils instance;
    private static ArrayList<Book>allBooks;
    private static ArrayList<Book>alreadyReadBooks;
    private static ArrayList<Book>wantToReadBooks;
    private static ArrayList<Book>currentlyReadingBooks;
    private static ArrayList<Book> favoriteBook;
    private Utils() {
        if(null==allBooks){
            allBooks=new ArrayList<>();
            initData();
        }
        if(null ==alreadyReadBooks){
            alreadyReadBooks=new ArrayList<>();
        }
        if(null ==wantToReadBooks){
            wantToReadBooks=new ArrayList<>();
        }
        if(null ==currentlyReadingBooks){
            currentlyReadingBooks=new ArrayList<>();
        }
        if(null ==favoriteBook){
            favoriteBook=new ArrayList<>();
        }
    }

    public static Utils getInstance() {
        if(null == instance){
            instance = new Utils();
            return instance;
        }else{
            return instance;
        }
    }

    public static ArrayList<Book> getAllBooks() {
        return allBooks;
    }

    public static void setAllBooks(ArrayList<Book> allBooks) {
        Utils.allBooks = allBooks;
    }

    public static ArrayList<Book> getAlreadyReadBooks() {
        return alreadyReadBooks;
    }

    public static void setAlreadyReadBooks(ArrayList<Book> alreadyReadBooks) {
        Utils.alreadyReadBooks = alreadyReadBooks;
    }

    public static ArrayList<Book> getWantToReadBooks() {
        return wantToReadBooks;
    }

    public static void setWantToReadBooks(ArrayList<Book> wantToReadBooks) {
        Utils.wantToReadBooks = wantToReadBooks;
    }

    public static ArrayList<Book> getCurrentlyReadingBooks() {
        return currentlyReadingBooks;
    }

    public static void setCurrentlyReadingBooks(ArrayList<Book> currentlyReadingBooks) {
        Utils.currentlyReadingBooks = currentlyReadingBooks;
    }

    public static ArrayList<Book> getFavoriteBook() {
        return favoriteBook;
    }

    public static void setFavoriteBook(ArrayList<Book> favoriteBook) {
        Utils.favoriteBook = favoriteBook;
    }

    private void initData(){
        allBooks.add(new Book("Miracle Morning","Hal Elrod","2017","https://m.media-amazon.com/images/I/51AIz1GrKwL._SL500_.jpg"));
        allBooks.add(new Book("Show Your Work","Austin","2019","https://images-na.ssl-images-amazon.com/images/I/71MTgEEjNVL.jpg"));
    }
    public Book getBookByName(String name){
        for(Book b:allBooks){
            if(b.getName().equals(name)){
                return b;
            }
        }
        return null;
    }
}
