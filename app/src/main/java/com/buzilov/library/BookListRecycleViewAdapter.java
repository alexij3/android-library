package com.buzilov.library;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.buzilov.library.db.repository.BooksRepository;

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
        holder.id.setText(String.valueOf(currentItem.getId()));
    }

    @Override
    public int getItemCount() {
        return books.size();
    }

    public static class BookListRecycleViewHolder extends RecyclerView.ViewHolder {

        public ImageView imageView;
        public TextView genresPlaceholder,
                        authorsPlaceholder,
                        pagesCountPlaceholder,
                        description,
                        name,
                        year,
                        id;

        public BookListRecycleViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            genresPlaceholder = itemView.findViewById(R.id.bookGenresPlaceholder);
            authorsPlaceholder = itemView.findViewById(R.id.bookAuthorsPlaceholder);
            pagesCountPlaceholder = itemView.findViewById(R.id.bookPagesCountPlaceholder);
            description = itemView.findViewById(R.id.bookDesc);
            name = itemView.findViewById(R.id.bookName);
            year = itemView.findViewById(R.id.bookYearPlaceholder);
            id = itemView.findViewById(R.id.bookId);
            itemView.findViewById(R.id.editBook).setOnClickListener((l) -> handleEditBookBtnClick(itemView));
            itemView.findViewById(R.id.deleteBook).setOnClickListener((l) -> handleDeleteBookBtnClick());
        }

        private void handleDeleteBookBtnClick() {
            try {
                new BooksRepository().deleteById(Long.valueOf(id.getText().toString()));
                Toast.makeText(this.itemView.getContext(), "Successfully deleted the book!", Toast.LENGTH_SHORT).show();
                AppCompatActivity activity = (AppCompatActivity) this.itemView.getContext();
                FragmentManager supportFragmentManager = activity.getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = supportFragmentManager
                        .beginTransaction();
                fragmentTransaction
                        .replace(R.id.fragment_container, new BookListFragment())
                        .addToBackStack(null)
                        .commit();
                supportFragmentManager.executePendingTransactions();
            } catch (Exception e) {
                Toast.makeText(this.itemView.getContext(), "Error", Toast.LENGTH_SHORT).show();
            }
        }

        private void handleEditBookBtnClick(View v) {
            Bundle args = new Bundle();
            args.putString("bookTitle", name.getText().toString());
            args.putString("bookDescription", description.getText().toString());
            args.putString("bookAuthors", authorsPlaceholder.getText().toString());
            args.putString("bookGenres", genresPlaceholder.getText().toString());
            args.putInt("bookPages", Integer.valueOf(pagesCountPlaceholder.getText().toString()));
            args.putInt("bookYear", Integer.valueOf(year.getText().toString()));
            args.putInt("bookId", Integer.valueOf(id.getText().toString()));
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
