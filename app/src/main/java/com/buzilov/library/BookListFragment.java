package com.buzilov.library;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BookListFragment extends Fragment {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_books_list, container, false);

        List<BookItem> books = Arrays.asList(
                new BookItem(R.drawable.ic_book_item, "Mega book 1", Collections.singletonList("Sci-Fi"), Arrays.asList("Me", "You"), 100, "A very beautiful book number 1"),
                new BookItem(R.drawable.ic_book_item, "Mega book 2", Collections.singletonList("Sci-Fi"), Arrays.asList("Me", "123"), 200, "A very beautiful book number 2"),
                new BookItem(R.drawable.ic_book_item, "Mega book 3", Collections.singletonList("Sci-Fi"), Arrays.asList("Me", "456"), 300, "A very beautiful book number 3"),
                new BookItem(R.drawable.ic_book_item, "Mega book 4", Collections.singletonList("Sci-Fi"), Arrays.asList("Me", "789"), 400, "A very beautiful book number 4")
        );

        recyclerView = view.findViewById(R.id.booksRecyclerView);
        layoutManager = new LinearLayoutManager(getContext());
        adapter = new BookListRecycleViewAdapter(books);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}
