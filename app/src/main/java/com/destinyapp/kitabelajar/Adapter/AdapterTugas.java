package com.destinyapp.kitabelajar.Adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.destinyapp.kitabelajar.Acitvity.menu.MediaPembelajaran.DetailMediaPembelajaranActivity;
import com.destinyapp.kitabelajar.Acitvity.menu.Tugas.SoalEssayActivity;
import com.destinyapp.kitabelajar.Acitvity.menu.Tugas.SoalPGActivity;
import com.destinyapp.kitabelajar.Acitvity.menu.Tugas.TugasTugasActivity;
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
//        holderData.NamaTugas.loadData(dm.getIsi_tugas(),"text/html","UTF-8");
        holderData.NamaTugas.setText(destiny.SmallDescription(destiny.FilterTextToJava(dm.getIsi_tugas())));
        if (dm.getJenis_tugas().equals("pg")){
            holderData.card1.setVisibility(View.VISIBLE);
            holderData.card2.setVisibility(View.GONE);
            holderData.ivTugas.setImageResource(R.drawable.pilihan_ganda);
            holderData.Tugas.setText("Pilihan Ganda");
        }else if (dm.getJenis_tugas().equals("tugas")){
            holderData.card1.setVisibility(View.GONE);
            holderData.card2.setVisibility(View.VISIBLE);
            holderData.Periode.setText(destiny.MagicDateChange(dm.getTgl_selesai()));
            holderData.Nama.setText(dm.getNama_mapel()+" "+dm.getTgl_mulai());
            holderData.Deskripsi.loadData(dm.getIsi_tugas(),"text/html","UTF-8");
            holderData.Tautan.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(destiny.BASE_URL()+dm.getFile_tugas()));
                    ctx.startActivity(browserIntent);
                }
            });
            holderData.Download.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(ctx);
                    builder.setMessage("Download File ?")
                            .setCancelable(false)
                            .setPositiveButton("Iya", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    destiny.DownloadPDF(destiny.BASE_URL()+dm.getFile_tugas(),dm.getNama_mapel()+" "+dm.getTgl_mulai(),ctx);
                                }
                            })
                            .setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    dialog.cancel();
                                }
                            })
                            //Set your icon here
                            .setTitle("Perhatian !!!")
                            .setIcon(R.drawable.ic_baseline_print_24);
                    AlertDialog alert = builder.create();
                    alert.show();
                }
            });
            if (dm.getTerjawab().equals("0")){
                holderData.Upload.setAlpha(0.3f);
            }
            holderData.Upload.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (dm.getTerjawab().equals("1")){
                        Toast.makeText(ctx, "Data Sudah Terjawab", Toast.LENGTH_SHORT).show();
                    }else{
                        Intent i = new Intent(ctx, TugasTugasActivity.class);
                        i.putExtra("ID", dm.getId_tugas());
                        i.putExtra("NAMA",destiny.FilterTextToJava(dm.getIsi_tugas()));
                        ctx.startActivity(i);
                    }
                }
            });
        }else{
            holderData.card1.setVisibility(View.VISIBLE);
            holderData.card2.setVisibility(View.GONE);
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
                    if (dm.getTerjawab().equals("0")){
                        if (dm.getScore_tugas().equals("0")){
                            if (dm.getJenis_tugas().equals("pg")){
                                Intent i = new Intent(ctx, SoalPGActivity.class);
                                i.putExtra("ID", dm.getId_tugas());
                                i.putExtra("NAMA",destiny.FilterTextToJava(dm.getIsi_tugas()));
                                ctx.startActivity(i);
                            }else{
                                Intent i = new Intent(ctx, SoalEssayActivity.class);
                                i.putExtra("ID", dm.getId_tugas());
                                i.putExtra("NAMA",destiny.FilterTextToJava(dm.getIsi_tugas()));
                                ctx.startActivity(i);
                            }
                        }else{
                            Toast.makeText(ctx, "Nilai Sudah Dikirimkan ke Guru", Toast.LENGTH_SHORT).show();
                        }
                    }else{
                        Toast.makeText(ctx, "Tugas Sudah Terjawab", Toast.LENGTH_SHORT).show();
                    }
                }catch(Exception e){
                    if (dm.getTerjawab().equals("0")){
                        if (dm.getJenis_tugas().equals("pg")){
                            Intent i = new Intent(ctx, SoalPGActivity.class);
                            i.putExtra("ID", dm.getId_tugas());
                            i.putExtra("NAMA",destiny.FilterTextToJava(dm.getIsi_tugas()));
                            ctx.startActivity(i);
                        }else{
                            Intent i = new Intent(ctx, SoalEssayActivity.class);
                            i.putExtra("ID", dm.getId_tugas());
                            i.putExtra("NAMA",destiny.FilterTextToJava(dm.getIsi_tugas()));
                            ctx.startActivity(i);
                        }
                    }else{
                        Toast.makeText(ctx, "Tugas Sudah Terjawab", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
        holderData.Mulai.setText(destiny.MagicDateChange(dm.getTgl_mulai()));
        holderData.Selesai.setText(destiny.MagicDateChange(dm.getTgl_selesai()));

        //Card Tugas
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    class HolderData extends RecyclerView.ViewHolder{ ;
        TextView Tugas,Mulai,Selesai;
        ImageView ivTugas;
        Button Nilai;
        TextView NamaTugas;
        LinearLayout card;

        CardView card2,card1;
        Button Tautan,Download,Upload;
        WebView Deskripsi;
        TextView Nama,Periode;
        public HolderData(View v){
            super(v);
            NamaTugas = v.findViewById(R.id.tvNamaTugas);
            Tugas = v.findViewById(R.id.tvTugas);
            Nilai = v.findViewById(R.id.btnNilai);
            Mulai = v.findViewById(R.id.tvTglMulai);
            Selesai = v.findViewById(R.id.tvTanggalSelesai);
            ivTugas = v.findViewById(R.id.ivTugas);
            card = v.findViewById(R.id.card_view);
            card1 = v.findViewById(R.id.card1);

            //TUGAS
            card2 = v.findViewById(R.id.cardTugas);
            Periode = v.findViewById(R.id.tvPeriode);
            Deskripsi = v.findViewById(R.id.tvDeskripsi);
            Nama = v.findViewById(R.id.tvNama);
            Tautan = v.findViewById(R.id.btnTautan);
            Download = v.findViewById(R.id.btnDownload);
            Upload = v.findViewById(R.id.btnUpload);
        }
    }
}


