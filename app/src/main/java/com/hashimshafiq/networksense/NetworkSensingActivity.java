package com.hashimshafiq.networksense;

import android.os.Bundle;
import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;
import android.view.ViewGroup;


import com.google.android.material.snackbar.Snackbar;


public class NetworkSensingActivity extends AppCompatActivity implements ConnectionStateMonitor.OnNetworkAvailableCallbacks{

    public CustomSnackBar snackbar = null;
    private ConnectionStateMonitor connectionStateMonitor = null;
    private ViewGroup viewGroup = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public void onResume() {
        super.onResume();
        if (viewGroup == null) viewGroup = findViewById(android.R.id.content);
        if (snackbar == null)
            snackbar = CustomSnackBar.make(viewGroup, Snackbar.LENGTH_INDEFINITE).setText("No Internet Connection "+ Helper.getEmojiByUnicode(0x1F61E));

        if (connectionStateMonitor == null)
            connectionStateMonitor = new ConnectionStateMonitor(this, this);
        //Register
        if(connectionStateMonitor!=null)
            connectionStateMonitor.enable();

        // Recheck network status manually whenever activity resumes
        if (!connectionStateMonitor.hasNetworkConnection()) onNegative();
        else onPositive();
    }

    @Override
    public void onPause() {
        if(snackbar!=null)
            snackbar.dismiss();
        snackbar = null;
        //Unregister
        if(connectionStateMonitor!=null)
            connectionStateMonitor.disable();
        connectionStateMonitor = null;
        super.onPause();
    }

    public void onPositive() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if (snackbar != null && CustomSnackBar.isConnectedAlready == 0) {
                    snackbar.setBackgroundColor(NetworkSensingActivity.this.getResources().getColor(R.color.green));
                    snackbar.setText("Connected " + Helper.getEmojiByUnicode(0x1F60A)).show();
                    CustomSnackBar.isConnectedAlready = 1;
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            snackbar.dismiss();
                        }
                    }, 1000);

                }
            }
        });

    }

    @Override
    public void onNegative() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if (snackbar != null) {
                    snackbar.setBackgroundColor(NetworkSensingActivity.this.getResources().getColor(R.color.dark_red));
                    CustomSnackBar.isConnectedAlready = 0;
                    snackbar.setText("No Internet Connection " + Helper.getEmojiByUnicode(0x1F61E)).show();
                }
            }
        });
    }
}
