package com.example.ardita.myapplication;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Activity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.view.View.OnClickListener;
import android.widget.*;
public class kyqu extends AppCompatActivity implements AdapterView.OnItemSelectedListener, OnClickListener {

    String[] Drejtimi = { "Shkenca natyrore", "Shkenca shoqerore", "Mjeksia", "Shkolla teknike" };
    CheckBox matematike,fizike,biologji,gjuheshqipe,gjuheangleze,kimi;
    Button vazhdo;
 private DrawerLayout Drawer;
 private ActionBarDrawerToggle Toggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kyqu);

        Spinner spin = (Spinner) findViewById(R.id.Spinner);
        spin.setOnItemSelectedListener(this);
        addListenerOnButtonClick();
        vazhdo.setOnClickListener(this);
        Drawer = (DrawerLayout) findViewById(R.id.drawer);
        Toggle = new ActionBarDrawerToggle(this, Drawer, R.string.Hape, R.string.Mbylle);
       Drawer.addDrawerListener(Toggle);
        NavigationView Navigation = (NavigationView) findViewById(R.id.nv);
        Toggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        DrawerContent(Navigation);

        //Creating the ArrayAdapter instance having the country list
        ArrayAdapter aa = new ArrayAdapter(this,android.R.layout.simple_spinner_item,Drejtimi);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        spin.setAdapter(aa);
    }
    public  void zgjedhAksionin (MenuItem menuItem) {
        android.support.v4.app.Fragment fragment = null;
         Class Klasa = null;
        switch (menuItem.getItemId()) {
            case R.id.histroriku:
                Klasa = Historiku.class;
                break;
            case R.id.Rregullime:
                Klasa = Rregullime.class;
                break;
            case R.id.Shkyqu:
                Klasa = Shkyqu.class;
                break;

        }

        try {
            fragment = (android.support.v4.app.Fragment) Klasa.newInstance();

        } catch (Exception e) {
            e.printStackTrace();
        }
        android.support.v4.app.FragmentManager menaxher = getSupportFragmentManager();
        menaxher.beginTransaction().replace(R.id.Frame, fragment).commit();
        menuItem.setChecked(true);
        setTitle(menuItem.getTitle());
        Drawer.closeDrawers();
    }
    private void DrawerContent (NavigationView navigationView){

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                zgjedhAksionin(item);
                return true;
            }
        });
    }
/*
    @Override
  public boolean onOptionsItemSelected(MenuItem item) {
        if (Toggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    } */

    private void addListenerOnButtonClick()
    {
        matematike=(CheckBox)findViewById(R.id.lenda1);
        fizike=(CheckBox)findViewById(R.id.lenda2);
        biologji=(CheckBox)findViewById(R.id.lenda3);
        gjuheshqipe=(CheckBox)findViewById(R.id.lenda4);
        gjuheangleze=(CheckBox)findViewById(R.id.lenda5);
        kimi=(CheckBox)findViewById(R.id.lenda6);
        vazhdo=(Button)findViewById(R.id.vazhdo);

    }


    //Performing action onItemSelected and onNothing selected
    @Override
    public void onItemSelected(AdapterView<?> arg0, View arg1, int position,long id) {
        Toast.makeText(getApplicationContext(),Drejtimi[position] ,Toast.LENGTH_LONG).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.vazhdo:

                startActivity(new Intent(this, info.class));
                break;
        }
    }
}
