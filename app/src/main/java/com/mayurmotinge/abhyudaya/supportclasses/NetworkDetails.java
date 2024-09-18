package com.mayurmotinge.abhyudaya.supportclasses;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;


public class NetworkDetails {

    public boolean isConnectedToNetwork(Context context){
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            if (connectivityManager != null){
                NetworkInfo[] networkInfo = connectivityManager.getAllNetworkInfo();
                if (networkInfo != null){
                    for (int i = 0; i < networkInfo.length; i++){
                        if (networkInfo[i].getState() == NetworkInfo.State.CONNECTED){
                            return true;
                        }
                    }
                }
            }

            return false;
    }
}
