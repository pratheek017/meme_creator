package com.example.memecreator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements TopFragment.MemeTextListener {

    BottomFragment bottomFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomFragment = (BottomFragment)getSupportFragmentManager().findFragmentById(R.id.bottonFragment);
    }

    @Override
    public void createMeme(String topText, String bottomText) {
        bottomFragment.setMemeText(topText, bottomText);
    }
}
