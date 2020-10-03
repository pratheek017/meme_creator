package com.example.memecreator;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.io.Console;

public class TopFragment extends Fragment {

    public interface MemeTextListener{
        void createMeme(String topText, String bottomText);
    }

    private EditText firstEditText;
    private EditText secondEditText;
    private MemeTextListener activityCommander;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        try {
            activityCommander = (MemeTextListener) getActivity();
        } catch (ClassCastException e){
            Log.i("MyTag", "Main activity not acting as the medium of " +
                    "transmission for the bottom fragment");
            throw new ClassCastException();
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.top_fragment, container, false);

        firstEditText = view.findViewById(R.id.topFirstText);
        secondEditText = view.findViewById(R.id.topSecondText);
        Button createMemeButton = view.findViewById(R.id.createMemeButton);

        createMemeButton.setOnClickListener(
                new View.OnClickListener(){
                    public void onClick(View v){
                        onGenerateMemeButtonClicked(v);
                    }
                }
        );

        return view;
    }

    private void onGenerateMemeButtonClicked(View v){
        if (activityCommander != null)
            activityCommander.createMeme(
                    firstEditText.getText().toString(),
                    secondEditText.getText().toString());
    }
}
