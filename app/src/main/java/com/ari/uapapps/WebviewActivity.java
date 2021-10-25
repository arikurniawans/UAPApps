package com.ari.uapapps;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.provider.Settings;
import android.view.LayoutInflater;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ProgressBar;

public class WebviewActivity extends AppCompatActivity {
    private WebView myWebview;
    ProgressBar progressBar;
    ImageButton btnback;
    ConnectivityManager conMgr;

    String pathFile1 = "https://www.aisyahuniversity.ac.id";
    String pathFile2 = "https://siakad.aisyahuniversity.ac.id";
    String pathFile3 = "http://simkeu.aisyahuniversity.ac.id";
    String pathFile4 = "http://simpeg.aisyahuniversity.ac.id";
    String pathFile5 = "http://nelitiuap.aisyahuniversity.ac.id";
    String pathFile6 = "http://pelangi.aisyahuniversity.ac.id";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);
        final ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        Intent intent = getIntent();
        String id = intent.getStringExtra("no_web");

        myWebview = findViewById(R.id.konten_view);
        progressBar = findViewById(R.id.progressBar);
        btnback = (ImageButton) findViewById(R.id.btnback);

        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(WebviewActivity.this, HomeActivity.class);
                startActivity(intent1);
            }
        });

        myWebview.setWebViewClient(new WebViewClient());
        WebSettings settings = myWebview.getSettings();
        settings.setJavaScriptEnabled(true);

        conMgr = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        {
            if (conMgr.getActiveNetworkInfo() != null
                    && conMgr.getActiveNetworkInfo().isAvailable()
                    && conMgr.getActiveNetworkInfo().isConnected()) {

                if(id.equals("1"))
                {
                    myWebview.loadUrl(pathFile1);
                }
                else if(id.equals("2"))
                {
                    myWebview.loadUrl(pathFile2);
                }
                else if(id.equals("3"))
                {
                    myWebview.loadUrl(pathFile3);
                }
                else if(id.equals("4"))
                {
                    myWebview.loadUrl(pathFile4);
                }
                else if(id.equals("5"))
                {
                    myWebview.loadUrl(pathFile5);
                }
                else if(id.equals("6"))
                {
                    myWebview.loadUrl(pathFile6);
                }

            } else {
                AlertDialog.Builder builder = new AlertDialog.Builder(WebviewActivity.this);
                View view = LayoutInflater.from(WebviewActivity.this).inflate(R.layout.custom_layout, null);
                builder.setCancelable(false);
                builder.setPositiveButton("Setting", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
//                                startActivity(getIntent());
                        startActivity(new Intent(Settings.ACTION_SETTINGS));
                    }
                });

                builder.setNegativeButton("Reload", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                        startActivity(getIntent());
                    }
                });

                builder.setView(view);
                builder.show();
            }
        }

    }

    public class WebViewClient extends android.webkit.WebViewClient {
        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
        }
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            progressBar.setVisibility(View.GONE);
        }
    }

}