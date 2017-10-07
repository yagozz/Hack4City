package com.hack4city.hack4city.WebService.Models;

import android.os.AsyncTask;

import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.ExecutionException;

public class WebService {
    private String WebServiceBaseURL="https://hackhaton.izmir.bel.tr/api/";
    private Gson gson;
    DownloadData downloadData;

    public WebService() {
        getData();
        gson=new Gson();
        downloadData = new DownloadData();
    }

    public void getData(){
        DownloadData downloadData = new DownloadData();
        String url="http://api.fixer.io/latest?base=USD";
        downloadData.execute(url);
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

    public IzbanHoursModel getIzbanHoursModel(Integer hareketIstasyonId,Integer varisIstasyonId){

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

    public FerryHoursModel getFerryHoursModel(Integer kalkis,Integer varis,Integer gunTipi){

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
