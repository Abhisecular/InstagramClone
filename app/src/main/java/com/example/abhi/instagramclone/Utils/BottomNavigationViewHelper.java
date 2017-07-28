package com.example.abhi.instagramclone.Utils;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.view.MenuItem;

import com.example.abhi.instagramclone.Home.HomeActivity;
import com.example.abhi.instagramclone.Likes.LikesActivity;
import com.example.abhi.instagramclone.Profile.ProfileActivity;
import com.example.abhi.instagramclone.R;
import com.example.abhi.instagramclone.Search.SearchActivity;
import com.example.abhi.instagramclone.Share.ShareActivity;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

/**
 * Created by Abhi on 22-07-2017.
 */

public class BottomNavigationViewHelper{
    public static  void setupBottomNavigationView(BottomNavigationViewEx bottomNavigationViewEx){
        bottomNavigationViewEx.enableAnimation(false);
        bottomNavigationViewEx.enableItemShiftingMode(false);
        bottomNavigationViewEx.enableShiftingMode(false);
    }
    public static void enableNavigation(final Context context, BottomNavigationViewEx view){
        view.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener(){

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch(item.getItemId()){
                    case R.id.ic_house:
                        Intent intent1=new Intent(context, HomeActivity.class);
                        context.startActivity(intent1);
                        break;
                    case R.id.ic_search:
                        Intent intent2=new Intent(context, SearchActivity.class);
                        context.startActivity(intent2);
                        break;
                    case R.id.ic_circle:
                        Intent intent3=new Intent(context, ShareActivity.class);
                        context.startActivity(intent3);
                        break;
                    case R.id.ic_alert:
                        Intent intent4=new Intent(context, LikesActivity.class);
                        context.startActivity(intent4);
                        break;
                    case R.id.ic_android:
                        Intent intent5=new Intent(context, ProfileActivity.class);
                        context.startActivity(intent5);
                        break;
                }
                return false;
            }
        });
    }

}
