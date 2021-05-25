package com.destinyapp.kitabelajar.Acitvity.menu.JumatNgaji.Doa;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.destinyapp.kitabelajar.API.ApiRequest;
import com.destinyapp.kitabelajar.API.FajarKontol;
import com.destinyapp.kitabelajar.API.ServerQuran;
import com.destinyapp.kitabelajar.Adapter.AdapterAyat;
import com.destinyapp.kitabelajar.Adapter.AdapterDoa;
import com.destinyapp.kitabelajar.Method.Destiny;
import com.destinyapp.kitabelajar.Model.Alquran.Surah.Alfatihah;
import com.destinyapp.kitabelajar.Model.Alquran.Universal.TextModel;
import com.destinyapp.kitabelajar.Model.ResponseDoa;
import com.destinyapp.kitabelajar.Model.Surat;
import com.destinyapp.kitabelajar.R;
import com.destinyapp.kitabelajar.SharedPreferance.DB_Helper;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AyatActivity extends AppCompatActivity {
    Destiny destiny;
    DB_Helper dbHelper;
    String Username,Password,Nama,Token,Level,Photo;
    RecyclerView recycler;
    private List<Surat> mItems = new ArrayList<>();
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mManager;
    String NO;
    String NAMA;
    int jumlahAyat=0;
    TextModel Ayat = new TextModel();
    TextModel Translation = new TextModel();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ayat);
        destiny = new Destiny();
        recycler = findViewById(R.id.recycler);
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
//        Logic();
        Intent intent = getIntent();
        NO = intent.getExtras().getString("NO");
        NAMA = intent.getExtras().getString("NAMA");
        getSupportActionBar().setTitle(NAMA);
        Logic(NO);
    }
    private void Logic(String id){
        mManager = new GridLayoutManager(AyatActivity.this,1);
        recycler.setLayoutManager(mManager);
        ApiRequest api = ServerQuran.getClient().create(ApiRequest.class);
        Call<Alfatihah> Doa = api.Alfatihah();
        if (id.equals("1")){
            Doa = api.Alfatihah();
            Doa.enqueue(new Callback<Alfatihah>() {
                @Override
                public void onResponse(Call<Alfatihah> call, Response<Alfatihah> response) {
                    Ayat = response.body().getOne().getText();
                    Translation = response.body().getOne().getTranslations().getId().getText();
                    mAdapter = new AdapterAyat(AyatActivity.this,Integer.parseInt(response.body().getOne().getNumber_of_ayah()),Ayat,Translation);
                    recycler.setAdapter(mAdapter);
                    mAdapter.notifyDataSetChanged();
                }

                @Override
                public void onFailure(Call<Alfatihah> call, Throwable t) {
                    Toast.makeText(AyatActivity.this, t.toString(), Toast.LENGTH_SHORT).show();
                    Log.d("TAG ERROR : ",t.toString());
                }
            });
        }else{
            Doa = api.Alfatihah();
        }
    }
}