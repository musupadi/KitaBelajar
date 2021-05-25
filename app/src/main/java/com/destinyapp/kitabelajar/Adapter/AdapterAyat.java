package com.destinyapp.kitabelajar.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.destinyapp.kitabelajar.Acitvity.menu.JumatNgaji.Doa.AyatActivity;
import com.destinyapp.kitabelajar.Method.Destiny;
import com.destinyapp.kitabelajar.Model.Alquran.Universal.TextModel;
import com.destinyapp.kitabelajar.Model.Surat;
import com.destinyapp.kitabelajar.R;
import com.destinyapp.kitabelajar.SharedPreferance.DB_Helper;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class AdapterAyat extends RecyclerView.Adapter<AdapterAyat.HolderData>  {
    private Context ctx;

    DB_Helper dbHelper;
    Boolean onClick=false;
    RecyclerView recyclerView;
    Destiny destiny;

    //Doa
    int ayat;
    TextModel textAyat;
    TextModel textTranslation;
    public AdapterAyat(Context ctx, int ayat,TextModel textAyat,TextModel textTranslation){
        this.ctx = ctx;
        this.ayat = ayat;
        this.textAyat = textAyat;
        this.textTranslation = textTranslation;
    }

    @NonNull
    @Override
    public HolderData onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View layout = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_ayat,viewGroup,false);
        HolderData holder = new HolderData(layout);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final HolderData holderData, int posistion) {
        destiny = new Destiny();
//        final Surat dm = mList.get(posistion);
        if (posistion+1==1){
            holderData.Nama.setText(textAyat.getOne());
            holderData.Nama2.setText(destiny.SmallDescription(textTranslation.getOne()));
        }else if (posistion+1==2){
            holderData.Nama.setText(textAyat.getTwo());
            holderData.Nama2.setText(destiny.SmallDescription(textTranslation.getTwo()));
        }else if (posistion+1==3){
            holderData.Nama.setText(textAyat.getThree());
            holderData.Nama2.setText(destiny.SmallDescription(textTranslation.getThree()));
        }else if (posistion+1==4){
            holderData.Nama.setText(textAyat.getFour());
            holderData.Nama2.setText(destiny.SmallDescription(textTranslation.getFour()));
        }else if (posistion+1==5){
            holderData.Nama.setText(textAyat.getFive());
            holderData.Nama2.setText(destiny.SmallDescription(textTranslation.getFive()));
        }else if (posistion+1==6){
            holderData.Nama.setText(textAyat.getSix());
            holderData.Nama2.setText(destiny.SmallDescription(textTranslation.getSix()));
        }else if (posistion+1==7){
            holderData.Nama.setText(textAyat.getSeven());
            holderData.Nama2.setText(destiny.SmallDescription(textTranslation.getSeven()));
        }else if (posistion+1==8){
            holderData.Nama.setText(textAyat.getEight());
            holderData.Nama2.setText(destiny.SmallDescription(textTranslation.getEight()));
        }else if (posistion+1==9){
            holderData.Nama.setText(textAyat.getEight());
            holderData.Nama2.setText(destiny.SmallDescription(textTranslation.getEight()));
        }

        holderData.card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ctx, AyatActivity.class);
                i.putExtra("NO", "1");
                ctx.startActivity(i);

            }
        });
    }

    @Override
    public int getItemCount() {
        return ayat;
    }

    class HolderData extends RecyclerView.ViewHolder{ ;
        TextView Nama,Nama2;
        LinearLayout card;
        public HolderData(View v){
            super(v);
            Nama = v.findViewById(R.id.tvNama);
            Nama2 = v.findViewById(R.id.tvNama2);
            card = v.findViewById(R.id.LayoutCardView);
        }
    }
}