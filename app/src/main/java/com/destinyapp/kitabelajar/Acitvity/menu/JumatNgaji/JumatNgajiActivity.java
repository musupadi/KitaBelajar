package com.destinyapp.kitabelajar.Acitvity.menu.JumatNgaji;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.destinyapp.kitabelajar.Acitvity.menu.JumatNgaji.KhutbahJumat.KhutbahJumatActivity;
import com.destinyapp.kitabelajar.R;

public class JumatNgajiActivity extends AppCompatActivity {
    CardView Khutbah,Alquran,Kiblat,Mesjid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jumat_ngaji);
        Khutbah = findViewById(R.id.cardKhutbah);
        Alquran = findViewById(R.id.cardAlquranDanDoa);
        Kiblat = findViewById(R.id.cardArahKiblat);
        Mesjid = findViewById(R.id.cardMesjidTerdekat);
        Kiblat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(JumatNgajiActivity.this,KiblatActivity.class);
                startActivity(intent);
            }
        });
        Khutbah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(JumatNgajiActivity.this, KhutbahJumatActivity.class);
                startActivity(intent);
            }
        });
    }
}