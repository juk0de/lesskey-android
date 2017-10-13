package de.kadidlo.lesskey;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(de.kadidlo.lesskey.R.layout.activity_main);

        /** Enable JavaScript */
        WebView webView = (WebView) findViewById(de.kadidlo.lesskey.R.id.pk_view);
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        /** Load LesS/KEY */
        webView.loadUrl("file:///android_asset/LesS_KEY.html");
    }
}
