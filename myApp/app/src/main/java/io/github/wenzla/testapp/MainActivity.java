package io.github.wenzla.testapp;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_screen);
        ImageButton a = findViewById(R.id.imageButton);
        // Apparently this is the preferred way to do button clicks in Android
        a.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                openSetup(v);
            }
        });
    }

    public void openSetup(View v) {

        Intent i=new Intent(
                MainActivity.this,
                SetupGame.class);
        startActivity(i);

    }

    // You can use this to do button clicks too but it is not recommended
    public void button2Click(View v) {
        Intent i=new Intent(
                MainActivity.this,
                SecondActivity.class);
        startActivity(i);

    }
}
