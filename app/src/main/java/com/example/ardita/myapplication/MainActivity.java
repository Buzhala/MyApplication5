package com.example.ardita.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button Kyqu;
    EditText perdoruesi, Fjalkalimi;
    TextView Regjistrohu;
    //Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        perdoruesi = (EditText) findViewById(R.id.perdoruesi);
        Fjalkalimi = (EditText) findViewById(R.id.Fjalkalimi);
        Kyqu = (Button) findViewById(R.id.Kyqu);
        Regjistrohu = (TextView) findViewById(R.id.Regjistrohu);
      //  toolbar = (Toolbar) findViewById(R.id.toolbar);
      // toolbar.setTitle("Test Mature");
      //  setSupportActionBar(toolbar);
        Kyqu.setOnClickListener(this);
        Regjistrohu.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.Kyqu:

                startActivity(new Intent(this, kyqu.class));
                break;

            case R.id.Regjistrohu:


                startActivity(new Intent(this, Regjistrohu.class));
                break;

        }
    }
}
