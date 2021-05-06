package com.destinyapp.kitabelajar.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.destinyapp.kitabelajar.Acitvity.menu.MediaPembelajaran.DetailMediaPembelajaranActivity;
import com.destinyapp.kitabelajar.Acitvity.menu.Tugas.SoalEssayActivity;
import com.destinyapp.kitabelajar.Acitvity.menu.Tugas.SoalPGActivity;
import com.destinyapp.kitabelajar.Method.Destiny;
import com.destinyapp.kitabelajar.Model.DataModel;
import com.destinyapp.kitabelajar.R;
import com.destinyapp.kitabelajar.SharedPreferance.DB_Helper;

import java.util.List;

public class AdapterTugas extends RecyclerView.Adapter<AdapterTugas.HolderData>  {
    private List<DataModel> mList;
    private Context ctx;

    Destiny destiny;
    public AdapterTugas(Context ctx, List<DataModel> mList){
        this.ctx = ctx;
        this.mList = mList;
    }

    @NonNull
    @Override
    public HolderData onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View layout = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_tugas,viewGroup,false);
        HolderData holder = new HolderData(layout);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final HolderData holderData, int posistion) {
        destiny = new Destiny();
        final DataModel dm = mList.get(posistion);
        holderData.NamaTugas.setText(dm.getIsi_tugas());
        if (dm.getJenis_tugas().equals("pg")){
            holderData.ivTugas.setImageResource(R.drawable.pilihan_ganda);
            holderData.Tugas.setText("Pilihan Ganda");
        }else{
            holderData.ivTugas.setImageResource(R.drawable.essay);
            holderData.Tugas.setText("Essay");
        }
        try {
            if (dm.getScore_tugas().equals("0")){
                holderData.Nilai.setVisibility(View.GONE);
            }else{
                holderData.Nilai.setText("Nilai : "+dm.getScore_tugas());
            }
        }catch(Exception e){
            holderData.Nilai.setVisibility(View.GONE);
        }
        holderData.card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (dm.getScore_tugas().equals("0")){
                        if (dm.getJenis_tugas().equals("pg")){
                            Intent i = new Intent(ctx, SoalPGActivity.class);
                            i.putExtra("ID", dm.getId_tugas());
                            i.putExtra("NAMA",dm.getIsi_tugas());
                            ctx.startActivity(i);
                        }else{
                            Intent i = new Intent(ctx, SoalEssayActivity.class);
                            i.putExtra("ID", dm.getId_tugas());
                            i.putExtra("NAMA",dm.getIsi_tugas());
                            ctx.startActivity(i);
                        }
                    }else{
                        Toast.makeText(ctx, "Nilai Sudah Dikirimkan ke Guru", Toast.LENGTH_SHORT).show();
                    }
                }catch(Exception e){
                    if (dm.getJenis_tugas().equals("pg")){
                        Intent i = new Intent(ctx, SoalPGActivity.class);
                        i.putExtra("ID", dm.getId_tugas());
                        i.putExtra("NAMA",dm.getIsi_tugas());
                        ctx.startActivity(i);
                    }else{
                        Intent i = new Intent(ctx, SoalEssayActivity.class);
                        i.putExtra("ID", dm.getId_tugas());
                        i.putExtra("NAMA",dm.getIsi_tugas());
                        ctx.startActivity(i);
                    }
                }

            }
        });
        holderData.Mulai.setText(destiny.MagicDateChange(dm.getTgl_mulai()));
        holderData.Selesai.setText(destiny.MagicDateChange(dm.getTgl_selesai()));
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    class HolderData extends RecyclerView.ViewHolder{ ;
        TextView NamaTugas,Tugas,Mulai,Selesai;
        ImageView ivTugas;
        Button Nilai;
        LinearLayout card;
        public HolderData(View v){
            super(v);
            NamaTugas = v.findViewById(R.id.tvNamaTugas);
            Tugas = v.findViewById(R.id.tvTugas);
            Nilai = v.findViewById(R.id.btnNilai);
            Mulai = v.findViewById(R.id.tvTglMulai);
            Selesai = v.findViewById(R.id.tvTanggalSelesai);
            ivTugas = v.findViewById(R.id.ivTugas);
            card = v.findViewById(R.id.card_view);
        }
    }
}


