package com.eshreef.help;

import android.os.Bundle;

import com.eshreef.help.common.common;
import com.eshreef.help.freg.DiseasesFragment;
import com.eshreef.help.freg.home;
import com.eshreef.help.freg.MessagesFragment;
import com.eshreef.help.freg.MedicineFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.core.view.GravityCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.navigation.NavigationView;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener  {

    private AppBarConfiguration mAppBarConfiguration;
    TextView curentuser;

    private static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        final DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        BottomNavigationView  bottomNavigationView = findViewById(R.id.bottom_nav_view);
        View haderview = navigationView.getHeaderView(0);
        curentuser = haderview.findViewById(R.id.curentuser);
      //  curentuser.setText(common.carentuser.getUsername());


        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawer.openDrawer(GravityCompat.START);
            }
        });

      //  bottomNavigationView.setSelectedItemId(R.id.s); home selected item
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(R.id.nav_home, R.id.nav_gallery).setDrawerLayout(drawer).build();
       NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);


        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        bottomNavigationView.setSelectedItemId(R.id.home);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.home:
                        getSupportFragmentManager().beginTransaction().setCustomAnimations(R.anim.fed_in,R.anim.fed_out).replace(R.id.nav_host_fragment,ho).commit();
                        return true;
                    case R.id.mental_list:
                        getSupportFragmentManager().beginTransaction().setCustomAnimations(R.anim.fed_in,R.anim.fed_out).replace(R.id.nav_host_fragment,di).commit();
                        return true;

                    case R.id.medson:
                        getSupportFragmentManager().beginTransaction().setCustomAnimations(R.anim.fed_in,R.anim.fed_out).replace(R.id.nav_host_fragment,med).commit();
                        return true;

                    case R.id.message:
                        getSupportFragmentManager().beginTransaction().setCustomAnimations(R.anim.fed_in,R.anim.fed_out).replace(R.id.nav_host_fragment,ma).commit();
                        return true;
                    // make some fregment

                }
                    return false;
            }
        });


//        bottomNavigationView.inflateMenu(R.menu.bottom_menu);



    }

    DiseasesFragment di = new DiseasesFragment();
    home ho = new home();
    MessagesFragment ma = new MessagesFragment();
    MedicineFragment med = new MedicineFragment();


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {

            // make some fregment

        }

        return false;
    }


}
