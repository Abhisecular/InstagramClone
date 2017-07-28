package com.example.abhi.instagramclone.Profile;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.abhi.instagramclone.R;

import java.util.ArrayList;

/**
 * Created by Abhi on 27-07-2017.
 */

public class AccountSettingsActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accountsettings);
        setupSettingsList();

        ImageView imageView = (ImageView)findViewById(R.id.backArrow);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void setupSettingsList(){
        ListView listView= (ListView)findViewById(R.id.lvAccountSettings);
        ArrayList<String> options = new ArrayList<>();
        options.add(getString(R.string.edit_profile));
        options.add(getString(R.string.sign_out));
        ArrayAdapter adapter = new ArrayAdapter(AccountSettingsActivity.this, android.R.layout.simple_list_item_1, options);
        listView.setAdapter(adapter);


    }
}
