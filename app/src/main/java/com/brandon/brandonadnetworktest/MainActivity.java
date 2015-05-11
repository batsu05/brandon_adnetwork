package com.brandon.brandonadnetworktest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.appnext.appnextsdk.*;
import com.appnext.appnextsdk.API.AppnextAPI;
import com.appnext.appnextsdk.API.AppnextAdRequest;

import java.util.ArrayList;



public class MainActivity extends ActionBarActivity {





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Appnext button
        Button btnAppnext = (Button)findViewById(R.id.btn_appnext);
        btnAppnext.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AppnextActivity.class);
                startActivity(intent);
            }
        });

        // Mopub button
        Button btnMopub = (Button)findViewById(R.id.btn_mopub);
        btnMopub.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(MainActivity.this, MopubActivity.class);
                startActivity(intent);
            }
        });

        // Admob Banner button
        Button btnAdmobBanner = (Button)findViewById(R.id.btn_admob_banner);
        btnAdmobBanner.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(MainActivity.this, AdmobBanActivitiy.class);
                startActivity(intent);
            }
        });

        // Admob Interstitial button
        Button btnAdmobInt = (Button)findViewById(R.id.btn_admob_inter);
        btnAdmobInt.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(MainActivity.this, AdmobIntActivity.class);
                startActivity(intent);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
