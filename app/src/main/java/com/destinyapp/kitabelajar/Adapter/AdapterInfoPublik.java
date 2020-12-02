package com.destinyapp.kitabelajar.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.destinyapp.kitabelajar.Acitvity.DetailInfoPublik;
import com.destinyapp.kitabelajar.Acitvity.menu.DetailKabarSekolahActivity;
import com.destinyapp.kitabelajar.Method.Destiny;
import com.destinyapp.kitabelajar.Model.DataModel;
import com.destinyapp.kitabelajar.R;
import com.destinyapp.kitabelajar.SharedPreferance.DB_Helper;

import java.util.List;

public class AdapterInfoPublik extends RecyclerView.Adapter<AdapterInfoPublik.HolderData> {
    private List<DataModel> mList;
    private Context ctx;

    DB_Helper dbHelper;
    Boolean onClick=false;
    RecyclerView recyclerView;
    Destiny destiny;
    public AdapterInfoPublik (Context ctx, List<DataModel> mList){
        this.ctx = ctx;
        this.mList = mList;
    }

    @NonNull
    @Override
    public HolderData onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View layout = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_kegiatan,viewGroup,false);
        HolderData holder = new HolderData(layout);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final HolderData holderData, int posistion) {
        destiny = new Destiny();
        final DataModel dm = mList.get(posistion);
        Glide.with(ctx)
                .load(destiny.BASE_URL()+dm.getCover_info_publik())
                .into(holderData.Image);
        holderData.card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ctx, DetailInfoPublik.class);
                i.putExtra("JUDUL", dm.getJudul_info_publik());
                i.putExtra("ISI",dm.getIsi_info_publik());
                i.putExtra("TANGGAL",dm.getCreated_at_info_publik());
                i.putExtra("GAMBAR",destiny.BASE_URL()+dm.getCover_info_publik());
                i.putExtra("YOUTUBE",dm.getLink_youtube_info_publik());
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
        LinearLayout card;
        public HolderData(View v){
            super(v);
            Image = v.findViewById(R.id.ivGambar);
            card = v.findViewById(R.id.card_view);
        }
    }
}




