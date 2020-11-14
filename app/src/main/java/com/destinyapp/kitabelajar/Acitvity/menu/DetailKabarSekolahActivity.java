package com.destinyapp.kitabelajar.Acitvity.menu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.destinyapp.kitabelajar.Method.Destiny;
import com.destinyapp.kitabelajar.R;
import com.destinyapp.kitabelajar.SharedPreferance.DB_Helper;

public class DetailKabarSekolahActivity extends AppCompatActivity {
    Destiny destiny;
    RelativeLayout Back;
    DB_Helper dbHelper;
    String Username,Password,Nama,Token,Level,Photo;

    //DETAIL KABAR
    String JUDUL,ISI,TANGGAL,GANBAR;
    TextView judul,isi,tanggal;
    ImageView gambar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_kabar_sekolah);
        destiny = new Destiny();
        Back = findViewById(R.id.relativeBack);
        dbHelper = new DB_Helper(this);
        Cursor cursor = dbHelper.checkUser();
        if (cursor.getCount()>0){
            while (cursor.moveToNext()){
                Username = cursor.getString(0);
                Password = cursor.getString(1);
                Nama = cursor.getString(2);
                Token = cursor.getString(3);
                Level = cursor.getString(4);
                Photo = cursor.getString(5);
            }
        }
        Declaration();
        GETDATA();
    }
    private void Declaration(){
//        judul = findViewById(R.id.tvJudulKabar);
        isi = findViewById(R.id.tvIsiKabar);
        tanggal = findViewById(R.id.tvTanggal);
        gambar = findViewById(R.id.ivGambar);
    }
    private void GETDATA(){
        Intent intent = getIntent();
        JUDUL = intent.getExtras().getString("JUDUL");
        ISI = intent.getExtras().getString("ISI");
        TANGGAL = intent.getExtras().getString("TANGGAL");
        GANBAR = intent.getExtras().getString("GAMBAR");
        getSupportActionBar().setTitle(JUDUL);
        isi.setText(ISI);
        tanggal.setText(TANGGAL);
        Glide.with(this)
                .load(GANBAR)
                .into(gambar);
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}