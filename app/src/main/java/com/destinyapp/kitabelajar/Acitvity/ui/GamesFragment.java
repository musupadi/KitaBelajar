package com.destinyapp.kitabelajar.Acitvity.ui;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.destinyapp.kitabelajar.Acitvity.Games.GamesActivity;
import com.destinyapp.kitabelajar.Acitvity.Games.NamaHewan.GameHewanActivity;
import com.destinyapp.kitabelajar.R;


public class GamesFragment extends Fragment {
    LinearLayout games1,games2;
    public GamesFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_games, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        try {
            games1 = view.findViewById(R.id.linearGames1);
            games2 = view.findViewById(R.id.linearGames2);

            games1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(getActivity(), GamesActivity.class);
                    startActivity(intent);
                }
            });
            games2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getActivity(), GameHewanActivity.class);
                    startActivity(intent);
                }
            });
        }catch (Exception e){

        }
    }
}