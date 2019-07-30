package com.hashimshafiq.networksense;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkRequest;


public class ConnectionStateMonitor extends ConnectivityManager.NetworkCallback {

    private Context context;
    private OnNetworkAvailableCallbacks onNetworkAvailableCallbacks;

    public ConnectionStateMonitor(Context context, OnNetworkAvailableCallbacks onNetworkAvailableCallbacks) {
        this.context = context;
        this.onNetworkAvailableCallbacks = onNetworkAvailableCallbacks;
    }

    private NetworkRequest networkRequest = new NetworkRequest.Builder()
            .addTransportType(NetworkCapabilities.TRANSPORT_CELLULAR)
            .addTransportType(NetworkCapabilities.TRANSPORT_WIFI).build();


    private ConnectivityManager getConnectivityManager() {
        return (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
    }



    final boolean hasNetworkConnection() {
        return this.getConnectivityManager().getActiveNetworkInfo() != null;
    }

    final void enable() {
        this.getConnectivityManager().registerNetworkCallback(networkRequest, this);
    }

    final void disable() {
        this.getConnectivityManager().unregisterNetworkCallback(this);
    }


    public void onAvailable(Network network) {

        super.onAvailable(network);
        this.onNetworkAvailableCallbacks.onPositive();
    }

    public void onLost(Network network) {

        super.onAvailable(network);
        this.onNetworkAvailableCallbacks.onNegative();
    }


    interface OnNetworkAvailableCallbacks {
        /**
         * Callback for when network is available
         */void onPositive();

        /**
         * Callback for when network is lost/disconnected
         */
        void onNegative();
    }
}
