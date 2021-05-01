package com.destinyapp.kitabelajar.Acitvity.menu.KemisNyunda;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.destinyapp.kitabelajar.Acitvity.menu.KemisNyunda.CeritaSunda.CeritaSundaActivity;
import com.destinyapp.kitabelajar.Acitvity.menu.KemisNyunda.KamusSunda.KamusSundaActivity;
import com.destinyapp.kitabelajar.Acitvity.menu.KemisNyunda.SejarahSunda.SejarahSundaActivity;
import com.destinyapp.kitabelajar.R;

public class KemisNyundaActivity extends AppCompatActivity {
    CardView Kamus,Cerita,Sejarah;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kemis_nyunda);
        Kamus = findViewById(R.id.cardKamusSunda);
        Cerita = findViewById(R.id.cardCeritaSunda);
        Sejarah = findViewById(R.id.cardSejarahSunda);
        Cerita.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(KemisNyundaActivity.this, CeritaSundaActivity.class);
                startActivity(intent);
            }
        });
        Sejarah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(KemisNyundaActivity.this, SejarahSundaActivity.class);
                startActivity(intent);
            }
        });
        Kamus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(KemisNyundaActivity.this, KamusSundaActivity.class);
                startActivity(intent);
            }
        });
    }
}