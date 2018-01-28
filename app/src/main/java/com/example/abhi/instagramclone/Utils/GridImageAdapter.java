package com.example.abhi.instagramclone.Utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.example.abhi.instagramclone.R;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Abhi on 27-01-2018.
 */

public class GridImageAdapter extends ArrayAdapter<String> {
    Context mContext;
    ArrayList<String> imgURL;
    String mAppend;
    LayoutInflater inflater;
    int mLayoutResource;

    public GridImageAdapter(Context context, int layoutResource, String append, ArrayList<String> imgURLs){
        super(context, layoutResource, imgURLs);
        mContext=context;
        imgURL=imgURLs;
        mAppend= append;
        inflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mLayoutResource=layoutResource;
    }

    private static class ViewHolder{
        SquareImageView image;
        ProgressBar mProgressbar;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        final ViewHolder viewHolder;
        if(convertView==null){
            convertView = inflater.inflate(mLayoutResource, parent, false);
            viewHolder=new ViewHolder();
            viewHolder.mProgressbar= (ProgressBar) convertView.findViewById(R.id.gridImageProgressBar);

            viewHolder.image= (SquareImageView) convertView.findViewById(R.id.gridImageView);
            convertView.setTag(viewHolder);

        }
        else{
            viewHolder = (ViewHolder) convertView.getTag();
        }
        String imgURL = getItem(position);
        ImageLoader imageLoader = ImageLoader.getInstance();
        imageLoader.displayImage(mAppend + imgURL, viewHolder.image, new ImageLoadingListener() {
            @Override
            public void onLoadingStarted(String imageUri, View view) {
                if(viewHolder.mProgressbar!=null){
                    viewHolder.mProgressbar.setVisibility(View.VISIBLE);
                }

            }

            @Override
            public void onLoadingFailed(String imageUri, View view, FailReason failReason) {
                if(viewHolder.mProgressbar!=null){
                    viewHolder.mProgressbar.setVisibility(View.GONE);
                }

            }

            @Override
            public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {
                if(viewHolder.mProgressbar!=null){
                    viewHolder.mProgressbar.setVisibility(View.GONE);
                }

            }

            @Override
            public void onLoadingCancelled(String imageUri, View view) {
                if(viewHolder.mProgressbar!=null){
                    viewHolder.mProgressbar.setVisibility(View.GONE);
                }

            }
        });

        return convertView;
    }
}
