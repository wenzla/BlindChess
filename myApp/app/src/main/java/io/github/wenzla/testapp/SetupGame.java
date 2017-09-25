package io.github.wenzla.testapp;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by Allen on 9/17/2017.
 */

public class SetupGame extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_setup_layout);
        Button playerBlack = findViewById(R.id.blackButton);
        Button playerWhite = findViewById(R.id.whiteButton);
        // this is good
        playerWhite.setOnClickListener(playerColorChange);
        playerBlack.setOnClickListener(playerColorChange);
    }

    private View.OnClickListener playerColorChange = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Button playerBlack = findViewById(R.id.blackButton);
            Button playerWhite = findViewById(R.id.whiteButton);
            switch(v.getId()){
                case R.id.whiteButton:
                case R.id.blackButton:
                    CharSequence white = playerWhite.getText();
                    CharSequence black = playerBlack.getText();
                    playerWhite.setText(black);
                    playerBlack.setText(white);
                    break;
            }
        }
    };

}
