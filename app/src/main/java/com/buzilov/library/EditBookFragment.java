package com.buzilov.library;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.buzilov.library.db.repository.BooksRepository;
import com.buzilov.library.model.Book;

public class EditBookFragment extends Fragment {

    EditText editBookTitle;

    EditText editBookDescription;

    EditText editBookAuthors;

    EditText editBookGenres;

    EditText editBookPages;

    EditText editBookYear;

    TextView editBookId;

    Book book;

    public EditBookFragment() {
        super();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_edit_book, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        editBookTitle = getActivity().findViewById(R.id.editBookTitle);
        editBookDescription = getActivity().findViewById(R.id.editBookDescription);
        editBookPages = getActivity().findViewById(R.id.editBookPages);
        editBookGenres = getActivity().findViewById(R.id.editBookGenres);
        editBookAuthors = getActivity().findViewById(R.id.editBookAuthors);
        editBookYear = getActivity().findViewById(R.id.editBookYear);
        editBookId = getActivity().findViewById(R.id.editBookId);

        Bundle args = getArguments();
        if (args != null) {
            editBookTitle.setText(args.getString("bookTitle"));
            editBookDescription.setText(args.getString("bookDescription"));
            editBookAuthors.setText(args.getString("bookAuthors"));
            editBookGenres.setText(args.getString("bookGenres"));
            editBookPages.setText(String.valueOf(args.getInt("bookPages")));
            editBookYear.setText(String.valueOf(args.getInt("bookYear")));
            editBookId.setText(String.valueOf(args.getInt("bookId")));
        }

        view.findViewById(R.id.saveBookBtn).setOnClickListener((l) -> {
            BooksRepository booksRepository = new BooksRepository();
            if (!editBookId.getText().toString().isEmpty()) {
                booksRepository.update(getUpdatedBook(), Long.valueOf(editBookId.getText().toString()));
                Toast.makeText(this.getContext(), "The book has been successfuly updated!", Toast.LENGTH_SHORT).show();
            } else {
                booksRepository.create(getUpdatedBook());
                Toast.makeText(this.getContext(), "The book has been successfuly created!", Toast.LENGTH_SHORT).show();
            }
            AppCompatActivity activity = (AppCompatActivity) view.getContext();
            FragmentManager supportFragmentManager = activity.getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = supportFragmentManager
                    .beginTransaction();
            fragmentTransaction
                    .replace(R.id.fragment_container, new BookListFragment())
                    .addToBackStack(null)
                    .commit();
            supportFragmentManager.executePendingTransactions();
        });
    }

    private Book getUpdatedBook() {
        final Book book = new Book();
        book.setTitle(editBookTitle.getText().toString());
        book.setDescription(editBookDescription.getText().toString());
        book.setAuthors(editBookAuthors.getText().toString());
        book.setGenres(editBookGenres.getText().toString());
        book.setPagesCount(Integer.valueOf(editBookPages.getText().toString()));
        book.setYear(Integer.valueOf(editBookYear.getText().toString()));
        return book;
    }
}
