package com.destinyapp.kitabelajar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.destinyapp.kitabelajar.ui.AbsenFragment;
import com.destinyapp.kitabelajar.ui.GamesFragment;
import com.destinyapp.kitabelajar.ui.HomeFragment;
import com.destinyapp.kitabelajar.ui.IzinFragment;
import com.destinyapp.kitabelajar.ui.UserFragment;

public class HomeActivity extends AppCompatActivity {
    LinearLayout LHome,LIzin,LAbsen,LGames,LUser;
    TextView THome,TIzin,TAbsen,TGames,TUser;
    ImageView IHome,IIzin,IAbsen,IGames,IUser;
    Fragment fragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        //Bottom Nav
        LHome = findViewById(R.id.linearHome);
        LIzin = findViewById(R.id.linearIzin);
        LAbsen = findViewById(R.id.linearAbsen);
        LGames = findViewById(R.id.linearGames);
        LUser = findViewById(R.id.linearUser);
        THome = findViewById(R.id.tvHome);
        TIzin = findViewById(R.id.tvIzin);
        TAbsen = findViewById(R.id.tvAbsen);
        TGames = findViewById(R.id.tvGames);
        TUser = findViewById(R.id.tvUser);
        IHome = findViewById(R.id.ivHome);
        IIzin = findViewById(R.id.ivIzin);
        IAbsen = findViewById(R.id.ivAbsen);
        IGames = findViewById(R.id.ivGames);
        IUser = findViewById(R.id.ivUser);
        //
        Home();
        LHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Home();
            }
        });
        LIzin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Izin();
            }
        });
        LAbsen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Absen();
            }
        });
        LGames.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Games();
            }
        });
        LUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                User();
            }
        });
    }
    private void Default(){
        IHome.setImageResource(R.drawable.home);
        THome.setTextColor(Color.rgb(255,255,255));
        IIzin.setImageResource(R.drawable.izin);
        TIzin.setTextColor(Color.rgb(255,255,255));
        IAbsen.setImageResource(R.drawable.list_check);
        TAbsen.setTextColor(Color.rgb(255,255,255));
        IGames.setImageResource(R.drawable.games);
        TGames.setTextColor(Color.rgb(255,255,255));
        IUser.setImageResource(R.drawable.user);
        TUser.setTextColor(Color.rgb(255,255,255));
    }
    private void Home(){
        Default();
        IHome.setImageResource(R.drawable.home_active);
        THome.setTextColor(Color.rgb(37,166,161));
        fragment = new HomeFragment();
        ChangeFragment(fragment);
    }
    private void Izin(){
        Default();
        IIzin.setImageResource(R.drawable.izin_active);
        TIzin.setTextColor(Color.rgb(37,166,161));
        fragment = new IzinFragment();
        ChangeFragment(fragment);
    }
    private void Absen(){
        Default();
        IAbsen.setImageResource(R.drawable.list_check_active);
        TAbsen.setTextColor(Color.rgb(37,166,161));
        fragment = new AbsenFragment();
        ChangeFragment(fragment);
    }
    private void Games(){
        Default();
        IGames.setImageResource(R.drawable.games_active);
        TGames.setTextColor(Color.rgb(37,166,161));
        fragment = new GamesFragment();
        ChangeFragment(fragment);
    }
    private void User(){
        Default();
        IUser.setImageResource(R.drawable.user_active);
        TUser.setTextColor(Color.rgb(37,166,161));
        fragment = new UserFragment();
        ChangeFragment(fragment);
    }
    private void ChangeFragment(Fragment fragment){
        if(fragment != null){
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction ft = fragmentManager.beginTransaction();
            ft.replace(R.id.Container,fragment);
            ft.commit();
        }
    }
}