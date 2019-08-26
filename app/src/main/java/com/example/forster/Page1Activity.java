package com.example.forster;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Page1Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page1);
    }

    public void Movetologin(View view) {
        startActivity(new Intent(Page1Activity.this, MainActivity.class));

    }

    public void movetoreg(View view) {
        startActivity(new Intent(Page1Activity.this, SignUpActivity.class));

    }

    public void gotoaboutus(View view) {
        startActivity(new Intent(Page1Activity.this, AboutusActivity.class));

    }

    public void MovetoAdmin(View view) {
        startActivity(new Intent(Page1Activity.this, AdminLoginActivity.class));

    }
}
