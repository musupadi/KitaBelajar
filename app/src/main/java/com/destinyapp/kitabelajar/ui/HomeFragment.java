package com.destinyapp.kitabelajar.ui;

import android.app.Dialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;

import com.destinyapp.kitabelajar.R;


public class HomeFragment extends Fragment {

    Switch SwitchMasuk;
    TextView CheckMasuk;
    LinearLayout LihatSemua;
    //Dialog
    Dialog dialog;
    LinearLayout Kembali;
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
        SwitchMasuk = view.findViewById(R.id.switchMasuk);
        CheckMasuk = view.findViewById(R.id.tvCheckMasuk);
        LihatSemua = view.findViewById(R.id.linearLihatSemua);
        dialog = new Dialog(getActivity());
        dialog.setContentView(R.layout.dialog_menu_all);
        Kembali = dialog.findViewById(R.id.linearKembali);
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