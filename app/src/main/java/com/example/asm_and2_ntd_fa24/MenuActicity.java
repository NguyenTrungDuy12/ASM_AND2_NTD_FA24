package com.example.asm_and2_ntd_fa24;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import com.google.android.material.navigation.NavigationView;

public class MenuActicity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    Toolbar toolbar;
    DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_menu_acticity);

        toolbar = findViewById(R.id.home_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        drawerLayout = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle drawerToggle = new ActionBarDrawerToggle(MenuActicity.this, drawerLayout,
                toolbar,R.string.open, R.string.close);

        drawerToggle.setDrawerIndicatorEnabled(true);
        drawerToggle.syncState();
        drawerLayout.addDrawerListener(drawerToggle);

        NavigationView navView = findViewById(R.id.nav_view);
        navView.setNavigationItemSelectedListener((NavigationView.OnNavigationItemSelectedListener) this);
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment fragment;
        if(item.getItemId() == R.id.item_home){
            Toast.makeText(getApplicationContext(), "Product management", Toast.LENGTH_SHORT).show();
            toolbar.setTitle("Product management");
            fragment = ProducFragment.newInstance();
            getSupportFragmentManager().beginTransaction().replace(R.id.frame_content, fragment).commit();

        } else if (item.getItemId() == R.id.item_loop) {
            Toast.makeText(getApplicationContext(), "Loop", Toast.LENGTH_SHORT).show();
            toolbar.setTitle("Loop");
            fragment = LoopFragment.newInstance();
            getSupportFragmentManager().beginTransaction().replace(R.id.frame_content, fragment).commit();

        } else if (item.getItemId() == R.id.item_setting) {
            Toast.makeText(getApplicationContext(), "Settings", Toast.LENGTH_SHORT).show();
            toolbar.setTitle("Settings");
            fragment = SettingsFragment.newInstance();
            getSupportFragmentManager().beginTransaction().replace(R.id.frame_content, fragment).commit();

        } else if (item.getItemId() == R.id.item_logout) {
            Toast.makeText(getApplicationContext(), "Logout", Toast.LENGTH_SHORT).show();
            toolbar.setTitle("Logout");
        }
        drawerLayout.closeDrawers();
        return true;
    }
}