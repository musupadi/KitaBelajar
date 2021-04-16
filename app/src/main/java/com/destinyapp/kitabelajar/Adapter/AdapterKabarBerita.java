package com.destinyapp.kitabelajar.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.destinyapp.kitabelajar.Acitvity.menu.DetailKabarSekolahActivity;
import com.destinyapp.kitabelajar.Method.Destiny;
import com.destinyapp.kitabelajar.Model.DataModel;
import com.destinyapp.kitabelajar.R;
import com.destinyapp.kitabelajar.SharedPreferance.DB_Helper;

import java.util.List;

public class AdapterKabarBerita extends RecyclerView.Adapter<AdapterKabarBerita.HolderData> {
    private List<DataModel> mList;
    private Context ctx;

    DB_Helper dbHelper;
    Boolean onClick=false;
    RecyclerView recyclerView;
    Destiny destiny;
    public AdapterKabarBerita(Context ctx, List<DataModel> mList){
        this.ctx = ctx;
        this.mList = mList;
    }

    @NonNull
    @Override
    public HolderData onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View layout = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_kabar_home,viewGroup,false);
        HolderData holder = new HolderData(layout);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final HolderData holderData, int posistion) {
        destiny = new Destiny();
        final DataModel dm = mList.get(posistion);
        holderData.Judul.setText(dm.getJudul_kabar());
        holderData.Deskripsi.setText(destiny.SmallDescription(destiny.FilterTextToJava(dm.getIsi_kabar())));
        holderData.Tanggal.setText(destiny.MagicDateChange(dm.getCreated_at_kabar()));
        Glide.with(ctx)
                .load(destiny.CheckerImageYoutube(dm.getLink_youtube_kabar(),dm.getCover_kabar()))
                .into(holderData.Image);
//        if (dm.getLink_youtube_kabar().equals("") || dm.getLink_youtube_kabar().isEmpty()){
//
//        }else{
//            Glide.with(ctx)
//                    .load(destiny.BASE_URL()+dm.getCover_kabar())
//                    .into(holderData.Image);
//        }
//        Toast.makeText(ctx, destiny.CheckerImageYoutube(dm.getLink_youtube_kabar(),dm.getCover_kabar()), Toast.LENGTH_SHORT).show();
        holderData.card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ctx, DetailKabarSekolahActivity.class);
                i.putExtra("JUDUL", dm.getJudul_kabar());
                i.putExtra("ISI",dm.getIsi_kabar());
                i.putExtra("TANGGAL",dm.getCreated_at_kabar());
                i.putExtra("GAMBAR",destiny.BASE_URL()+dm.getCover_kabar());
                i.putExtra("YOUTUBE",dm.getLink_youtube_kabar());
                ctx.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    class HolderData extends RecyclerView.ViewHolder{
        ImageView Image;
        TextView Judul,Deskripsi,Tanggal;
        LinearLayout card;
        public HolderData(View v){
            super(v);
            Image = v.findViewById(R.id.ivGambar);
            Judul = v.findViewById(R.id.tvJudul);
            Deskripsi = v.findViewById(R.id.tvDeskripsi);
            Tanggal = v.findViewById(R.id.tvTanggal);
            card = v.findViewById(R.id.LayoutCardView);
        }
    }
}

