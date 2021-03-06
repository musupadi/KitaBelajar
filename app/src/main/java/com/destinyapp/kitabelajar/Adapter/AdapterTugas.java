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
import com.destinyapp.kitabelajar.Model.DataModel;
import com.destinyapp.kitabelajar.R;
import com.destinyapp.kitabelajar.SharedPreferance.DB_Helper;

import java.util.List;

public class AdapterTugas extends RecyclerView.Adapter<AdapterTugas.HolderData>  {
    private List<DataModel> mList;
    private Context ctx;

    DB_Helper dbHelper;
    Boolean onClick=false;
    RecyclerView recyclerView;
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
        holderData.Mapel.setText(dm.getId_mapel());
        holderData.Guru.setText(dm.getId_guru());
        holderData.Mulai.setText(destiny.MagicDateChange(dm.getTgl_mulai()));
        holderData.Selesai.setText(destiny.MagicDateChange(dm.getTgl_selesai()));
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    class HolderData extends RecyclerView.ViewHolder{ ;
        TextView Mapel,Guru,Mulai,Selesai;
        LinearLayout card;
        public HolderData(View v){
            super(v);
            Mapel = v.findViewById(R.id.tvNamaMapel);
            Guru = v.findViewById(R.id.tvNamaGuru);
            Mulai = v.findViewById(R.id.tvMulai);
            Selesai = v.findViewById(R.id.tvSelesai);
            card = v.findViewById(R.id.LayoutCardView);
        }
    }
}


