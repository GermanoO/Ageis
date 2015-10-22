package com.joaopaulo.cap3.activity;

import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import com.joaopaulo.cap3.R;

import livroandroid.lib.fragment.NavigationDrawerFragment;

public class HomeActivity extends AppCompatActivity {

    private NavigationDrawerFragment mNavDrawerFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        mNavDrawerFragment = (NavigationDrawerFragment) getSupportFragmentManager().
                findFragmentById(R.id.nav_drawer_fragment);

        DrawerLayout drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
       // mNavDrawerFragment.setUp(drawerLayout);

        Bundle args = getIntent().getExtras();
        String login = args.getString("login");

        TextView msgBoasVindas = (TextView) findViewById(R.id.tvCardPerfil);
        msgBoasVindas.setText("Bem vindo " + login + "!");
        //msgBoasVindas.setTextSize(20);

    }
}
