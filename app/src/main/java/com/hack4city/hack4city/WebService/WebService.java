package com.hack4city.hack4city.WebService;

import android.os.AsyncTask;

import com.google.gson.Gson;
import com.hack4city.hack4city.WebService.Models.BisimStationsModel;
import com.hack4city.hack4city.WebService.Models.CompleteFerryModel;
import com.hack4city.hack4city.WebService.Models.FerryDockModel;
import com.hack4city.hack4city.WebService.Models.FerryHoursModel;
import com.hack4city.hack4city.WebService.Models.IzbanHoursModel;
import com.hack4city.hack4city.WebService.Models.IzbanStationsModel;
import com.hack4city.hack4city.WebService.Models.MetroHoursModel;
import com.hack4city.hack4city.WebService.Models.MetroStationsModel;
import com.hack4city.hack4city.WebService.Models.TokenModel;
import com.hack4city.hack4city.WebService.Models.TramwayHoursModel;
import com.hack4city.hack4city.WebService.Models.TramwayStationsModel;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WebService {
    private String WebServiceBaseURL="https://hackhaton.izmir.bel.tr/api/";
    private Gson gson;

    DownloadData downloadData;

    public WebService() {

        downloadData = new DownloadData();
        gson=new Gson();

    }

    public String[][] getRouteLatLong(final String hatId){
        final ArrayList<String> lats = new ArrayList<String>();
        final ArrayList<String> lngs = new ArrayList<String>();
        Thread downloaderThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    URL url = new URL("http://www.eshot.gov.tr/tr/UlasimSaatleri/288");
                    HttpURLConnection httpCon = (HttpURLConnection) url.openConnection();
                    httpCon.setDoOutput(true);
                    httpCon.setRequestMethod("POST");
                    OutputStreamWriter out = new OutputStreamWriter(httpCon.getOutputStream());
                    out.write("hatId="+hatId);
                    out.flush();
                    BufferedReader reader = new BufferedReader(new InputStreamReader(httpCon.getInputStream()));
                    String line;
                    boolean markesLineFound = false;

                    while ((line = reader.readLine()) != null) {
                        if(!markesLineFound && line.contains("var markersCizgi = [];"))
                            markesLineFound = true;

                        if(!markesLineFound)
                            continue;
                        String regexString = Pattern.quote("lat: '") + "(.*?)" + Pattern.quote("'.repl");
                        Pattern pattern = Pattern.compile(regexString);
                        Matcher matcher = pattern.matcher(line);
                        while (matcher.find())
                            lats.add(matcher.group(1));

                        regexString = Pattern.quote("lng: '") + "(.*?)" + Pattern.quote("'.repl");
                        pattern = Pattern.compile(regexString);
                        matcher = pattern.matcher(line);
                        while (matcher.find())
                            lngs.add(matcher.group(1));
                    }

                    out.close();
                    reader.close();;


                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
        downloaderThread.start();
        try {
            downloaderThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return new String[][]{lats.toArray(new String[lats.size()]),lngs.toArray(new String[lngs.size()])};
    }

    public BisimStationsModel getBisimStationsModel(){

        try {
            BisimStationsModel bisimStationsModel;

            String data =downloadData.execute(WebServiceBaseURL+"BisimIstasyonlar").get();
            bisimStationsModel = gson.fromJson(data,BisimStationsModel.class);

            return bisimStationsModel;

        } catch (InterruptedException e) {
            e.printStackTrace();
            return null;
        } catch (ExecutionException e) {
            e.printStackTrace();
            return null;
        }
    }

    public MetroHoursModel getMetroHoursModel(){

        try {
            MetroHoursModel metroHoursModel;

            String data=downloadData.execute(WebServiceBaseURL+"MetroSeferSaatleri").get();
            metroHoursModel = gson.fromJson(data,MetroHoursModel.class);
            return metroHoursModel;

        } catch (InterruptedException e) {
            e.printStackTrace();
            return null;
        } catch (ExecutionException e) {
            e.printStackTrace();
            return null;
        }

    }

    public MetroStationsModel getMetroStationsModel(){
        try {
            MetroStationsModel metroStationsModel;
            String data = downloadData.execute(WebServiceBaseURL+"MetroIstasyon").get();
            metroStationsModel = gson.fromJson(data,MetroStationsModel.class);
            return metroStationsModel;

        } catch (InterruptedException e) {
            e.printStackTrace();
            return null;
        } catch (ExecutionException e) {
            e.printStackTrace();
            return null;
        }

    }

    public TramwayStationsModel getTramwayStationsModel(){
        try {
            TramwayStationsModel tramwayStationsModel;
            String data = downloadData.execute(WebServiceBaseURL+"TramvayIstasyon").get();
            tramwayStationsModel = gson.fromJson(WebServiceBaseURL+"TramvayIstasyon",TramwayStationsModel.class);
            return tramwayStationsModel;
        } catch (InterruptedException e) {
            e.printStackTrace();
            return null;
        } catch (ExecutionException e) {
            e.printStackTrace();
            return null;
        }
    }

    public TramwayHoursModel getTramwayHoursModel(){
        try {
            TramwayHoursModel tramwayHoursModel;
            String data = downloadData.execute(WebServiceBaseURL+"TramvayIstasyon").get();
            tramwayHoursModel = gson.fromJson(data,TramwayHoursModel.class);
            return tramwayHoursModel;
        } catch (InterruptedException e) {
            e.printStackTrace();
            return null;
        } catch (ExecutionException e) {
            e.printStackTrace();
            return null;
        }
    }

    public TokenModel getTokenModel(){
        try {
            String data=downloadData.execute(WebServiceBaseURL+"token").get();
            TokenModel tokenModel;
            tokenModel = gson.fromJson(data,TokenModel.class);
            return tokenModel;

        } catch (InterruptedException e) {
            e.printStackTrace();
            return null;
        } catch (ExecutionException e) {
            e.printStackTrace();
            return null;
        }

    }

    public IzbanHoursModel getIzbanHoursModel(Integer hareketIstasyonId, Integer varisIstasyonId){

        try {
            String data=downloadData.execute(WebServiceBaseURL+"IzbanIstasyonlar"+
                    "{"+hareketIstasyonId.toString()+"}/"+varisIstasyonId).get();
            IzbanHoursModel izbanHoursModel = gson.fromJson(data,IzbanHoursModel.class);
            return izbanHoursModel;
        } catch (InterruptedException e) {
            e.printStackTrace();
            return null;
        } catch (ExecutionException e) {
            e.printStackTrace();
            return null;
        }

    }

    public CompleteFerryModel getCompleteFerryModel(Integer iskeleId){
        try {
            String data = downloadData.execute(WebServiceBaseURL+"ArabaliVapurKapasite/{"+iskeleId+"}")
                    .get();
            CompleteFerryModel completeFerryModel = gson.fromJson(data,CompleteFerryModel.class);
            return completeFerryModel;
        } catch (InterruptedException e) {
            e.printStackTrace();
            return null;
        } catch (ExecutionException e) {
            e.printStackTrace();
            return null;
        }
    }

    public IzbanStationsModel getIzbanStationsModel(){
        try {
            String data = downloadData.execute(WebServiceBaseURL+"IzbanIstasyonlar").get();
            IzbanStationsModel izbanStationsModel = gson.fromJson(data,IzbanStationsModel.class);
            return izbanStationsModel;
        } catch (InterruptedException e) {
            e.printStackTrace();
            return null;
        } catch (ExecutionException e) {
            e.printStackTrace();
            return null;
        }

    }

    public FerryDockModel getFerryDockModel(){
        try {
            String data = downloadData.execute(WebServiceBaseURL+"VapurIskeleleri").get();
            FerryDockModel ferryDockModel;
            ferryDockModel = gson.fromJson(WebServiceBaseURL+"VapurIskeleleri",FerryDockModel.class);
            return ferryDockModel;
        } catch (InterruptedException e) {
            e.printStackTrace();
            return null;
        } catch (ExecutionException e) {
            e.printStackTrace();
            return null;
        }

    }

    public FerryHoursModel getFerryHoursModel(Integer kalkis, Integer varis, Integer gunTipi){

        try {
            FerryHoursModel ferryHoursModel;
            String data=downloadData.execute(WebServiceBaseURL+"VapurSaatleri" +
                    "/{"+kalkis+"}/{"+varis+"}/{"+gunTipi+"}/").get();

            ferryHoursModel = gson.fromJson(data,FerryHoursModel.class);
            return ferryHoursModel  ;

        } catch (InterruptedException e) {
            e.printStackTrace();
            return null;
        } catch (ExecutionException e) {
            e.printStackTrace();
            return null;
        }

    }

    private class DownloadData extends AsyncTask<String,Void,String> {

        @Override
        protected String doInBackground(String... params) {
            String result = "";
            URL url;
            HttpURLConnection httpURLConnection;

            try {
                url = new URL(params[0]);
                httpURLConnection = (HttpURLConnection) url.openConnection();
                InputStream inputStream = httpURLConnection.getInputStream();
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);

                int data = inputStreamReader.read();
                while (data > 0) {
                    char charData = (char) data;
                    result += charData;
                    data = inputStreamReader.read();
                }
                return result;

            } catch (MalformedURLException e) {
                e.printStackTrace();
                return null;
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

            try {
                JSONObject jsonObject = new JSONObject(s);
                String base = jsonObject.getString("base");
                String date = jsonObject.getString("date");
                String rates = jsonObject.getString("rates");

                System.out.println(base + " \n" + date + " \n" + rates);


            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
    }



}