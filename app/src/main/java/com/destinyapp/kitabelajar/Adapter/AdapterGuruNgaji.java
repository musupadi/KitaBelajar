package com.destinyapp.kitabelajar.Adapter;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.destinyapp.kitabelajar.API.ApiRequest;
import com.destinyapp.kitabelajar.API.RetroServer;
import com.destinyapp.kitabelajar.Acitvity.HomeActivity;
import com.destinyapp.kitabelajar.Acitvity.menu.AgendaSekolah.DetailAgendaSekolahActivity;
import com.destinyapp.kitabelajar.Acitvity.menu.JumatNgaji.GuruNgaji.DetailGuruNgajiActivity;
import com.destinyapp.kitabelajar.Method.Destiny;
import com.destinyapp.kitabelajar.Model.DataModel;
import com.destinyapp.kitabelajar.Model.ResponseModel;
import com.destinyapp.kitabelajar.R;
import com.destinyapp.kitabelajar.SharedPreferance.DB_Helper;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AdapterGuruNgaji extends RecyclerView.Adapter<AdapterGuruNgaji.HolderData> {
    private List<DataModel> mList;
    private Context ctx;

    DB_Helper dbHelper;
    Boolean onClick=false;
    RecyclerView recyclerView;
    Destiny destiny;
    public AdapterGuruNgaji(Context ctx, List<DataModel> mList){
        this.ctx = ctx;
        this.mList = mList;
    }

    @NonNull
    @Override
    public HolderData onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View layout = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_sekolah,viewGroup,false);
        HolderData holder = new HolderData(layout);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final HolderData holderData, int posistion) {
        destiny = new Destiny();
        final DataModel dm = mList.get(posistion);
        holderData.Judul.setText(dm.getNama_guru_ngaji());
        holderData.Alamat.setText(dm.getAlamat_guru_ngaji());
        Glide.with(ctx)
                .load(destiny.BASE_URL()+dm.getFoto_guru_ngaji())
                .into(holderData.Image);
        holderData.card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ctx, DetailGuruNgajiActivity.class);
                i.putExtra("NAMA", dm.getNama_guru_ngaji());
                i.putExtra("ALAMAT",dm.getAlamat_guru_ngaji());
                i.putExtra("LAT",dm.getLatitude_guru_ngaji());
                i.putExtra("LONG", dm.getLongitude_guru_ngaji());
                i.putExtra("FOTO", destiny.BASE_URL()+dm.getFoto_guru_ngaji());
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
        TextView Judul,Alamat;
        CardView card;
        public HolderData(View v){
            super(v);
            Image = v.findViewById(R.id.ivLogo);
            Judul = v.findViewById(R.id.tvNamaSekolah);
            Alamat = v.findViewById(R.id.tvAlamat);
            card = v.findViewById(R.id.card);
        }
    }

}

