package com.hack4city.hack4city;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;


public class DatabaseManager {
    public static void sendPost(final String date,final String hatId,final String durakId,final String l_lat,final String l_lng) {
        Thread processor = new Thread(new Runnable() {
            @Override
            public void run() {
                String urlParameters = "date=" + date + "&" +
                        "hatId=" + hatId + "&" +
                        "durakId=" + durakId + "&" +
                        "l_lat=" + l_lat + "&" +
                        "l_lng=" + l_lng;

                try {
                    URL url = new URL("http://h4cjetgiller.byethost32.com/db.php");
                    URLConnection con = url.openConnection();
                    con.setDoOutput(true);
                    PrintStream ps = new PrintStream(con.getOutputStream());
                    ps.print(urlParameters);
                    con.getInputStream();
                    ps.close();
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        processor.start();
        try {
            processor.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
