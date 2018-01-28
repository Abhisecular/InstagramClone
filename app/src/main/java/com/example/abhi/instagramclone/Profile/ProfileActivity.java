package com.example.abhi.instagramclone.Profile;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.example.abhi.instagramclone.R;
import com.example.abhi.instagramclone.Utils.BottomNavigationViewHelper;
import com.example.abhi.instagramclone.Utils.GridImageAdapter;
import com.example.abhi.instagramclone.Utils.UniversalImageLoader;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

import java.util.ArrayList;

/**
 * Created by Abhi on 22-07-2017.
 */

public class ProfileActivity extends AppCompatActivity {
    private static final int NUM=4;
    ImageView profilePhoto;
    Context mContext;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        mContext = this;
        profilePhoto = (ImageView) findViewById(R.id.profile_photo);
        setProfileImage();
        setupBottomNavigationView();
        setupToolBar();
        tempGridSetup();
    }

    private void tempGridSetup(){
        ArrayList<String> imgURLs = new ArrayList<>();
        imgURLs.add("http://s1.picswalls.com/thumbs2/2015/12/12/beautiful-desktop-wallpapers_015709841_294.jpg");
        imgURLs.add("http://s1.picswalls.com/thumbs2/2015/12/12/awesome-beautiful-wallpaper_015716926_294.jpg");
        imgURLs.add("http://s1.picswalls.com/thumbs2/2015/12/12/beautiful-background_015715938_294.jpg");
        imgURLs.add("http://s1.picswalls.com/thumbs2/2015/12/12/beautiful-backgrounds_015714603_294.jpg");
        imgURLs.add("http://s1.picswalls.com/thumbs2/2015/12/12/beautiful-beautiful-wallpaper_015713634_294.jpg");
        imgURLs.add("http://s1.picswalls.com/thumbs2/2015/12/12/beautiful-desktop-background_015712668_294.jpg");
        imgURLs.add("http://s1.picswalls.com/thumbs2/2015/12/12/beautiful-desktop-wallpaper_015710759_294.jpg");
        imgURLs.add("http://s1.picswalls.com/thumbs2/2015/12/12/beautiful-desktop-backgrounds_015711718_294.jpg");
        imgURLs.add("http://s1.picswalls.com/thumbs2/2015/12/12/beautiful-desktop-wallpaper_015710759_294.jpg");
        imgURLs.add("http://s1.picswalls.com/thumbs2/2015/12/12/beautiful-desktop-wallpapers_015709841_294.jpg");
        imgURLs.add("http://s1.picswalls.com/thumbs2/2015/12/12/beautiful-high-definition-wallpaper_015707889_294.jpg");
        setUpImageGrid(imgURLs);
    }

    private void setUpImageGrid(ArrayList<String> imgURLs){
        GridView gridView = (GridView) findViewById(R.id.gridView);
        GridImageAdapter adapter = new GridImageAdapter(mContext, R.layout.layout_grid_imageview, "",imgURLs);
        gridView.setAdapter(adapter);

    }

    private void setProfileImage(){
        String imgURL = "www.androidcentral.com/sites/androidcentral.com/files/styles/xlarge/public/article_images/2016/08/ac-lloyd.jpg?itok=bb72IeLf";
        UniversalImageLoader.setImage(imgURL, profilePhoto, null, "https://");
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
