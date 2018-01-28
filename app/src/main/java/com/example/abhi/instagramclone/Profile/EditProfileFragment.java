package com.example.abhi.instagramclone.Profile;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.example.abhi.instagramclone.R;
import com.example.abhi.instagramclone.Utils.UniversalImageLoader;
import com.nostra13.universalimageloader.core.ImageLoader;

/**
 * Created by Abhi on 31-07-2017.
 */

public class EditProfileFragment extends Fragment {

    private ImageView mProfilePhoto;

    private ImageView backBtn;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_editprofile,container,false);

        mProfilePhoto = (ImageView)view.findViewById(R.id.profile_photo);
        backBtn = (ImageView)view.findViewById(R.id.backArrow);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().finish();
            }
        });

        setProfileImage();
        return view;
    }


    private void setProfileImage(){
        String imgURL = "www.androidcentral.com/sites/androidcentral.com/files/styles/xlarge/public/article_images/2016/08/ac-lloyd.jpg?itok=bb72IeLf";

        UniversalImageLoader.setImage(imgURL, mProfilePhoto, null, "https://");
    }
}
