package io.github.wenzla.testapp;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
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

    private int mInterval = 3000;
    private Handler mHandler;

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

        SessionHandler.createSession();

        mHandler = new Handler();
        startRepeatingTask();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        stopRepeatingTask();
        SessionHandler.endSession();
    }

    void startRepeatingTask() {
        mStatusChecker.run();
    }

    void stopRepeatingTask() {
        mHandler.removeCallbacks(mStatusChecker);
    }

    private void setTurn(boolean turn) {
        if (turn) {
            statusView.setText("Your turn");
            cv.setMyColor(Color.WHITE);
            SessionHandler.setStatus(0);
        } else {
            statusView.setText("Opponent's turn");
            cv.setMyColor(Color.BLACK);
            SessionHandler.setStatus(1);
        }
    }

    protected void updateStatus() {
        if (SessionHandler.status()==1) {
            if (SessionHandler.sessionConnect()) {
                statusView.setText("Connected.");
                setTurn(SessionHandler.isMyTurn());
            }
        }
        if (SessionHandler.status()==2) {
            if (SessionHandler.isMyTurn()) {
                statusView.setText("Your turn");
                Move m = SessionHandler.getLastMove();
                Piece p = cv.getBoard().getPieceAtLocation(m.from());
                cv.getBoard().move(p,m.from(),m.to());
                SessionHandler.setStatus(0);
            }
        }
    }

    Runnable mStatusChecker = new Runnable() {
        @Override
        public void run() {
            try {
                updateStatus();
            } finally {
                // 100% guarantee that this always happens
                mHandler.postDelayed(mStatusChecker, mInterval);
            }
        }
    };

    public void clearCanvas(View v){
        cv.clearCanvas();
    }

}


