package io.github.wenzla.testapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import android.support.v4.app.Fragment;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by Allen on 10/20/2017.
 */

public class FBTest extends Fragment{

    LoginButton loginButton;
    TextView t;

    @Override
    public View onCreateView(
            LayoutInflater inflater,
            ViewGroup container,
            Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.splash, container, false);
        t = view.findViewById(R.id.fbText);

        loginButton = (LoginButton) view.findViewById(R.id.login_button);
        loginButton.setReadPermissions("email");
        // If using in a fragment
        loginButton.setFragment(this);
        // Other app specific specialization

        CallbackManager callbackManager = new CallbackManager() {
            @Override
            public boolean onActivityResult(int requestCode, int resultCode, Intent data) {
                return false;
            }
        };

        // Callback registration
        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                String s = "Successful Login";
                t.setText(s);
            }

            @Override
            public void onCancel() {
                String s = "Canceled Login";
                t.setText(s);
            }

            @Override
            public void onError(FacebookException exception) {
                String s = "Error Login";
                t.setText(s);
            }
        });

        return view;
    }
}
