package com.example.memecreator;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class BottomFragment extends Fragment {

    private EditText topMemeText;
    private EditText bottomMemeText;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.bottom_fragment, container, false);

        topMemeText = view.findViewById(R.id.topText);
        bottomMemeText = view.findViewById(R.id.bottomText);

        return view;
    }

    public void setMemeText(String topText, String bottomText){
        topMemeText.setText(topText);
        bottomMemeText.setText(bottomText);
    }

}
