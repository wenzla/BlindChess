package io.github.wenzla.testapp;

import android.animation.LayoutTransition;
import android.app.Activity;
import android.app.ActivityOptions;
import android.app.Fragment;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Fade;
import android.transition.Scene;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.transition.TransitionManager;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

// also some of my layout element names are ass
public class MainActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_screen);
    }

    @Override
    public void onStart() {
        super.onStart();
        setContentView(R.layout.home_screen);
    }

    @Override
    public void onResume() {
        super.onResume();
        setContentView(R.layout.home_screen);
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    // TODO: this is bad practice so fix it
    public void openSetup(View v) {

        Intent i=new Intent(
                MainActivity.this,
                SetupGame.class);
        startActivity(i);

    }
    // TODO: this is bad practice so fix it
    public void openGPS(View v) {

        Intent i=new Intent(
                MainActivity.this,
                gpsTest.class);
        startActivity(i);

    }

}
