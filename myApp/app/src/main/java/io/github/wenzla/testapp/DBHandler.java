package io.github.wenzla.testapp;

/**
 * Created by Laura on 10/24/2017.
 */

public class DBHandler {
    public static String send(String data) {
        DBRequester dbh = new DBRequester();
        dbh.execute("http://arceus.org/appclass.php",data);
        try {
            return dbh.get();
        } catch (Exception e) {
            return "failed execution";
        }
    }
}
