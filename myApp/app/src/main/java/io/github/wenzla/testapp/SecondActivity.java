package io.github.wenzla.testapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by Allen on 9/13/2017.
 */

public class SecondActivity extends AppCompatActivity {
// This activity was just here to help me learn Android
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Button a = findViewById(R.id.button3);
        a.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                goBack(v);
            }
        });
    }

    public void goBack(View v) {
        Intent i=new Intent(
                SecondActivity.this,
                MainActivity.class);
        startActivity(i);
    }

}
