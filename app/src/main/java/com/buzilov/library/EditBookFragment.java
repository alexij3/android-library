package com.buzilov.library;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class EditBookFragment extends Fragment {

    EditText editBookTitle;

    EditText editBookDescription;

    EditText editBookAuthors;

    EditText editBookGenres;

    EditText editBookPages;

    EditText editBookYear;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return null;
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

        Bundle args = getArguments();
        if (args != null) {
            editBookTitle.setText(args.getString("bookTitle"));
            editBookDescription.setText(args.getString("bookDescription"));
            editBookAuthors.setText(args.getString("bookAuthors"));
            editBookGenres.setText(args.getString("bookGenres"));
            editBookPages.setText(args.getString("bookPages"));
            editBookYear.setText(args.getString("bookYear"));
        }
    }
}
