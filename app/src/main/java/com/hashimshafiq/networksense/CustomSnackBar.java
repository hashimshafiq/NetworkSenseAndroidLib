package com.hashimshafiq.networksense;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.google.android.material.snackbar.BaseTransientBottomBar;

public class CustomSnackBar extends BaseTransientBottomBar<CustomSnackBar> {

    public static int isConnectedAlready = 1;

    private CustomSnackBar(ViewGroup parent, View content, com.google.android.material.snackbar.ContentViewCallback callback) {
        super(parent,content,callback);
    }


    public CustomSnackBar setText(CharSequence text) {
        TextView textView = this.getView().findViewById(R.id.snackbar_text);
        textView.setText(text);
        return this;
    }

    public CustomSnackBar setBackgroundColor(int color) {
        RelativeLayout relativeLayout = this.getView().findViewById(R.id.snackbar_relativelayout);
        relativeLayout.setBackgroundColor(color);
        return this;
    }

    public static class CustomContentViewCallback implements com.google.android.material.snackbar.ContentViewCallback{
        private final View content;

        public void animateContentIn(int delay, int duration) {
        }

        public void animateContentOut(int delay, int duration) {
        }

        public CustomContentViewCallback(@NonNull View content) {
            super();
            this.content = content;
        }
    }



    public static final CustomSnackBar make(@NonNull ViewGroup parent, int duration) {
            LayoutInflater inflater = LayoutInflater.from(parent.getContext());
            View content = inflater.inflate(R.layout.custom_snackbar, parent, false);
            CustomContentViewCallback viewCallback = new CustomContentViewCallback(content);
            CustomSnackBar customSnackBar = new  CustomSnackBar(parent,content,viewCallback);
            customSnackBar.getView().setPadding(0,0,0,0);
            customSnackBar.setDuration(duration);

            return customSnackBar;
    }
}
