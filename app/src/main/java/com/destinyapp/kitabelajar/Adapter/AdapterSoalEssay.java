package com.destinyapp.kitabelajar.Adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.destinyapp.kitabelajar.Method.Destiny;
import com.destinyapp.kitabelajar.Model.DataModel;
import com.destinyapp.kitabelajar.Model.Essay;
import com.destinyapp.kitabelajar.Model.Soal;
import com.destinyapp.kitabelajar.R;

import java.util.ArrayList;
import java.util.List;

public class AdapterSoalEssay extends RecyclerView.Adapter<AdapterSoalEssay.HolderData> {
    private Context ctx;
    private List<DataModel> mList;
    Destiny destiny;
    ArrayList<String> JAWABAN = new ArrayList<String>();
    public AdapterSoalEssay(Context ctx, List<DataModel> mList,ArrayList<String> JAWABAN){
        this.ctx = ctx;
        this.mList = mList;
        this.JAWABAN = JAWABAN;
    }

    @NonNull
    @Override
    public HolderData onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View layout = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_soal_essay,viewGroup,false);
        HolderData holder = new HolderData(layout);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final HolderData holderData, final int posistion) {
        destiny = new Destiny();
        final DataModel dm = mList.get(posistion);
        int POSITION = posistion+1;
        JAWABAN.add("");
        if (JAWABAN.size()>mList.size()){
            JAWABAN.remove(posistion);
        }
        if (JAWABAN.get(posistion).equals("")){
            holderData.Jawab.setBackgroundResource(R.drawable.round_blue);
            holderData.Jawab.setText("Kunci Jawaban");
            holderData.JawabanSoal.setText("");
        }
        holderData.Jawab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                JAWABAN.set(posistion,holderData.JawabanSoal.getText().toString());
                holderData.Jawab.setBackgroundResource(R.drawable.round_green);
                holderData.Jawab.setText("Jawaban Terkunci");
            }
        });
        holderData.Soal.loadData(dm.getIsi_soal(),"text/html","UTF-8");
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    class HolderData extends RecyclerView.ViewHolder{
        Button Jawab;
        EditText JawabanSoal;
        WebView Soal;
        public HolderData(View v){
            super(v);
            Soal = v.findViewById(R.id.tvSoal);
            JawabanSoal = v.findViewById(R.id.etJawaban);
            Jawab = v.findViewById(R.id.btnJawab);
        }
    }
}


