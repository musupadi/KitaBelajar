package com.destinyapp.kitabelajar.ui;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.destinyapp.kitabelajar.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link IzinFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class IzinFragment extends Fragment {



    public IzinFragment() {
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
        return inflater.inflate(R.layout.fragment_izin, container, false);
    }
}