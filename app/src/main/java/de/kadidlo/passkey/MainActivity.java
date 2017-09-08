package de.kadidlo.passkey;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /** Enable JavaScript */
        WebView webView = (WebView) findViewById(R.id.pk_view);
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        /** Load PasS/KEY */
        webView.loadUrl("file:///android_asset/PasS_KEY.html");
    }
}
