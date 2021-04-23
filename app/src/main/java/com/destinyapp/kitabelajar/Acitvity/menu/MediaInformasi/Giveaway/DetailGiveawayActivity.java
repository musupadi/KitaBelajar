package com.destinyapp.kitabelajar.Acitvity.menu.MediaInformasi.Giveaway;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.destinyapp.kitabelajar.Acitvity.menu.JumatNgaji.KhutbahJumat.DetailKhutbahJumatActivity;
import com.destinyapp.kitabelajar.Method.Destiny;
import com.destinyapp.kitabelajar.R;
import com.destinyapp.kitabelajar.SharedPreferance.DB_Helper;
import com.destinyapp.kitabelajar.Splash.FullScreenYoutubeActivity;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.YouTubePlayerFullScreenListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;

public class DetailGiveawayActivity extends AppCompatActivity {
    Destiny destiny;
    RelativeLayout Back;
    DB_Helper dbHelper;
    String Username,Password,Nama,Token,Level,Photo;

    //DETAIL KABAR
    String JUDUL,ISI,TANGGAL,GANBAR,YOUTUBE;
    TextView tanggal;
    ImageView gambar;
    YouTubePlayerView FajarKontol;
    WebView Web;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_giveaway);
        destiny = new Destiny();
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
        Web = findViewById(R.id.web);
        tanggal = findViewById(R.id.tvTanggal);
        gambar = findViewById(R.id.ivGambar);
    }
    private void GETDATA(){
        Intent intent = getIntent();
        JUDUL = intent.getExtras().getString("JUDUL");
        ISI = intent.getExtras().getString("ISI");
        TANGGAL = intent.getExtras().getString("TANGGAL");
        GANBAR = intent.getExtras().getString("GAMBAR");
        YOUTUBE = intent.getExtras().getString("YOUTUBE");
        getSupportActionBar().setTitle(JUDUL);
        FajarKontol = findViewById(R.id.youtube);
        getLifecycle().addObserver(FajarKontol);
        if (YOUTUBE.isEmpty()){
            gambar.setVisibility(View.VISIBLE);
            FajarKontol.setVisibility(View.GONE);
        }else{
            FajarKontol.setVisibility(View.VISIBLE);
            gambar.setVisibility(View.GONE);
            FajarKontol.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
                @Override
                public void onReady(@NonNull YouTubePlayer youTubePlayer) {
                    String videoId = YOUTUBE;
                    youTubePlayer.loadVideo(videoId, 0);
                }
            });
        }
        Web.loadData(ISI,"text/html","UTF-8");
//        isi.setText(ISI);
        tanggal.setText(destiny.MagicDateChange(TANGGAL));
        Glide.with(this)
                .load(GANBAR)
                .into(gambar);
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}