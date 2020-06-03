package com.buzilov.library;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
import java.util.stream.Collectors;

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
        holder.authorsPlaceholder.setText(currentItem.getAuthorsListAsString());
        holder.genresPlaceholder.setText(currentItem.getGenresListAsString());
        holder.name.setText(currentItem.getName());
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
                        name;

        public BookListRecycleViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            genresPlaceholder = itemView.findViewById(R.id.bookGenresPlaceholder);
            authorsPlaceholder = itemView.findViewById(R.id.bookAuthorsPlaceholder);
            pagesCountPlaceholder = itemView.findViewById(R.id.bookPagesCountPlaceholder);
            description = itemView.findViewById(R.id.bookDesc);
            name = itemView.findViewById(R.id.bookName);
        }
    }

}
