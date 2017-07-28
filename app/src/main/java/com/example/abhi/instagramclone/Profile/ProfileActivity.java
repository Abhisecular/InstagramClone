package com.example.abhi.instagramclone.Profile;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.example.abhi.instagramclone.R;
import com.example.abhi.instagramclone.Utils.BottomNavigationViewHelper;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

/**
 * Created by Abhi on 22-07-2017.
 */

public class ProfileActivity extends AppCompatActivity {
    private static final int NUM=4;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
       setupBottomNavigationView();
        setupToolBar();
    }
    public void setupToolBar(){
        Toolbar toolbar= (Toolbar)findViewById(R.id.profileToolBar);
        setSupportActionBar(toolbar);
        ImageView profileMenu=(ImageView)findViewById(R.id.profileMenu);
        profileMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(ProfileActivity.this, AccountSettingsActivity.class);
                startActivity(intent);
            }
        });
    }
    public void setupBottomNavigationView(){
        BottomNavigationViewEx bottomNavigationViewEx= (BottomNavigationViewEx) findViewById(R.id.bottomNavViewBar);
        BottomNavigationViewHelper.setupBottomNavigationView(bottomNavigationViewEx);
        BottomNavigationViewHelper.enableNavigation(ProfileActivity.this, bottomNavigationViewEx);
        Menu menu = bottomNavigationViewEx.getMenu();
        MenuItem menuItem=menu.getItem(NUM);
        menuItem.setChecked(true);
    }


}
