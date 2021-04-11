package com.destinyapp.kitabelajar.Acitvity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.media.MediaBrowserCompat;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.destinyapp.kitabelajar.API.ApiRequest;
import com.destinyapp.kitabelajar.API.RetroServer;
import com.destinyapp.kitabelajar.Adapter.AdapterKabarBerita;
import com.destinyapp.kitabelajar.Adapter.AdapterSekolah;
import com.destinyapp.kitabelajar.Adapter.AutoCompleteSekolahAdapter;
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

public class LoginActivity extends AppCompatActivity {
    Button login;
    EditText user,password;
    DB_Helper dbHelper;
    TextView FajarKontol;
    //Dialog
    Dialog dialog;
    RecyclerView ImamKontol;
    Spinner TitidUcupKecil;
    Button FajarNangis,KontolFajar;
    private List<DataModel> mItems = new ArrayList<>();
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mManager;
    Destiny destiny;
    AutoCompleteTextView Search;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dbHelper = new DB_Helper(LoginActivity.this);
        setContentView(R.layout.activity_login);
        login = findViewById(R.id.btnLogin);
        user = findViewById(R.id.etEmail);
        password = findViewById(R.id.etPassword);
        FajarKontol = findViewById(R.id.tvTamu);
        //Dialog
        dialog = new Dialog(this);
        dialog.setContentView(R.layout.dialog_pilih_sekolah);
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.getWindow().setBackgroundDrawableResource(R.drawable.btn_rounded_white);

        ImamKontol = dialog.findViewById(R.id.recycler);
        TitidUcupKecil = dialog.findViewById(R.id.spLembaga);
        KontolFajar = dialog.findViewById(R.id.btnCancel);
        FajarNangis = dialog.findViewById(R.id.btnSubmit);
        Search = dialog.findViewById(R.id.autoComplete);
        destiny = new Destiny();
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Logic();
            }
        });
        FajarKontol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.show();
            }
        });
        KontolFajar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.hide();
            }
        });
        GetAutoComplete();
        FajarNangis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        TitidUcupKecil.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                GetData(TitidUcupKecil.getSelectedItem().toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
    private void GetAutoComplete(){
        ApiRequest api = RetroServer.getClient().create(ApiRequest.class);
        Call<ResponseModel> KabarBerita = api.SekolahGuest("");
        KabarBerita.enqueue(new Callback<ResponseModel>() {
            @Override
            public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {
                try {
                    if (response.body().getStatusCode().equals("000")){
                        mItems=response.body().getData();
                        AutoCompleteSekolahAdapter adapters = new AutoCompleteSekolahAdapter(LoginActivity.this,mItems);
                        Search.setAdapter(adapters);
                    }else{
                        Toast.makeText(LoginActivity.this, "Terjadi Kesalahan ", Toast.LENGTH_SHORT).show();
                    }
                }catch (Exception e){
                    Toast.makeText(LoginActivity.this, "Terjadi Kesalahan User akan Terlogout", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseModel> call, Throwable t) {
                Toast.makeText(LoginActivity.this, "Koneksi Gagal", Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void GetData(String lembaga){
        mManager = new LinearLayoutManager(LoginActivity.this, LinearLayoutManager.VERTICAL,false);
        ImamKontol.setLayoutManager(mManager);
        ApiRequest api = RetroServer.getClient().create(ApiRequest.class);
        Call<ResponseModel> KabarBerita = api.SekolahGuest(lembaga);
        KabarBerita.enqueue(new Callback<ResponseModel>() {
            @Override
            public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {
                try {
                    if (response.body().getStatusCode().equals("000")){
                        mItems=response.body().getData();
                        mAdapter = new AdapterSekolah(LoginActivity.this,mItems);
                        ImamKontol.setAdapter(mAdapter);
                        mAdapter.notifyDataSetChanged();
                    }else{
                        Toast.makeText(LoginActivity.this, "Terjadi Kesalahan ", Toast.LENGTH_SHORT).show();
                    }
                }catch (Exception e){
                    Toast.makeText(LoginActivity.this, "Terjadi Kesalahan User akan Terlogout", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseModel> call, Throwable t) {
                Toast.makeText(LoginActivity.this, "Koneksi Gagal", Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void Logic(){
        final ProgressDialog pd = new ProgressDialog(LoginActivity.this);
        pd.setMessage("Sedang Mencoba Login");
        pd.show();
        pd.setCancelable(false);
        ApiRequest api = RetroServer.getClient().create(ApiRequest.class);
        final Call<ResponseModel> login =api.login(user.getText().toString(),password.getText().toString());
        login.enqueue(new Callback<ResponseModel>() {
            @Override
            public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {
                try {
                    if (response.body().getStatusCode().equals("000")){
                        dbHelper.SaveUser(user.getText().toString(),password.getText().toString(),response.body().getData().get(0).getName(),response.body().getData().get(0).getAccessToken(),response.body().getData().get(0).getAs(),response.body().getData().get(0).getPhoto());
                        Intent intent = new Intent(LoginActivity.this,HomeActivity.class);
                        startActivity(intent);
                        finish();
                    }else{
                        Toast.makeText(LoginActivity.this, response.body().getStatusMessage(), Toast.LENGTH_SHORT).show();
                    }
                    pd.hide();
                }catch (Exception e){
                    Toast.makeText(LoginActivity.this, "Terjadi Kesalahan "+e.toString(), Toast.LENGTH_SHORT).show();
                    pd.hide();
                }
            }

            @Override
            public void onFailure(Call<ResponseModel> call, Throwable t) {
//                Toast.makeText(LoginActivity.this, "Koneksi Gagal", Toast.LENGTH_SHORT).show();
                Toast.makeText(LoginActivity.this, "Koneksi Gagal", Toast.LENGTH_SHORT).show();
                pd.hide();
                Log.i("Login Logic : ",t.toString());
            }
        });
    }
}