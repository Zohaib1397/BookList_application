package com.example.booklists;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.transition.TransitionManager;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class BookRecViewAdapter extends RecyclerView.Adapter<BookRecViewAdapter.ViewHolder> {
    private ArrayList<Book>books=new ArrayList<>();
    private Context context;

    public BookRecViewAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_book_cardview,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.txtName.setText(books.get(position).getName());
        Glide.with(context)
                .asBitmap()
                .load(books.get(position).getImgURL())
                .into(holder.imageBook);
        holder.parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(context,BookActivity.class);
                intent.putExtra("bookName",books.get(position).getName());
                context.startActivity(intent);
            }
        });
        holder.txtAuthor.setText(books.get(position).getAuthor());
        holder.txtDate.setText(books.get(position).getDate());
        if(books.get(position).isExpended()){
            TransitionManager.beginDelayedTransition(holder.parent);
            holder.expendedLayout.setVisibility(View.VISIBLE);
            holder.imageDownArrow.setVisibility(View.GONE);
        }
        else{
            TransitionManager.beginDelayedTransition(holder.parent);
            holder.expendedLayout.setVisibility(View.GONE);
            holder.imageDownArrow.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public int getItemCount() {
        return books.size();
    }

    public void setBooks(ArrayList<Book> books) {
        this.books = books;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private CardView parent;
        private RelativeLayout expendedLayout;
        private TextView txtName,txtAuthor,txtDate;
        private ImageView imageBook,imageDownArrow,imageUpArrow;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            parent= itemView.findViewById(R.id.cardParent);
            txtName=itemView.findViewById(R.id.txtBookName);
            imageBook=itemView.findViewById(R.id.imageBook);
            imageDownArrow=itemView.findViewById(R.id.imageDownArrow);
            txtAuthor=itemView.findViewById(R.id.txtAuthorName);
            txtDate=itemView.findViewById(R.id.txtDate);
            expendedLayout=itemView.findViewById(R.id.expendedRelativeLayout);
            imageUpArrow=itemView.findViewById(R.id.imageUpArrow);
            imageDownArrow.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Book book= books.get(getAdapterPosition());
                    book.setExpended(!book.isExpended());
                    notifyItemChanged(getAdapterPosition());
                }
            });
            imageUpArrow.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Book book= books.get(getAdapterPosition());
                    book.setExpended(!book.isExpended());
                    notifyItemChanged(getAdapterPosition());
                }
            });
        }
    }
}
