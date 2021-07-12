package com.destinyapp.kitabelajar.Acitvity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;

import com.destinyapp.kitabelajar.API.ApiRequest;
import com.destinyapp.kitabelajar.API.DestinyServer;
import com.destinyapp.kitabelajar.API.RetroServer;
import com.destinyapp.kitabelajar.Model.ResponseDestiny;
import com.destinyapp.kitabelajar.Model.ResponseModel;
import com.destinyapp.kitabelajar.R;
import com.destinyapp.kitabelajar.SharedPreferance.DB_Helper;
import com.destinyapp.kitabelajar.Splash.SplashActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Handler handler = new Handler();
        final DB_Helper dbHelper = new DB_Helper(MainActivity.this);
        Cursor cursor = dbHelper.checkUser();
//        ApiRequest api = DestinyServer.getClient().create(ApiRequest.class);
//        Call<ResponseDestiny> Check = api.Checkers("Basic YWRtaW46MTIzNA==",
//                                                    "destinykitabelajarkey");
//        Check.enqueue(new Callback<ResponseDestiny>() {
//            @Override
//            public void onResponse(Call<ResponseDestiny> call, Response<ResponseDestiny> response) {
//                try {
//                    if (response.body().getData().equals("1")){
//
//                    }else{
//                        Toast.makeText(MainActivity.this, "Kesalahan Server Jaringan", Toast.LENGTH_SHORT).show();
//                    }
//                }catch (Exception e){
//                    Toast.makeText(MainActivity.this, "Terjadi Kesalahan", Toast.LENGTH_SHORT).show();
//                }
//            }
//
//            @Override
//            public void onFailure(Call<ResponseDestiny> call, Throwable t) {
//                Toast.makeText(MainActivity.this, "Koneksi Gagal", Toast.LENGTH_SHORT).show();
//            }
//        });
        if (cursor.getCount()>0){
            Intent intent = new Intent(MainActivity.this,HomeActivity.class);
            startActivity(intent);
            finish();
        }else{
            handler.postDelayed(new Runnable() {
                public void run() {
                    Intent intent = new Intent(MainActivity.this, SplashActivity.class);
                    startActivity(intent);
                    finish();
                }
            }, 3000); //3000 L = 3 detik
        }
    }
}