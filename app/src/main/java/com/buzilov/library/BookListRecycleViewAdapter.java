package com.buzilov.library;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class BookListRecycleViewAdapter extends RecyclerView.Adapter<BookListRecycleViewAdapter.BookListRecycleViewHolder> {

    private List<BookItem> books;

    public BookListRecycleViewAdapter(List<BookItem> books) {
        this.books = books;
    }

    @NonNull
    @Override
    public BookListRecycleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.book_item, parent, false);
        return new BookListRecycleViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull BookListRecycleViewHolder holder, int position) {
        BookItem currentItem = books.get(position);
        holder.imageView.setImageResource(currentItem.getImageResource());
        holder.description.setText(currentItem.getDescription());
        holder.pagesCountPlaceholder.setText(String.valueOf(currentItem.getPages()));
        holder.authorsPlaceholder.setText(currentItem.getAuthors());
        holder.genresPlaceholder.setText(currentItem.getGenres());
        holder.name.setText(currentItem.getName());
        holder.year.setText(String.valueOf(currentItem.getYear()));
    }

    @Override
    public int getItemCount() {
        return books.size();
    }

    public static class BookListRecycleViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public ImageView imageView;
        public TextView genresPlaceholder,
                        authorsPlaceholder,
                        pagesCountPlaceholder,
                        description,
                        name,
                        year;

        public BookListRecycleViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            genresPlaceholder = itemView.findViewById(R.id.bookGenresPlaceholder);
            authorsPlaceholder = itemView.findViewById(R.id.bookAuthorsPlaceholder);
            pagesCountPlaceholder = itemView.findViewById(R.id.bookPagesCountPlaceholder);
            description = itemView.findViewById(R.id.bookDesc);
            name = itemView.findViewById(R.id.bookName);
            year = itemView.findViewById(R.id.bookYearPlaceholder);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            Bundle args = new Bundle();
            args.putString("bookTitle", name.getText().toString());
            args.putString("bookDescription", description.getText().toString());
            args.putString("bookAuthors", authorsPlaceholder.getText().toString());
            args.putString("bookGenres", genresPlaceholder.getText().toString());
            args.putInt("bookPages", Integer.valueOf(pagesCountPlaceholder.getText().toString()));
            args.putInt("bookYear", Integer.valueOf(year.getText().toString()));
            EditBookFragment editBookFragment = new EditBookFragment();
            editBookFragment.setArguments(args);

            AppCompatActivity activity = (AppCompatActivity) v.getContext();
            FragmentManager supportFragmentManager = activity.getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = supportFragmentManager
                    .beginTransaction();
            fragmentTransaction
                    .replace(R.id.fragment_container, editBookFragment)
                    .addToBackStack(null)
                    .commit();
            supportFragmentManager.executePendingTransactions();
        }
    }

}
