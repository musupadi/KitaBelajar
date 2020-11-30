package com.destinyapp.kitabelajar.Acitvity.menu.MediaPembelajaran;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.Toast;

import com.destinyapp.kitabelajar.API.ApiRequest;
import com.destinyapp.kitabelajar.API.RetroServer;
import com.destinyapp.kitabelajar.Acitvity.LoginActivity;
import com.destinyapp.kitabelajar.Adapter.AdapterTema;
import com.destinyapp.kitabelajar.Method.Destiny;
import com.destinyapp.kitabelajar.Model.DataModel;
import com.destinyapp.kitabelajar.Model.ResponseModel;
import com.destinyapp.kitabelajar.Model.SubTema;
import com.destinyapp.kitabelajar.R;
import com.destinyapp.kitabelajar.SharedPreferance.DB_Helper;
import com.destinyapp.kitabelajar.Spinner.SpinnerMediaPembelajaran;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MediaPembelajaranActivity extends AppCompatActivity {
    Spinner spinner;
    RecyclerView rv;
    Destiny destiny;
    DB_Helper dbHelper;
    String Username,Password,Nama,Token,Level,Photo;
    private List<DataModel> mItems = new ArrayList<>();
    private List<SubTema> SubTema = new ArrayList<>();
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_media_pembelajaran);
        Declaration();
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
        GetMediaPembelajaran();
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                try {
                    SubTema(i);
                }catch (Exception e){
                    Toast.makeText(MediaPembelajaranActivity.this, "Terjadi Kesalahan", Toast.LENGTH_SHORT).show();
                    Log.i("Message = ",e.toString());
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
    private void Declaration(){
        spinner = findViewById(R.id.spinner);
        rv = findViewById(R.id.recycler);
        mManager = new GridLayoutManager(MediaPembelajaranActivity.this,1);
        rv.setLayoutManager(mManager);
    }
    private void SubTema(int index){
        SubTema = mItems.get(index).getSubtema();
        mAdapter = new AdapterTema(MediaPembelajaranActivity.this,SubTema);
        rv.setAdapter(mAdapter);
        mAdapter.notifyDataSetChanged();
    }
    private void GetMediaPembelajaran(){
        ApiRequest api = RetroServer.getClient().create(ApiRequest.class);
        Call<ResponseModel> Data=api.MediaPembelajaran(destiny.AUTH(Token));
        Data.enqueue(new Callback<ResponseModel>() {
            @Override
            public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {
                try {
                    if (response.body().getStatusCode().equals("000")){
                        mItems=response.body().getData();
                        SpinnerMediaPembelajaran adapter = new SpinnerMediaPembelajaran(MediaPembelajaranActivity.this,mItems);
                        spinner.setAdapter(adapter);
                    }else if (response.body().getStatusCode().equals("001") || response.body().getStatusCode().equals("002")){
                        destiny.AutoLogin(Username,Password,MediaPembelajaranActivity.this);
                        Intent intent = new Intent(MediaPembelajaranActivity.this,MediaPembelajaranActivity.class);
                        startActivity(intent);
                    }else{
                        Toast.makeText(MediaPembelajaranActivity.this, "Terjadi Kesalahan ", Toast.LENGTH_SHORT).show();
                    }
                }catch (Exception e){
                    Toast.makeText(MediaPembelajaranActivity.this, "Terjadi Kesalahan User akan Terlogout", Toast.LENGTH_SHORT).show();
                    dbHelper.Logout();
                    Intent intent = new Intent(MediaPembelajaranActivity.this, LoginActivity.class);
                    startActivity(intent);
                    finish();
                }
            }

            @Override
            public void onFailure(Call<ResponseModel> call, Throwable t) {
                Toast.makeText(MediaPembelajaranActivity.this, "Koneksi Gagal", Toast.LENGTH_SHORT).show();
            }
        });
    }
}