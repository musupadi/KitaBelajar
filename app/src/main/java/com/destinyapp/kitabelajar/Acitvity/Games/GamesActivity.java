package com.destinyapp.kitabelajar.Acitvity.Games;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.destinyapp.kitabelajar.R;

public class GamesActivity extends AppCompatActivity {
    TextView Satu,Dua,Tiga,Empat,Lima,Enam,Tujuh,Delapan,Sembilan,Nol;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_games);
        Declaration();
        OnClick();
    }
    private void OnClick(){
        Satu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final MediaPlayer SuaraMe = MediaPlayer.create(GamesActivity.this,R.raw.satu);
                SuaraMe.start();
            }
        });
        Dua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final MediaPlayer SuaraMe = MediaPlayer.create(GamesActivity.this,R.raw.dua);
                SuaraMe.start();
            }
        });
        Tiga.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final MediaPlayer SuaraMe = MediaPlayer.create(GamesActivity.this,R.raw.tiga);
                SuaraMe.start();
            }
        });
        Empat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final MediaPlayer SuaraMe = MediaPlayer.create(GamesActivity.this,R.raw.empat);
                SuaraMe.start();
            }
        });
        Enam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final MediaPlayer SuaraMe = MediaPlayer.create(GamesActivity.this,R.raw.enam);
                SuaraMe.start();
            }
        });
        Tujuh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final MediaPlayer SuaraMe = MediaPlayer.create(GamesActivity.this,R.raw.tujuh);
                SuaraMe.start();
            }
        });
        Delapan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final MediaPlayer SuaraMe = MediaPlayer.create(GamesActivity.this,R.raw.delapan);
                SuaraMe.start();
            }
        });
        Sembilan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final MediaPlayer SuaraMe = MediaPlayer.create(GamesActivity.this,R.raw.sembilan);
                SuaraMe.start();
            }
        });
        Nol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final MediaPlayer SuaraMe = MediaPlayer.create(GamesActivity.this,R.raw.nol);
                SuaraMe.start();
            }
        });
    }
    private void Declaration(){
        Satu = findViewById(R.id.tvSatu);
        Dua = findViewById(R.id.tvDua);
        Tiga = findViewById(R.id.tvTiga);
        Empat = findViewById(R.id.tvEmpat);
        Lima = findViewById(R.id.tvLima);
        Enam = findViewById(R.id.tvEnam);
        Tujuh = findViewById(R.id.tvTujuh);
        Delapan = findViewById(R.id.tvDelapan);
        Sembilan = findViewById(R.id.tvSembilan);
        Nol = findViewById(R.id.tvNol);
    }
}