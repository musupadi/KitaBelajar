package com.destinyapp.kitabelajar.Acitvity.ui;

import android.app.Dialog;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.destinyapp.kitabelajar.API.ApiRequest;
import com.destinyapp.kitabelajar.API.FajarKontol;
import com.destinyapp.kitabelajar.API.RetroServer;
import com.destinyapp.kitabelajar.Acitvity.KabarBeritaActivity;
import com.destinyapp.kitabelajar.Acitvity.LoginActivity;
import com.destinyapp.kitabelajar.Acitvity.MainActivity;
import com.destinyapp.kitabelajar.Acitvity.SponsorActivity;
import com.destinyapp.kitabelajar.Acitvity.menu.AgendaSekolah.AgendaSekolahActivity;
import com.destinyapp.kitabelajar.Acitvity.menu.GalleryActivity;
import com.destinyapp.kitabelajar.Adapter.AdapterGallery;
import com.destinyapp.kitabelajar.Adapter.AdapterGalleryHome;
import com.destinyapp.kitabelajar.Adapter.AdapterInfoPublik;
import com.destinyapp.kitabelajar.Adapter.AdapterKabarBerita;
import com.destinyapp.kitabelajar.Adapter.AdapterSponsor;
import com.destinyapp.kitabelajar.Method.Destiny;
import com.destinyapp.kitabelajar.Model.DataModel;
import com.destinyapp.kitabelajar.Model.ResponseModel;
import com.destinyapp.kitabelajar.R;
import com.destinyapp.kitabelajar.SharedPreferance.DB_Helper;

import java.util.ArrayList;
import java.util.List;

import com.destinyapp.kitabelajar.Adapter.AdapterKegiatan;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class HomeFragment extends Fragment {

    Switch SwitchMasuk;
    ImageView Logo;
    TextView CheckMasuk,Poin,SekolahBesar,Sekolah;
    LinearLayout ProfilSekolah,AgendaSekolah,Prestasi,PPDB,StrukturSekolah,JadwalPelajaran,Evadir,MediaPembelajaran,Tugas,LihatSemua;
    LinearLayout DProfilSekolah,DAgendaSekolah,DPrestasi,DPPDB,DStrukturSekolah,DJadwalPelajaran,DEvadir,DMediaPembelajaran,DTugas,DGuru,DBiayaAkademik,DPembayaran,DROB,DERaport,DGallery;
    LinearLayout KemisNyunda,JumatNgaji,MediaInformasi;
    //Dialog
    Dialog dialog;
    Button Kembali;
    Destiny destiny;
    TextView nama,namaSiswa;
    DB_Helper dbHelper;
    String Username,Password,Nama,Token,Level,Photo;
    RecyclerView recycler,recyclerKabar,recylerSponsor,recyclerGallery;
    LinearLayout infoDinas;
    private List<DataModel> mItems = new ArrayList<>();
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mManager;
    LinearLayout LihatSemuaKabarBerita,LihatSemuaSponsor,LihatSemuaGallery;
    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        destiny = new Destiny();
        recycler = view.findViewById(R.id.recyclerHeader);
        recyclerKabar = view.findViewById(R.id.recyclerKabarBerita);
        recylerSponsor = view.findViewById(R.id.recyclerSponsor);
        recyclerGallery = view.findViewById(R.id.recyclerGallery);
        nama = view.findViewById(R.id.tvNama);
        namaSiswa = view.findViewById(R.id.tvNamaSiswa);
        SwitchMasuk = view.findViewById(R.id.switchMasuk);
        CheckMasuk = view.findViewById(R.id.tvCheckMasuk);
        ProfilSekolah = view.findViewById(R.id.linearProfilSekolah);
        AgendaSekolah = view.findViewById(R.id.linearAgendaSekolah);
        Prestasi = view.findViewById(R.id.linearPrestasi);
        PPDB = view.findViewById(R.id.linearPPDB);
        StrukturSekolah = view.findViewById(R.id.linearStrukturOrganisasi);
        JadwalPelajaran = view.findViewById(R.id.linearJadwalPelajaran);
        Evadir = view.findViewById(R.id.linearEvadir);
        MediaPembelajaran = view.findViewById(R.id.linearMediaPembelajaran);
        Tugas = view.findViewById(R.id.linearTugas);
        LihatSemua = view.findViewById(R.id.linearLihatSemua);
        LihatSemuaKabarBerita = view.findViewById(R.id.linearLihatSemuaKabarBerita);
        LihatSemuaSponsor = view.findViewById(R.id.linearLihatSemuaSponsor);
        LihatSemuaGallery = view.findViewById(R.id.linearLihatGallery);
        Poin = view.findViewById(R.id.tvPoint);
        Logo = view.findViewById(R.id.ivLogoSekolah);
        SekolahBesar = view.findViewById(R.id.tvSekolahBesar);
        Sekolah = view.findViewById(R.id.tvNamaSekolah);
        infoDinas = view.findViewById(R.id.linearInfoDinasPendidikan);
        KemisNyunda = view.findViewById(R.id.linearKemisNyunda);
        JumatNgaji = view.findViewById(R.id.linearJumatNgaji);
        MediaInformasi = view.findViewById(R.id.linearMediaInformasi);
        dialog = new Dialog(getActivity());
        dialog.setContentView(R.layout.dialog_menu_all);
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.getWindow().setBackgroundDrawableResource(R.drawable.btn_rounded_white);

        Kembali = dialog.findViewById(R.id.btnKembali);
        dbHelper = new DB_Helper(getActivity());
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
        nama.setText("Halo, "+Nama);
        namaSiswa.setText(Nama);
        DIALOG();
        if (SwitchMasuk.isChecked()){
            CheckMasuk.setText("Masuk");
        }else{
            CheckMasuk.setText("Tidak\nMasuk");
        }
        SwitchMasuk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (SwitchMasuk.isChecked()){
                    CheckMasuk.setText("Masuk");
                }else{
                    CheckMasuk.setText("Tidak\nMasuk");
                }
            }
        });
        if (Level.equals("guest")){
            JadwalPelajaran.setAlpha(0.2f);
            DJadwalPelajaran.setAlpha(0.2f);
            Evadir.setAlpha(0.2f);
            DEvadir.setAlpha(0.2f);
            Tugas.setAlpha(0.2f);
            DTugas.setAlpha(0.2f);
            DERaport.setAlpha(0.2f);
            DPembayaran.setAlpha(0.2f);
        }
        ONCLICK();
        ONCLICKDIALOG();
        Gallery();
        Header();
        KabarBerita();
        Sponsor();
        GetPoint();
        GetSekolah();
    }
    private void Gallery(){
        mManager = new LinearLayoutManager(getActivity(),RecyclerView.HORIZONTAL,false);
        recyclerGallery.setLayoutManager(mManager);
        ApiRequest api = RetroServer.getClient().create(ApiRequest.class);
        Call<ResponseModel> sponsor = api.Gallery(destiny.AUTH(Token));
        sponsor.enqueue(new Callback<ResponseModel>() {
            @Override
            public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {
                try {
                    if (response.body().getStatusCode().equals("000")){
                        mItems=response.body().getData();
                        mAdapter = new AdapterGalleryHome(getActivity(),mItems);
                        recyclerGallery.setAdapter(mAdapter);
                        mAdapter.notifyDataSetChanged();
                    }else if (response.body().getStatusCode().equals("001") || response.body().getStatusCode().equals("002")){
                        destiny.AutoLogin(Username,Password,getActivity());
                        Header();
                    }else{
                        Toast.makeText(getActivity(), "Terjadi Kesalahan ", Toast.LENGTH_SHORT).show();
                    }
                }catch (Exception e){
                    Toast.makeText(getActivity(), "Terjadi Kesalahan User akan Terlogout", Toast.LENGTH_SHORT).show();
                    dbHelper.Logout();
                    Intent intent = new Intent(getActivity(), LoginActivity.class);
                    startActivity(intent);
                    getActivity().finish();
                }
            }

            @Override
            public void onFailure(Call<ResponseModel> call, Throwable t) {
                Toast.makeText(getActivity(), "Koneksi Gagal", Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void GetSekolah(){
        ApiRequest api = RetroServer.getClient().create(ApiRequest.class);
        Call<ResponseModel> Point = api.ProfileSekolah(destiny.AUTH(Token));
        Point.enqueue(new Callback<ResponseModel>() {
            @Override
            public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {
                try {
                    if (response.body().getStatusCode().equals("000")){
                        Sekolah.setText(response.body().getData().get(0).getNama_sekolah());
                        SekolahBesar.setText(response.body().getData().get(0).getNama_sekolah());
                        Glide.with(getActivity())
                                .load(destiny.BASE_URL()+response.body().getData().get(0).getLogo_sekolah())
                                .into(Logo);
                    }else if (response.body().getStatusCode().equals("001") || response.body().getStatusCode().equals("002")){
                        destiny.AutoLogin(Username,Password,getActivity());
                        Intent intent = new Intent(getActivity(), MainActivity.class);
                        startActivity(intent);
                        getActivity().finish();
                    }else{
                        Toast.makeText(getActivity(), "Terjadi Kesalahan ", Toast.LENGTH_SHORT).show();
                    }
                }catch (Exception e){
                    Toast.makeText(getActivity(), "Terjadi Kesalahan User akan Terlogout", Toast.LENGTH_SHORT).show();
                    dbHelper.Logout();
                    Intent intent = new Intent(getActivity(), LoginActivity.class);
                    startActivity(intent);
                    getActivity().finish();
                }
            }

            @Override
            public void onFailure(Call<ResponseModel> call, Throwable t) {
                Toast.makeText(getActivity(), "Koneksi Gagal", Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void GetPoint(){
        ApiRequest api = RetroServer.getClient().create(ApiRequest.class);
        Call<ResponseModel> Point = api.PointSiswa(destiny.AUTH(Token));
        Point.enqueue(new Callback<ResponseModel>() {
            @Override
            public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {
                try {
                    if (response.body().getStatusCode().equals("000")){
                        Poin.setText(response.body().getData().get(0).getPoin());
                    }else if (response.body().getStatusCode().equals("001") || response.body().getStatusCode().equals("002")){
                        destiny.AutoLogin(Username,Password,getActivity());
                        Intent intent = new Intent(getActivity(), MainActivity.class);
                        startActivity(intent);
                        getActivity().finish();
                    }else{
                        Toast.makeText(getActivity(), "Terjadi Kesalahan ", Toast.LENGTH_SHORT).show();
                    }
                }catch (Exception e){
                    Toast.makeText(getActivity(), "Terjadi Kesalahan User akan Terlogout", Toast.LENGTH_SHORT).show();
                    dbHelper.Logout();
                    Intent intent = new Intent(getActivity(), LoginActivity.class);
                    startActivity(intent);
                    getActivity().finish();
                }
            }

            @Override
            public void onFailure(Call<ResponseModel> call, Throwable t) {
                Toast.makeText(getActivity(), "Koneksi Gagal", Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void Sponsor(){
        mManager = new GridLayoutManager(getActivity(),3);
        recylerSponsor.setLayoutManager(mManager);
        ApiRequest api = RetroServer.getClient().create(ApiRequest.class);
        Call<ResponseModel> sponsor = api.Sponsor(destiny.AUTH(Token));
        sponsor.enqueue(new Callback<ResponseModel>() {
            @Override
            public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {
                try {
                    if (response.body().getStatusCode().equals("000")){
                        mItems=response.body().getData();
                        mAdapter = new AdapterSponsor(getActivity(),mItems);
                        recylerSponsor.setAdapter(mAdapter);
                        mAdapter.notifyDataSetChanged();
                    }else if (response.body().getStatusCode().equals("001") || response.body().getStatusCode().equals("002")){
                        destiny.AutoLogin(Username,Password,getActivity());
                        Header();
                    }else{
                        Toast.makeText(getActivity(), "Terjadi Kesalahan ", Toast.LENGTH_SHORT).show();
                    }
                }catch (Exception e){
                    Toast.makeText(getActivity(), "Terjadi Kesalahan User akan Terlogout", Toast.LENGTH_SHORT).show();
                    dbHelper.Logout();
                    Intent intent = new Intent(getActivity(), LoginActivity.class);
                    startActivity(intent);
                    getActivity().finish();
                }
            }

            @Override
            public void onFailure(Call<ResponseModel> call, Throwable t) {
                Toast.makeText(getActivity(), "Koneksi Gagal", Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void Header(){
        mManager = new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false);
        recycler.setLayoutManager(mManager);
        ApiRequest api = FajarKontol.getClient().create(ApiRequest.class);
        Call<ResponseModel> KabarBerita = api.InfoPublik();
        KabarBerita.enqueue(new Callback<ResponseModel>() {
            @Override
            public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {
                try {
                    mItems=response.body().getData();
                    mAdapter = new AdapterInfoPublik(getActivity(),mItems);
                    recycler.setAdapter(mAdapter);
                    mAdapter.notifyDataSetChanged();
                }catch (Exception e){
                    Toast.makeText(getActivity(), "Terjadi Kesalahan User akan Terlogout", Toast.LENGTH_SHORT).show();
                    dbHelper.Logout();
                    Intent intent = new Intent(getActivity(), LoginActivity.class);
                    startActivity(intent);
                    getActivity().finish();
                }
            }

            @Override
            public void onFailure(Call<ResponseModel> call, Throwable t) {
                Toast.makeText(getActivity(), "Koneksi Gagal", Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void KabarBerita(){
        mManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL,false);
        recyclerKabar.setLayoutManager(mManager);
        ApiRequest api = RetroServer.getClient().create(ApiRequest.class);
        Call<ResponseModel> KabarBerita = api.KabarSekolah(destiny.AUTH(Token));
        KabarBerita.enqueue(new Callback<ResponseModel>() {
            @Override
            public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {
                try {
                    if (response.body().getStatusCode().equals("000")){
                        mItems=response.body().getData();
                        mAdapter = new AdapterKabarBerita(getActivity(),mItems);
                        recyclerKabar.setAdapter(mAdapter);
                        mAdapter.notifyDataSetChanged();
                    }else if (response.body().getStatusCode().equals("001") || response.body().getStatusCode().equals("002")){
                        destiny.AutoLogin(Username,Password,getActivity());
                        KabarBerita();
                    }else{
                        Toast.makeText(getActivity(), "Terjadi Kesalahan ", Toast.LENGTH_SHORT).show();
                    }
                }catch (Exception e){
                    Toast.makeText(getActivity(), "Terjadi Kesalahan User akan Terlogout", Toast.LENGTH_SHORT).show();
                    dbHelper.Logout();
                    Intent intent = new Intent(getActivity(), LoginActivity.class);
                    startActivity(intent);
                    getActivity().finish();
                }
            }

            @Override
            public void onFailure(Call<ResponseModel> call, Throwable t) {
                Toast.makeText(getActivity(), "Koneksi Gagal", Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void DIALOG(){
        DProfilSekolah = dialog.findViewById(R.id.linearProfilSekolah);
        DAgendaSekolah = dialog.findViewById(R.id.linearAgendaSekolah);
        DPrestasi = dialog.findViewById(R.id.linearPrestasi);
        DPPDB = dialog.findViewById(R.id.linearPPDB);
        DStrukturSekolah = dialog.findViewById(R.id.linearStrukturOrganisasi);
        DJadwalPelajaran = dialog.findViewById(R.id.linearJadwalPelajaran);
        DEvadir = dialog.findViewById(R.id.linearEvadir);
        DMediaPembelajaran = dialog.findViewById(R.id.linearMediaPembelajaran);
        DTugas = dialog.findViewById(R.id.linearTugas);
        DGuru = dialog.findViewById(R.id.linearGuru);
        DBiayaAkademik = dialog.findViewById(R.id.linearBiayaAkademik);
        DPembayaran = dialog.findViewById(R.id.linearPembayaran);
        DROB = dialog.findViewById(R.id.linearROB);
        DERaport = dialog.findViewById(R.id.linearEraport);
        DGallery = dialog.findViewById(R.id.linearGallery);
    }
    private void ONCLICKDIALOG(){
        DProfilSekolah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                destiny.ChangeActivity(getActivity(),"Profile Sekolah",Level);
            }
        });
        DAgendaSekolah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                destiny.ChangeActivity(getActivity(),"Agenda Sekolah",Level);
            }
        });
        DPrestasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                destiny.ChangeActivity(getActivity(),"Prestasi",Level);
            }
        });
        DPPDB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                destiny.ChangeActivity(getActivity(),"PPDB",Level);
            }
        });
        DStrukturSekolah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                destiny.ChangeActivity(getActivity(),"Struktur Sekolah",Level);
            }
        });
        DJadwalPelajaran.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                destiny.ChangeActivity(getActivity(),"Jadwal Pelajaran",Level);
            }
        });
        DEvadir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                destiny.ChangeActivity(getActivity(),"Evadir",Level);
            }
        });
        DMediaPembelajaran.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                destiny.ChangeActivity(getActivity(),"Media Pembelajaran",Level);
            }
        });
        DTugas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                destiny.ChangeActivity(getActivity(),"Tugas",Level);
            }
        });
        DGuru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                destiny.ChangeActivity(getActivity(),"Tugas",Level);
            }
        });
        DGuru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                destiny.ChangeActivity(getActivity(),"Guru",Level);
            }
        });
        DBiayaAkademik.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                destiny.ChangeActivity(getActivity(),"Biaya Akademik",Level);
            }
        });
        DPembayaran.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                destiny.ChangeActivity(getActivity(),"Pembayaran",Level);
            }
        });
        DROB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                destiny.ChangeActivity(getActivity(),"ROB",Level);
            }
        });
        DERaport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                destiny.ChangeActivity(getActivity(),"E-Raport",Level);
            }
        });
        DGallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                destiny.ChangeActivity(getActivity(),"Gallery",Level);
            }
        });
    }
    private void ONCLICK(){
        ProfilSekolah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                destiny.ChangeActivity(getActivity(),"Profile Sekolah",Level);
            }
        });
        AgendaSekolah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                destiny.ChangeActivity(getActivity(),"Agenda Sekolah",Level);
            }
        });
        Prestasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                destiny.ChangeActivity(getActivity(),"Prestasi",Level);
            }
        });
        PPDB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                destiny.ChangeActivity(getActivity(),"PPDB",Level);
            }
        });
        StrukturSekolah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                destiny.ChangeActivity(getActivity(),"Struktur Sekolah",Level);
            }
        });
        JadwalPelajaran.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                destiny.ChangeActivity(getActivity(),"Jadwal Pelajaran",Level);
            }
        });
        Evadir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                destiny.ChangeActivity(getActivity(),"Evadir",Level);
            }
        });
        MediaPembelajaran.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                destiny.ChangeActivity(getActivity(),"Media Pembelajaran",Level);
            }
        });
        Tugas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                destiny.ChangeActivity(getActivity(),"Tugas",Level);
            }
        });
        infoDinas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                destiny.ChangeActivity(getActivity(),"Dinas Pendidikan",Level);
            }
        });
        KemisNyunda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                destiny.ChangeActivity(getActivity(),"Kemis Nyunda",Level);
            }
        });
        JumatNgaji.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                destiny.ChangeActivity(getActivity(),"Jumat Ngaji",Level);
            }
        });
        MediaInformasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                destiny.ChangeActivity(getActivity(),"Media Informasi",Level);
            }
        });
        LihatSemua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.show();
            }
        });
        Kembali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.hide();
            }
        });
        LihatSemuaKabarBerita.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), KabarBeritaActivity.class);
                startActivity(intent);
            }
        });
        LihatSemuaSponsor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), SponsorActivity.class);
                startActivity(intent);
            }
        });
        LihatSemuaGallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), GalleryActivity.class);
                startActivity(intent);
            }
        });
    }
}