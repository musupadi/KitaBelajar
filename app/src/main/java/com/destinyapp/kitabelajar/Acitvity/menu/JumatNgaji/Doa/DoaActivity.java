package com.destinyapp.kitabelajar.Acitvity.menu.JumatNgaji.Doa;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.Toast;

import com.destinyapp.kitabelajar.API.ApiRequest;
import com.destinyapp.kitabelajar.API.FajarKontol;
import com.destinyapp.kitabelajar.API.RetroServer;
import com.destinyapp.kitabelajar.Acitvity.LoginActivity;
import com.destinyapp.kitabelajar.Acitvity.menu.JumatNgaji.KhutbahJumat.KhutbahJumatActivity;
import com.destinyapp.kitabelajar.Adapter.AdapterDoa;
import com.destinyapp.kitabelajar.Adapter.AdapterKhutbah;
import com.destinyapp.kitabelajar.Method.Destiny;
import com.destinyapp.kitabelajar.Model.DataModel;
import com.destinyapp.kitabelajar.Model.Quran;
import com.destinyapp.kitabelajar.Model.ResponseDoa;
import com.destinyapp.kitabelajar.Model.ResponseModel;
import com.destinyapp.kitabelajar.Model.Surat;
import com.destinyapp.kitabelajar.R;
import com.destinyapp.kitabelajar.SharedPreferance.DB_Helper;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DoaActivity extends AppCompatActivity {
    Destiny destiny;
    DB_Helper dbHelper;
    String Username,Password,Nama,Token,Level,Photo;
    RecyclerView recycler;
    private List<Surat> mItems = new ArrayList<>();
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doa);
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
        Logic();
    }
    private void Logic(){
        mManager = new GridLayoutManager(DoaActivity.this,1);
        recycler.setLayoutManager(mManager);
        ApiRequest api = FajarKontol.getClient().create(ApiRequest.class);
        Call<ResponseDoa> Doa = api.Quran();
        Doa.enqueue(new Callback<ResponseDoa>() {
            @Override
            public void onResponse(Call<ResponseDoa> call, Response<ResponseDoa> response) {
                mItems=response.body().getData().getData();
                mAdapter = new AdapterDoa(DoaActivity.this,mItems);
                recycler.setAdapter(mAdapter);
                mAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<ResponseDoa> call, Throwable t) {
                Toast.makeText(DoaActivity.this, "KOneksi Gagal", Toast.LENGTH_SHORT).show();
            }
        });
    }
}