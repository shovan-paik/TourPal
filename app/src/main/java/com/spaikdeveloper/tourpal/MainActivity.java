package com.spaikdeveloper.tourpal;

import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
        implements BottomNavigationView.OnNavigationItemSelectedListener,
        HomeFragment.AddEventListener {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView navView = findViewById(R.id.nav_view);
        navView.setOnNavigationItemSelectedListener(this);

        loadFragment(new HomeFragment());
    }


    private boolean loadFragment(Fragment fragment){
        if(fragment != null){
            getSupportFragmentManager()
            .beginTransaction()
            .replace(R.id.fragmentContainerFL,fragment)
            .commit();
            return true;
        }


        return false;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        Fragment fragment = null;

        switch (menuItem.getItemId()){
            case R.id.navigation_home:
                fragment = new HomeFragment();
                break;

            case R.id.navigation_map:
                fragment = new MapFragment();
                break;

            case R.id.navigation_weather:
                fragment = new WeatherFragment();
                break;

        }

        return loadFragment(fragment);
    }

    @Override
    public void onAddEventListener() {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragmentContainerFL,new InputEventInformationFragment())
                .commit();
    }
}
