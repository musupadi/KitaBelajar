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

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.destinyapp.kitabelajar.Acitvity.menu.DetailKabarSekolahActivity;
import com.destinyapp.kitabelajar.Method.Destiny;
import com.destinyapp.kitabelajar.Model.DataModel;
import com.destinyapp.kitabelajar.Model.Produk;
import com.destinyapp.kitabelajar.R;
import com.destinyapp.kitabelajar.SharedPreferance.DB_Helper;

import java.util.List;

public class AdapterProduk extends RecyclerView.Adapter<AdapterProduk.HolderData> {
    private List<Produk> mList;
    private Context ctx;

    DB_Helper dbHelper;
    Boolean onClick=false;
    RecyclerView recyclerView;
    Destiny destiny;
    public AdapterProduk(Context ctx, List<Produk> mList){
        this.ctx = ctx;
        this.mList = mList;
    }

    @NonNull
    @Override
    public HolderData onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View layout = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_produk,viewGroup,false);
        HolderData holder = new HolderData(layout);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final HolderData holderData, int posistion) {
        destiny = new Destiny();
        final Produk dm = mList.get(posistion);
        holderData.Sekolah.setText(dm.getNama_produk());
        holderData.Penjual.setText(dm.getNama_sekolah());
        holderData.Harga.setText(destiny.MagicRP(Double.parseDouble(dm.getHarga_produk())));
        if (dm.getCover_produk().equals("")){
            holderData.Image.setImageResource(R.drawable.childern);
        }else{
            Glide.with(ctx)
                    .load(destiny.BASE_URL()+dm.getCover_produk())
                    .into(holderData.Image);
        }
//        if (dm.getLink_youtube_kabar().equals("") || dm.getLink_youtube_kabar().isEmpty()){
//
//        }else{
//            Glide.with(ctx)
//                    .load(destiny.BASE_URL()+dm.getCover_kabar())
//                    .into(holderData.Image);
//        }
//        Toast.makeText(ctx, destiny.CheckerImageYoutube(dm.getLink_youtube_kabar(),dm.getCover_kabar()), Toast.LENGTH_SHORT).show();
//        holderData.card.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent i = new Intent(ctx, DetailKabarSekolahActivity.class);
//                i.putExtra("JUDUL", dm.getJudul_kabar());
//                i.putExtra("ISI",dm.getIsi_kabar());
//                i.putExtra("TANGGAL",dm.getCreated_at_kabar());
//                i.putExtra("GAMBAR",destiny.BASE_URL()+dm.getCover_kabar());
//                i.putExtra("YOUTUBE",dm.getLink_youtube_kabar());
//                ctx.startActivity(i);
//            }
//        });
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    class HolderData extends RecyclerView.ViewHolder{
        ImageView Image;
        TextView Sekolah,Penjual,Harga;
        Button Detail;
        LinearLayout card;
        public HolderData(View v){
            super(v);
            Image = v.findViewById(R.id.ivLogo);
            Sekolah = v.findViewById(R.id.tvNamaSekolah);
            Penjual = v.findViewById(R.id.tvNamaPenjual);
            Harga = v.findViewById(R.id.tvHarga);
            Detail = v.findViewById(R.id.btnDetail);
            card = v.findViewById(R.id.LayoutCardView);
        }
    }
}


