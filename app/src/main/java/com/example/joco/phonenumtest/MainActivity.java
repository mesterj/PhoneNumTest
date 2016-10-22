package com.example.joco.phonenumtest;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tvNum1,tvNum2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int permissionCheck = ContextCompat.checkSelfPermission(this, Manifest.permission.READ_PHONE_STATE);

        if (permissionCheck != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_PHONE_STATE}, 0);
        } else {

            TelephonyManager telMgr =
                    (TelephonyManager) getApplicationContext().getSystemService(Context.TELEPHONY_SERVICE);

            String deviceID = telMgr.getDeviceId();
            String simSerialNumber = telMgr.getSimSerialNumber();
            String simLineNumber = telMgr.getLine1Number();

            tvNum1 = (TextView) findViewById(R.id.tvNumber1);
            tvNum2 = (TextView) findViewById(R.id.tvNumber2);

            tvNum1.setText("Dev.id : " + deviceID + " simSerial: " + simSerialNumber + " Num: " + simLineNumber);
        }




    }
}
