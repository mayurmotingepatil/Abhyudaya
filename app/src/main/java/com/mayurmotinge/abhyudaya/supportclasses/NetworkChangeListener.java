package com.mayurmotinge.abhyudaya.supportclasses;

import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.widget.AppCompatButton;

import com.mayurmotinge.abhyudaya.R;

public class NetworkChangeListener extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        if (!NetworkDetails.isConnectedToNetwork(context)) {
            AlertDialog.Builder ad = new AlertDialog.Builder(context);
            View layoutDialog = LayoutInflater.from(context).inflate(R.layout.no_internet_connection_dialog, null);
            ad.setView(layoutDialog);

            AppCompatButton btnRetry = layoutDialog.findViewById(R.id.btnNoInternet);

            AlertDialog dialog = ad.create();
            dialog.show();
            dialog.setCanceledOnTouchOutside(false);

            btnRetry.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialog.dismiss();
                    onReceive(context, intent);
                }
            });
        } else {
            Toast.makeText(context, "Internet Connected Successfully", Toast.LENGTH_SHORT).show();
        }
    }
}
