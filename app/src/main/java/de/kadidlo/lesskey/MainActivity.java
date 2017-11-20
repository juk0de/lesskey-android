package de.kadidlo.lesskey;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {

    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(de.kadidlo.lesskey.R.layout.activity_main);

        /* Create WebView */
        webView = (WebView) findViewById(de.kadidlo.lesskey.R.id.pk_view);
        /* Enable JavaScript */
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        /* Create new Client */
        webView.setWebViewClient(new WebViewClient()
        {
            @Override
            public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest)
            {
                if (webResourceRequest.getUrl().getScheme().equals("file")) {
                    webView.loadUrl(webResourceRequest.getUrl().toString());
                } else {
                    /* If the URI is not pointing to a local file, open with an ACTION_VIEW Intent */
                    webView.getContext().startActivity(new Intent(Intent.ACTION_VIEW, webResourceRequest.getUrl()));
                }
                return true; /* in both cases we handle the link manually */
            }
        });

        /** Load LesS/KEY */
        webView.loadUrl("file:///android_asset/index.html");
    }

    /* Override "Back" button behaviour */
    @Override
    public void onBackPressed()
    {
        if(webView.canGoBack()) {
            webView.goBack();
        } else {
            super.onBackPressed();
        }
    }
}
