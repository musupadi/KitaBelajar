package com.destinyapp.kitabelajar.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.destinyapp.kitabelajar.Method.Destiny;
import com.destinyapp.kitabelajar.Model.Media;
import com.destinyapp.kitabelajar.Model.SubTema;
import com.destinyapp.kitabelajar.R;
import com.destinyapp.kitabelajar.SharedPreferance.DB_Helper;

import java.util.ArrayList;
import java.util.List;

public class AdapterTema extends RecyclerView.Adapter<AdapterTema.HolderData> {
    private List<SubTema> mList;
    private Context ctx;

    DB_Helper dbHelper;
    Boolean onClick=true;
    RecyclerView recyclerView;
    Destiny destiny;

    private List<Media> mItems = new ArrayList<>();
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mManager;
    public AdapterTema(Context ctx, List<SubTema> mList){
        this.ctx = ctx;
        this.mList = mList;
    }

    @NonNull
    @Override
    public HolderData onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View layout = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_media_pembelajaran,viewGroup,false);
        HolderData holder = new HolderData(layout);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final HolderData holderData, int posistion) {
        destiny = new Destiny();
        final SubTema dm = mList.get(posistion);
        mManager = new GridLayoutManager(ctx,1);
        holderData.rv.setLayoutManager(mManager);
        holderData.Nama.setText(dm.getNama_subtema());
        holderData.card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (onClick){
                    onClick=false;
                    holderData.rv.setVisibility(View.VISIBLE);
                    holderData.img.setImageResource(R.drawable.ic_baseline_keyboard_arrow_up_24);
                }else{
                    onClick=true;
                    holderData.rv.setVisibility(View.GONE);
                    holderData.img.setImageResource(R.drawable.ic_baseline_keyboard_arrow_down_24);
                }
            }
        });
        if (dm.getMedia().size()>0){
            mItems = dm.getMedia();
//            Toast.makeText(ctx, dm.getMedia().get(0).getJudul_media(), Toast.LENGTH_SHORT).show();
            mAdapter = new AdapterSubTema(ctx,mItems);
            holderData.rv.setAdapter(mAdapter);
            mAdapter.notifyDataSetChanged();
        }
//        holderData.Jabatan.setText(dm.getJabatan());
//        Glide.with(ctx)
//                .load(destiny.BASE_URL()+dm.getFile_foto_struktur())
//                .into(holderData.Image);
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    class HolderData extends RecyclerView.ViewHolder{
        TextView Nama;
        RecyclerView rv;
        LinearLayout card;
        ImageView img;
        public HolderData(View v){
            super(v);
            Nama = v.findViewById(R.id.tvNama);
            rv= v.findViewById(R.id.recycler);
            img = v.findViewById(R.id.ivImage);
            card = v.findViewById(R.id.LayoutCardView);
        }
    }
}
