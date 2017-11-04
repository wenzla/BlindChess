package io.github.wenzla.testapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import io.github.wenzla.testapp.CanvasView.*;

/**
 * Created by Allen on 10/26/2017.
 */


public class MultiplayerGame extends AppCompatActivity {

    private CanvasView cv;
    TextView   statusView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.multiplayer_setup);

        cv = (CanvasView) findViewById(R.id.signature_canvas);

        statusView  = (TextView) findViewById(R.id.status);

        cv.setCustmViewListener(new CanvasViewListener() {

            @Override
            public void onUpdateValue(String updatedValue) {
                statusView.setText(updatedValue);
            }
        });

    }

    public void clearCanvas(View v){
        cv.clearCanvas();
    }

}


