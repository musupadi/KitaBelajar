package com.destinyapp.kitabelajar.Acitvity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.destinyapp.kitabelajar.Method.Destiny;
import com.destinyapp.kitabelajar.R;
import com.destinyapp.kitabelajar.SharedPreferance.DB_Helper;

public class DetailProdukActivity extends AppCompatActivity {


//    i.putExtra("", dm.getNama_produk());
//                i.putExtra("",dm.getNama_sekolah());
//                i.putExtra("",dm.getHarga_produk());
//                i.putExtra("",destiny.BASE_URL()+dm.getCover_produk());
//                i.putExtra("",dm.getDeskripsi_produk());

    Destiny destiny;
    DB_Helper dbHelper;
    String Username,Password,Nama,Token,Level,Photo;

    //DETAIL KABAR
    String NAMA,SEKOLAH,HARGA,GAMBAR,DESKRIPSI;
    TextView nama,harga;
    ImageView gambar;
    WebView Web;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_produk);
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
        nama = findViewById(R.id.tvNama);
        harga = findViewById(R.id.tvHarga);
        gambar = findViewById(R.id.ivGambar);

    }
    private void GETDATA(){
        Intent intent = getIntent();
        NAMA = intent.getExtras().getString("NAMA");
        SEKOLAH = intent.getExtras().getString("SEKOLAH");
        HARGA = intent.getExtras().getString("HARGA");
        GAMBAR = intent.getExtras().getString("GAMBAR");
        DESKRIPSI = intent.getExtras().getString("DESKRIPSI");
        getSupportActionBar().setTitle(SEKOLAH);

        Web.loadData(DESKRIPSI,"text/html","UTF-8");
        nama.setText(NAMA);
        harga.setText("Harga : "+HARGA);
        Glide.with(this)
                .load(GAMBAR)
                .into(gambar);
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}