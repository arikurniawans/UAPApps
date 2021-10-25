package com.ari.uapapps;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class HomeActivity extends AppCompatActivity {
    CardView cardWebsite, cardSiakad, cardSimkeu, cardSimpeg, cardNeliti, cardPmb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        final ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        cardWebsite = (CardView) findViewById(R.id.cardWebsite);
        cardSiakad = (CardView) findViewById(R.id.cardSiakad);
        cardSimkeu = (CardView) findViewById(R.id.cardSimkeu);
        cardSimpeg = (CardView) findViewById(R.id.cardSimpeg);
        cardNeliti = (CardView) findViewById(R.id.cardNeliti);
        cardPmb = (CardView) findViewById(R.id.cardPmb);

        cardWebsite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplication(), WebviewActivity.class);
                intent.putExtra("no_web","1");
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });

        cardSiakad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplication(), WebviewActivity.class);
                intent.putExtra("no_web","2");
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });

        cardSimkeu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplication(), WebviewActivity.class);
                intent.putExtra("no_web","3");
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });

        cardSimpeg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplication(), WebviewActivity.class);
                intent.putExtra("no_web","4");
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });

        cardNeliti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplication(), WebviewActivity.class);
                intent.putExtra("no_web","5");
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });

        cardPmb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplication(), WebviewActivity.class);
                intent.putExtra("no_web","6");
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });

    }
}