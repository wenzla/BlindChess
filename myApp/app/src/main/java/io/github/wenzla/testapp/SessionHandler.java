package io.github.wenzla.testapp;

import android.util.Log;

import 	org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Random;

/**
 * Created by Laura on 11/1/2017.
 */

public class SessionHandler {

    private static String name = "Null Name";
    private static String id;
    private static boolean idSet = false;

    static Random r = new Random();

    private static String TAG = "SessionHandler";

    public static void setData(String n, String i) {
        name=n;
        id=i;
        idSet = true;
    }

    public static void createSession() {
        Log.d(TAG,"createSession");
        if (!idSet) {
            id = ""+ r.nextInt(1000);
        }
        String response = DBHandler.send("SELECT * FROM WaitingSession");
        Log.d(TAG,"createSession: "+response);
        JSONArray r;
        try {
            r = new JSONArray(response);

            if (r.length()>0) {
                JSONObject obj = r.getJSONObject(0);
                String otherID = obj.getString("uid");
                String delete = "DELETE FROM WaitingSession WHERE uid = '"+otherID+"'";
                Log.d(TAG,delete);
                DBHandler.send(delete);
                String insert = "INSERT INTO Session(p1uid, p2uid,turn) VALUES ('"+id+"','"+otherID+"','"+id+"')";
                Log.d(TAG,insert);
                DBHandler.send(insert);
                Log.d(TAG,"session created");
            } else {
                DBHandler.send("INSERT INTO WaitingSession(name,uid) VALUES ('"+name+"','"+id+"')");
                Log.d(TAG,"wait created");
            }
        } catch (JSONException e) {
            Log.e(TAG, "-",e );
        }
    }

    public static boolean sessionConnect() {
        Log.d(TAG,"sessionConnect");
        String response = DBHandler.send("SELECT * FROM Session WHERE p1uid = '"+id+"' OR p2uid = '"+id+"'");
        Log.d(TAG,"sessionConnect: "+response);
        try {
            JSONArray r = new JSONArray(response);
            if (r.length()>0) {
                return true;
            } else {
                return false;
            }
        } catch (JSONException e) {
            Log.e(TAG, "-",e );
        }
        return false;
    }

    public static boolean isMyTurn() {
        Log.d(TAG,"isMyTurn");
        String response = DBHandler.send("SELECT * FROM Session WHERE turn = '"+id+"'");
        Log.d(TAG,"isMyTurn: "+response);
        try {
            JSONArray r = new JSONArray(response);
            if (r.length()>0) {
                return true;
            } else {
                return false;
            }
        } catch (JSONException e) {
            Log.e(TAG, "-",e );
        }
        return true;
    }

    public static void endTurn() {
        Log.d(TAG,"endTurn");
        if (!isMyTurn()) {
            return;
        }
        String response = DBHandler.send("SELECT * FROM Session WHERE turn = '"+id+"'");
        try {
            JSONArray r = new JSONArray(response);
            if (r.length()>0) {
                JSONObject obj = r.getJSONObject(0);
                String id1 = obj.getString("p1uid");
                String id2 = obj.getString("p2uid");
                if (id1.equals(id)) {
                    DBHandler.send("UPDATE Session SET turn = '"+id2+"' WHERE turn = '"+id+"'");
                } else {
                    DBHandler.send("UPDATE Session SET turn = '"+id1+"' WHERE turn = '"+id+"'");
                }
            }
        } catch (JSONException e) {
            Log.e(TAG, "-",e );
        }
    }

    public static void endSession() {
        Log.d(TAG,"endSession");
        DBHandler.send("DELETE FROM WaitingSession WHERE uid = '"+id+"'");
        DBHandler.send("DELETE FROM Session WHERE p1uid = '"+id+"' OR p2uid = '"+id+"'");
    }
}
