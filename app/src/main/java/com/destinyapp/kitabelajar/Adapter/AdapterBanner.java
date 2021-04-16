package com.destinyapp.kitabelajar.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.bumptech.glide.Glide;
import com.destinyapp.kitabelajar.Method.Destiny;
import com.destinyapp.kitabelajar.Model.DataModel;
import com.destinyapp.kitabelajar.R;

import java.util.List;

public class AdapterBanner extends PagerAdapter {
    Context context;
    LayoutInflater layoutInflater;
    private List<DataModel> mList;
    Destiny destiny;

    public AdapterBanner(Context context, List<DataModel> mList){
        this.context = context;
        this.mList = mList;
    }


    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view == (LinearLayout) o;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, final int position) {
        layoutInflater = (LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.list_banner,container,false);
        final DataModel dm = mList.get(position);
        destiny = new Destiny();
        ImageView Image = view.findViewById(R.id.ivGambar);
        if (dm.getFile_foto_banner().equals("") || dm.getFile_foto_banner().isEmpty() || dm.getFile_foto_banner().equals("/files/")){
            Image.setImageResource(R.drawable.kita_belajar);
        }else{
            Glide.with(context)
                    .load(destiny.BASE_URL()+dm.getFile_foto_banner())
                    .into(Image);
        }
//        TextView textGambar = view.findViewById(R.id.tvTextImage);
//        TextView text = view.findViewById(R.id.tvText);
//        ivGambar.setImageResource(slide_image[position]);
//        text.setText(slide_nama[position]);
//        if (position>0){
//            textGambar.setVisibility(View.GONE);
//        }
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((LinearLayout)object);
    }
}

