package com.destinyapp.kitabelajar.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.destinyapp.kitabelajar.Method.Destiny;
import com.destinyapp.kitabelajar.Model.Media;
import com.destinyapp.kitabelajar.Model.SubTema;
import com.destinyapp.kitabelajar.R;
import com.destinyapp.kitabelajar.SharedPreferance.DB_Helper;

import java.util.ArrayList;
import java.util.List;

public class AdapterSubTema extends RecyclerView.Adapter<AdapterSubTema.HolderData> {
    private List<Media> mList;
    private Context ctx;

    DB_Helper dbHelper;
    Boolean onClick=false;
    RecyclerView recyclerView;
    Destiny destiny;

//    private List<Media> mItems = new ArrayList<>();
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mManager;
    public AdapterSubTema(Context ctx, List<Media> mList){
        this.ctx = ctx;
        this.mList = mList;
    }

    @NonNull
    @Override
    public HolderData onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View layout = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_submodul,viewGroup,false);
        HolderData holder = new HolderData(layout);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final HolderData holderData, int posistion) {
        destiny = new Destiny();
        final Media dm = mList.get(posistion);
        holderData.Nama.setText(dm.getJudul_media());
        holderData.card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
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
        public HolderData(View v){
            super(v);
            Nama = v.findViewById(R.id.tvNama);
            rv= v.findViewById(R.id.recycler);
            card = v.findViewById(R.id.LayoutCardView);
        }
    }
}

