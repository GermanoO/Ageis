package com.joaopaulo.cap3.activity;

import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.joaopaulo.cap3.R;

import livroandroid.lib.fragment.NavigationDrawerFragment;

public class HomeActivity extends AppCompatActivity {

    DrawerLayout drawerLayout;
    Toolbar toolbar;
    ActionBar actionBar;
    TextView textView;
    String login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        //Recebe parametro "login" da activity anterior
        Bundle args = getIntent().getExtras();
        login = args.getString("login");
        //Define toolbar
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        actionBar = getSupportActionBar();
        //actionBar.setHomeAsUpIndicator(TODO: icone do menu);
        actionBar.setDisplayHomeAsUpEnabled(true);


        //Implementação do navigation drawer
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        NavigationView navigationView = (NavigationView) drawerLayout.findViewById(R.id.navigation_view);
        View headerView = navigationView.inflateHeaderView(R.layout.navigation_drawer_header);
        TextView tvNome = (TextView) headerView.findViewById(R.id.tvNomeNavHeader);
        tvNome.setText(login);
        if (navigationView != null) {
            setupNavigationDrawerContent(navigationView);
        }
        setupNavigationDrawerContent(navigationView);


        //Welcome msg
        TextView msgBoasVindas = (TextView) findViewById(R.id.tvCardPerfil);
        msgBoasVindas.setText("Bem vindo " + login + "!");
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                Toast.makeText(this, "TESTE", Toast.LENGTH_SHORT).show();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }


    private void setupNavigationDrawerContent(NavigationView navigationView) {
        navigationView.setNavigationItemSelectedListener(
            new NavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(MenuItem menuItem) {
                    switch (menuItem.getItemId()) {
                        case R.id.item_navigation_drawer_inbox:
                            menuItem.setChecked(true);
                            textView.setText(menuItem.getTitle());
                            drawerLayout.closeDrawer(GravityCompat.START);
                            return true;
                        case R.id.item_navigation_drawer_starred:
                            menuItem.setChecked(true);
                            textView.setText(menuItem.getTitle());
                            drawerLayout.closeDrawer(GravityCompat.START);
                            return true;
                        case R.id.item_navigation_drawer_sent_mail:
                            menuItem.setChecked(true);
                            textView.setText(menuItem.getTitle());
                            drawerLayout.closeDrawer(GravityCompat.START);
                            return true;
                        case R.id.item_navigation_drawer_drafts:
                            menuItem.setChecked(true);
                            textView.setText(menuItem.getTitle());
                            drawerLayout.closeDrawer(GravityCompat.START);
                            return true;
                        /*case R.id.item_navigation_drawer_settings:
                            menuItem.setChecked(true);
                            textView.setText(menuItem.getTitle());
                            Toast.makeText(MainActivity.this, "Launching " + menuItem.getTitle().toString(), Toast.LENGTH_SHORT).show();
                            drawerLayout.closeDrawer(GravityCompat.START);
                            Intent intent = new Intent(MainActivity.this, SettingsActivity.class);
                            startActivity(intent);
                            return true;
                        case R.id.item_navigation_drawer_help_and_feedback:
                            menuItem.setChecked(true);
                            Toast.makeText(MainActivity.this, menuItem.getTitle().toString(), Toast.LENGTH_SHORT).show();
                            drawerLayout.closeDrawer(GravityCompat.START);
                            return true;*/
                    }
                    return true;
                }
            }
        );
    }
}
