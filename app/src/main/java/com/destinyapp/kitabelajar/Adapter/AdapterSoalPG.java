package com.destinyapp.kitabelajar.Adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.destinyapp.kitabelajar.Acitvity.DetailSponsorActivity;
import com.destinyapp.kitabelajar.Method.Destiny;
import com.destinyapp.kitabelajar.Model.DataModel;
import com.destinyapp.kitabelajar.R;
import com.destinyapp.kitabelajar.SharedPreferance.DB_Helper;

import java.util.ArrayList;
import java.util.List;

public class AdapterSoalPG extends RecyclerView.Adapter<AdapterSoalPG.HolderData> {
    private Context ctx;
    Destiny destiny;
    int Soal;
    ArrayList<String> JAWABAN = new ArrayList<String>();
    public AdapterSoalPG(Context ctx,int Soal,ArrayList<String> JAWABAN){
        this.ctx = ctx;
        this.Soal = Soal;
        this.JAWABAN = JAWABAN;
    }

    @NonNull
    @Override
    public HolderData onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View layout = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_soal_pg,viewGroup,false);
        HolderData holder = new HolderData(layout);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final HolderData holderData, final int posistion) {
        destiny = new Destiny();
        int POSITION = posistion+1;
        holderData.Nomor.setText("Soal Nomor : "+POSITION);
        JAWABAN.add("");
        if (JAWABAN.size()>Soal){
            JAWABAN.remove(posistion);
        }
        if (JAWABAN.get(posistion).equals("")){
            DEFAULT(holderData.A,holderData.B,holderData.C,holderData.D);
        }
        holderData.A.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DEFAULT(holderData.A,holderData.B,holderData.C,holderData.D);
                Clicked(holderData.A,"a",posistion);
            }
        });
        holderData.B.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DEFAULT(holderData.A,holderData.B,holderData.C,holderData.D);
                Clicked(holderData.B,"b",posistion);
            }
        });
        holderData.C.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DEFAULT(holderData.A,holderData.B,holderData.C,holderData.D);
                Clicked(holderData.C,"c",posistion);
            }
        });
        holderData.D.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DEFAULT(holderData.A,holderData.B,holderData.C,holderData.D);
                Clicked(holderData.D,"d",posistion);
            }
        });

    }

    @Override
    public int getItemCount() {
        return Soal;
    }

    class HolderData extends RecyclerView.ViewHolder{
        LinearLayout LA,LB,LC,LD;
        Button A,B,C,D;
        TextView Nomor;
        public HolderData(View v){
            super(v);
            LA = v.findViewById(R.id.linearA);
            LB = v.findViewById(R.id.linearB);
            LC = v.findViewById(R.id.linearC);
            LD = v.findViewById(R.id.linearD);
            A = v.findViewById(R.id.btnA);
            B = v.findViewById(R.id.btnB);
            C = v.findViewById(R.id.btnC);
            D = v.findViewById(R.id.btnD);
            Nomor = v.findViewById(R.id.tvNomorJawaban);
        }
    }
    public void DEFAULT(Button a,Button b,Button c,Button d){
        a.setBackgroundResource(R.drawable.round_background);
        b.setBackgroundResource(R.drawable.round_background);
        c.setBackgroundResource(R.drawable.round_background);
        d.setBackgroundResource(R.drawable.round_background);
        a.setTextColor(Color.rgb(1,85,142));
        b.setTextColor(Color.rgb(1,85,142));
        c.setTextColor(Color.rgb(1,85,142));
        d.setTextColor(Color.rgb(1,85,142));
    }
    public void Clicked(Button btn,String Jawab,int position){
        btn.setBackgroundResource(R.drawable.round_blue);
        btn.setTextColor(Color.rgb(255,255,255));
        JAWABAN.set(position,Jawab);
    }
}

