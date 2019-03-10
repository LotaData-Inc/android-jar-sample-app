package com.lotadata.minsdkdemo;

import android.os.Bundle;
import android.provider.Settings.Secure;
import android.support.v7.app.AppCompatActivity;

import com.lotadata.moments.LDDispatcher;
import com.lotadata.moments.model.TrailNode;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "DemoLotaDataJAR";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initMinSDK();
    }

    /**
     * Init minSDK, setting the mandatory fields.
     */
    private void initMinSDK() {
        //App package name
        String packageName = this.getPackageName();

        //SHA1 certificate fingerprint (can be extracted using the commnad: keytool -printcert -file CERT.RSA)
        String sha1Fingerprint = "81:92:77:19:E3:71:78:28:67:E1:3C:24:8E:07:74:58:5E:1C:CA:D2";

        //Android ID
        String androidID = Secure.getString(this.getContentResolver(), Secure.ANDROID_ID);

        LDDispatcher dispatcher = LDDispatcher.getInstance(packageName, sha1Fingerprint, androidID);

        //Create dummy payload
        TrailNode node = new TrailNode();

        //TODO: populate node object (use provided dictionary to know what each field means)

        //Send to LotaData's back-end
        for(int i = 0; i < 10; i++) {
            dispatcher.sendPayload(node);

        }
    }   
}
