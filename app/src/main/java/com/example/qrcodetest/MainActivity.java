package com.example.qrcodetest;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import java.util.Collection;

public class MainActivity extends AppCompatActivity {

    public static final Collection<String> ALL_CODE_TYPES = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button b = (Button) findViewById(R.id.button);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Activity host = (Activity) v.getContext();
                new IntentIntegrator(host).initiateScan(IntentIntegrator.QR_CODE_TYPES);
            }
        });
    }

    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        IntentResult scanResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, intent);
        if (scanResult != null) {
            String re = scanResult.getContents();
            TextView textView = (TextView) findViewById(R.id.textView);
            textView.setText(re);
        }
        // else continue with any other code you need in the method

    }
}
