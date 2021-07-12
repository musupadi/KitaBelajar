package com.destinyapp.kitabelajar.Acitvity.Games.NamaHewan;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;
import com.destinyapp.kitabelajar.API.ApiRequest;
import com.destinyapp.kitabelajar.API.RetroServer;
import com.destinyapp.kitabelajar.Acitvity.LoginActivity;
import com.destinyapp.kitabelajar.Acitvity.MainActivity;
import com.destinyapp.kitabelajar.Adapter.AdapterHewan;
import com.destinyapp.kitabelajar.Method.Destiny;
import com.destinyapp.kitabelajar.Model.DataModel;
import com.destinyapp.kitabelajar.Model.ResponseModel;
import com.destinyapp.kitabelajar.R;
import com.destinyapp.kitabelajar.SharedPreferance.DB_Helper;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GameHewanActivity extends AppCompatActivity {
    Destiny destiny;
    RelativeLayout Back;
    DB_Helper dbHelper;
    String Username,Password,Nama,Token,Level,Photo;
    RecyclerView recycler;
    private List<DataModel> mItems = new ArrayList<>();
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mManager;

    LottieAnimationView Anim;
    LinearLayout LAnim;
    TextView TAnim;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_hewan);
        destiny = new Destiny();
        Anim = findViewById(R.id.lottieAnim);
        LAnim = findViewById(R.id.linearAnim);
        TAnim = findViewById(R.id.tvAnim);
        Back = findViewById(R.id.relativeBack);
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
        mManager = new GridLayoutManager(GameHewanActivity.this,2);
        recycler.setLayoutManager(mManager);
        LAnim.setVisibility(View.VISIBLE);
        TAnim.setVisibility(View.GONE);
        Anim.setAnimation("loading.json");
        Anim.playAnimation();
        ApiRequest api = RetroServer.getClient().create(ApiRequest.class);
        Call<ResponseModel> Temans = api.GameHewan(destiny.AUTH(Token));
        Temans.enqueue(new Callback<ResponseModel>() {
            @Override
            public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {
                try {
                    if (response.body().getStatusCode().equals("000")){
                        mItems = response.body().getData();
                        if (mItems.size()<1){
                            TAnim.setVisibility(View.VISIBLE);
                            TAnim.setText("Guru Belum Ada");
                            Anim.setAnimation("notfound.json");
                            Anim.playAnimation();
                        }else{
                            LAnim.setVisibility(View.GONE);
                            mAdapter = new AdapterHewan(GameHewanActivity.this,mItems);
                            recycler.setAdapter(mAdapter);
                            mAdapter.notifyDataSetChanged();
                        }
                    }else if (response.body().getStatusCode().equals("001") || response.body().getStatusCode().equals("002")){
                        destiny.AutoLogin(Username,Password,GameHewanActivity.this);
                        Intent intent = new Intent(GameHewanActivity.this, MainActivity.class);
                        startActivity(intent);
                        finish();
                    }else{
                        Toast.makeText(GameHewanActivity.this, "Terjadi Kesalahan ", Toast.LENGTH_SHORT).show();
                    }
                }catch (Exception e){
                    Toast.makeText(GameHewanActivity.this, "Terjadi Kesalahan", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseModel> call, Throwable t) {
                Toast.makeText(GameHewanActivity.this, "Koneksi Gagal", Toast.LENGTH_SHORT).show();
            }
        });
    }
}