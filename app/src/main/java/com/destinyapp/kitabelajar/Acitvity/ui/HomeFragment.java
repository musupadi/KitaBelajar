package com.destinyapp.kitabelajar.Acitvity.ui;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;

import com.destinyapp.kitabelajar.Acitvity.menu.FormulirPPDBActivity;
import com.destinyapp.kitabelajar.Mehod.Destiny;
import com.destinyapp.kitabelajar.R;


public class HomeFragment extends Fragment {

    Switch SwitchMasuk;
    TextView CheckMasuk;
    LinearLayout ProfilSekolah,AgendaSekolah,Prestasi,PPDB,StrukturSekolah,JadwalPelajaran,Evadir,MediaPembelajaran,Tugas,LihatSemua;
    LinearLayout DProfilSekolah,DAgendaSekolah,DPrestasi,DPPDB,DStrukturSekolah,DJadwalPelajaran,DEvadir,DMediaPembelajaran,DTugas,DGuru,DBiayaAkademik,DPembayaran,DROB;
    //Dialog
    Dialog dialog;
    Button Kembali;
    Destiny destiny;
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
        dialog = new Dialog(getActivity());
        dialog.setContentView(R.layout.dialog_menu_all);
        Kembali = dialog.findViewById(R.id.btnKembali);
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
        ONCLICK();
        ONCLICKDIALOG();
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
    }
    private void ONCLICKDIALOG(){
        DProfilSekolah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                destiny.ChangeActivity(getActivity(),"Profile Sekolah");
            }
        });
        DAgendaSekolah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                destiny.ChangeActivity(getActivity(),"Agenda Sekolah");
            }
        });
        DPrestasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                destiny.ChangeActivity(getActivity(),"Prestasi");
            }
        });
        DPPDB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                destiny.ChangeActivity(getActivity(),"PPDB");
            }
        });
        DStrukturSekolah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                destiny.ChangeActivity(getActivity(),"Struktur Sekolah");
            }
        });
        DJadwalPelajaran.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                destiny.ChangeActivity(getActivity(),"Jadwal Pelajaran");
            }
        });
        DEvadir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                destiny.ChangeActivity(getActivity(),"Evadir");
            }
        });
        DMediaPembelajaran.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                destiny.ChangeActivity(getActivity(),"Media Pembelajaran");
            }
        });
        DTugas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                destiny.ChangeActivity(getActivity(),"Tugas");
            }
        });
        DGuru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                destiny.ChangeActivity(getActivity(),"Tugas");
            }
        });
        DGuru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                destiny.ChangeActivity(getActivity(),"Guru");
            }
        });
        DBiayaAkademik.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                destiny.ChangeActivity(getActivity(),"Biaya Akademik");
            }
        });
        DPembayaran.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                destiny.ChangeActivity(getActivity(),"Pembayaran");
            }
        });
        DROB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                destiny.ChangeActivity(getActivity(),"ROB");
            }
        });
    }
    private void ONCLICK(){
        ProfilSekolah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                destiny.ChangeActivity(getActivity(),"Profile Sekolah");
            }
        });
        AgendaSekolah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                destiny.ChangeActivity(getActivity(),"Agenda Sekolah");
            }
        });
        Prestasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                destiny.ChangeActivity(getActivity(),"Prestasi");
            }
        });
        PPDB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                destiny.ChangeActivity(getActivity(),"PPDB");
            }
        });
        StrukturSekolah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                destiny.ChangeActivity(getActivity(),"Struktur Sekolah");
            }
        });
        JadwalPelajaran.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                destiny.ChangeActivity(getActivity(),"Jadwal Pelajaran");
            }
        });
        Evadir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                destiny.ChangeActivity(getActivity(),"Evadir");
            }
        });
        MediaPembelajaran.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                destiny.ChangeActivity(getActivity(),"Media Pembelajaran");
            }
        });
        Tugas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                destiny.ChangeActivity(getActivity(),"Tugas");
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
    }
}