package com.hack4city.hack4city;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = (EditText) findViewById(R.id.editText);

    }

    public void loadMenu(View view){
        EditText text = (EditText) findViewById(R.id.editText);
        if(text.getText().toString().length()>10){
            Intent intent = new Intent(MainActivity.this,TabbedActivity.class);
            startActivity(intent);
        }else{
            Toast.makeText(this, "Lütfen 11 haneli bir sayı giriniz.", Toast.LENGTH_SHORT).show();
        }

    }


}
