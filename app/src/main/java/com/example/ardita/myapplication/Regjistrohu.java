package com.example.ardita.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Regjistrohu extends AppCompatActivity implements View.OnClickListener {

     Button Regjistrohu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regjistrohu);
        Regjistrohu = (Button) findViewById(R.id.Regjistrohu);
        Regjistrohu.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.Regjistrohu:
                startActivity(new Intent(this, MainActivity.class));
        }
    }
}
