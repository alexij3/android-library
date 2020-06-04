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

import com.buzilov.library.db.DatabaseHelper;
import com.buzilov.library.db.repository.BooksRepository;
import com.buzilov.library.dto.Book;

import java.util.ArrayList;
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

        DatabaseHelper databaseHelper = new DatabaseHelper(getContext());
        BooksRepository booksRepository = new BooksRepository(databaseHelper);

        List<Book> books = booksRepository.getAll();
        List<BookItem> bookItems = new ArrayList<>();

        for (Book book : books) {
            bookItems.add(BookItem.from(book));
        }

        recyclerView = view.findViewById(R.id.booksRecyclerView);
        layoutManager = new LinearLayoutManager(getContext());
        adapter = new BookListRecycleViewAdapter(bookItems);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}
