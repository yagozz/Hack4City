package com.hack4city.hack4city;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.hack4city.hack4city.WebService.Models.JSONParserExample;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        JSONParserExample x = new JSONParserExample();
        Log.d("Baro",x.myTokenModel.getAccess_token());
    }
}
