package com.example.forster;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class LoadingActivity extends AppCompatActivity {
    private static int SPLASH_TIME_OUT=6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);

       // getSupportActionBar().hide();
        LogoLauncher logoLauncher=new LogoLauncher();
        logoLauncher.start();

    }
    private  class LogoLauncher extends Thread{
        public void run(){
            try{
                sleep(1000*SPLASH_TIME_OUT);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            Intent intent=new Intent(LoadingActivity.this,RecyclerviewActivity.class);
            startActivity(intent);
            LoadingActivity.this.finish();
        }
    }
    }

