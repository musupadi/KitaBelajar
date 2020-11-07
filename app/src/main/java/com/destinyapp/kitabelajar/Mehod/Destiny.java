package com.destinyapp.kitabelajar.Mehod;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;

import com.destinyapp.kitabelajar.Acitvity.HomeActivity;
import com.destinyapp.kitabelajar.Acitvity.menu.AgendaSekolah.AgendaSekolahActivity;
import com.destinyapp.kitabelajar.Acitvity.menu.BiayaAkademik;
import com.destinyapp.kitabelajar.Acitvity.menu.ERaportActivity;
import com.destinyapp.kitabelajar.Acitvity.menu.EvadirActivity;
import com.destinyapp.kitabelajar.Acitvity.menu.FormulirPPDBActivity;
import com.destinyapp.kitabelajar.Acitvity.menu.GuruActivity;
import com.destinyapp.kitabelajar.Acitvity.menu.JadwalPelajaranActivity;
import com.destinyapp.kitabelajar.Acitvity.menu.MediaPembelajaranActivity;
import com.destinyapp.kitabelajar.Acitvity.menu.PembayaranActivity;
import com.destinyapp.kitabelajar.Acitvity.menu.PrestasiActivity;
import com.destinyapp.kitabelajar.Acitvity.menu.ProfileSekolahActivity;
import com.destinyapp.kitabelajar.Acitvity.menu.ROBDanaActivity;
import com.destinyapp.kitabelajar.Acitvity.menu.StrukturOrganisasiActivity;
import com.destinyapp.kitabelajar.Acitvity.menu.TugasActivity;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Destiny {
    public void ChangeActivity(Context ctx,String Class){
        if (Class.equals("Profile Sekolah")){
            Intent intent = new Intent(ctx, ProfileSekolahActivity.class);
            ctx.startActivity(intent);
        }else if(Class.equals("Agenda Sekolah")){
            Intent intent = new Intent(ctx, AgendaSekolahActivity.class);
            ctx.startActivity(intent);
        }else if(Class.equals("Prestasi")){
            Intent intent = new Intent(ctx, PrestasiActivity.class);
            ctx.startActivity(intent);
        }else if(Class.equals("PPDB")){
            Intent intent = new Intent(ctx, FormulirPPDBActivity.class);
            ctx.startActivity(intent);
        }else if(Class.equals("Struktur Sekolah")){
            Intent intent = new Intent(ctx, StrukturOrganisasiActivity.class);
            ctx.startActivity(intent);
        }else if(Class.equals("Jadwal Pelajaran")){
            Intent intent = new Intent(ctx, JadwalPelajaranActivity.class);
            ctx.startActivity(intent);
        }else if(Class.equals("Evadir")){
            Intent intent = new Intent(ctx, EvadirActivity.class);
            ctx.startActivity(intent);
        }else if(Class.equals("Media Pembelajaran")){
            Intent intent = new Intent(ctx, MediaPembelajaranActivity.class);
            ctx.startActivity(intent);
        }else if(Class.equals("Tugas")){
            Intent intent = new Intent(ctx, TugasActivity.class);
            ctx.startActivity(intent);
        }else if(Class.equals("E Raport")){
            Intent intent = new Intent(ctx, ERaportActivity.class);
            ctx.startActivity(intent);
        }else if(Class.equals("Guru")){
            Intent intent = new Intent(ctx, GuruActivity.class);
            ctx.startActivity(intent);
        }else if(Class.equals("Biaya Akademik")){
            Intent intent = new Intent(ctx, BiayaAkademik.class);
            ctx.startActivity(intent);
        }else if(Class.equals("Pembayaran")){
            Intent intent = new Intent(ctx, PembayaranActivity.class);
            ctx.startActivity(intent);
        }else if(Class.equals("ROB")){
            Intent intent = new Intent(ctx, ROBDanaActivity.class);
            ctx.startActivity(intent);
        }
        
    }
    public String BASE_URL(){
        String BASE_URL = "https://jempol.destinyconsultant.tech";
        return BASE_URL;
    }
    public String AUTH(String auth){
        String authHeader = "Bearer "+auth;
        return authHeader;
    }
    public void Back(Context context){
        Intent intent = new Intent(context, HomeActivity.class);
        context.startActivity(intent);
    }
    private void initOPPO(Context ctx) {
        try {

            Intent i = new Intent(Intent.ACTION_MAIN);
            i.setComponent(new ComponentName("com.oppo.safe", "com.oppo.safe.permission.floatwindow.FloatWindowListActivity"));
            ctx.startActivity(i);
        } catch (Exception e) {
            e.printStackTrace();
            try {

                Intent intent = new Intent("action.coloros.safecenter.FloatWindowListActivity");
                intent.setComponent(new ComponentName("com.coloros.safecenter", "com.coloros.safecenter.permission.floatwindow.FloatWindowListActivity"));
                ctx.startActivity(intent);
            } catch (Exception ee) {

                ee.printStackTrace();
                try{

                    Intent i = new Intent("com.coloros.safecenter");
                    i.setComponent(new ComponentName("com.coloros.safecenter", "com.coloros.safecenter.sysfloatwindow.FloatWindowListActivity"));
                    ctx.startActivity(i);
                }catch (Exception e1){

                    e1.printStackTrace();
                }
            }

        }
    }
    private static void autoLaunchVivo(Context context) {
        try {
            Intent intent = new Intent();
            intent.setComponent(new ComponentName("com.iqoo.secure",
                    "com.iqoo.secure.ui.phoneoptimize.AddWhiteListActivity"));
            context.startActivity(intent);
        } catch (Exception e) {
            try {
                Intent intent = new Intent();
                intent.setComponent(new ComponentName("com.vivo.permissionmanager",
                        "com.vivo.permissionmanager.activity.BgStartUpManagerActivity"));
                context.startActivity(intent);
            } catch (Exception ex) {
                try {
                    Intent intent = new Intent();
                    intent.setClassName("com.iqoo.secure",
                            "com.iqoo.secure.ui.phoneoptimize.BgStartUpManager");
                    context.startActivity(intent);
                } catch (Exception exx) {
                    ex.printStackTrace();
                }
            }
        }
    }

    public String getToday(){
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
        String thisDay = dateFormat.format(date);
        String today = dayName(thisDay,"dd/MM/yyyy");
        String HariIni = "Senin";
        if(today.equals("Monday")){
            HariIni = "Senin";
        }else if(today.equals("Tuesday")){
            HariIni = "Selasa";
        }else if(today.equals("Wednesday")){
            HariIni = "Rabu";
        }else if(today.equals("Thursday")){
            HariIni = "Kamis";
        }else if(today.equals("Friday")){
            HariIni = "Jumat";
        }else if(today.equals("Saturday")){
            HariIni = "Sabtu";
        }else if(today.equals("Sunday")){
            HariIni = "Minggu";
        }
        return HariIni;
    }
    public  String DateChanges(String year,String month,String day){
        String MONTH = "Januari";
        if (month.equals("01") || month.equals("1")){
            MONTH = "Januari";
        }else if (month.equals("02") || month.equals("2")){
            MONTH = "Februari";
        }else if (month.equals("03") || month.equals("3")){
            MONTH = "Maret";
        }else if (month.equals("04") || month.equals("4")){
            MONTH = "April";
        }else if (month.equals("05") || month.equals("5")){
            MONTH = "Mei";
        }else if (month.equals("06") || month.equals("6")){
            MONTH = "Juni";
        }else if (month.equals("07") || month.equals("7")){
            MONTH = "Juli";
        }else if (month.equals("08") || month.equals("8")){
            MONTH = "Agustus";
        }else if (month.equals("09") || month.equals("9")){
            MONTH = "September";
        }else if (month.equals("10")){
            MONTH = "Oktober";
        }else if (month.equals("11")){
            MONTH = "November";
        }else if (month.equals("12")){
            MONTH = "Desember";
        }
        String Dates = day+"-"+MONTH+"-"+year;
        return Dates;
    }
    public String MagicDateChange(String dates){
        String result = "";
        String year = dates.substring(0,4);
        String month = dates.substring(5,6);
        String day = dates.substring(7,9);

        String MONTH = "Januari";
        if (month.equals("01") || month.equals("1")){
            MONTH = "Januari";
        }else if (month.equals("02") || month.equals("2")){
            MONTH = "Februari";
        }else if (month.equals("03") || month.equals("3")){
            MONTH = "Maret";
        }else if (month.equals("04") || month.equals("4")){
            MONTH = "April";
        }else if (month.equals("05") || month.equals("5")){
            MONTH = "Mei";
        }else if (month.equals("06") || month.equals("6")){
            MONTH = "Juni";
        }else if (month.equals("07") || month.equals("7")){
            MONTH = "Juli";
        }else if (month.equals("08") || month.equals("8")){
            MONTH = "Agustus";
        }else if (month.equals("09") || month.equals("9")){
            MONTH = "September";
        }else if (month.equals("10")){
            MONTH = "Oktober";
        }else if (month.equals("11")){
            MONTH = "November";
        }else if (month.equals("12")){
            MONTH = "Desember";
        }
        result = day+"-"+MONTH+"-"+year;
        return result;

    }
    public static String thisDay(){
        DateFormat dateFormat1 = new SimpleDateFormat("dd");
        DateFormat dateFormat2 = new SimpleDateFormat("MM");
        DateFormat dateFormat3 = new SimpleDateFormat("yyyy");
        Date date = new Date();
        String Day = dateFormat1.format(date);
        String month = dateFormat2.format(date);
        String Year = dateFormat3.format(date);
        String MONTH = "Januari";
        if (month.equals("01") || month.equals("1")){
            MONTH = "Januari";
        }else if (month.equals("02") || month.equals("2")){
            MONTH = "Februari";
        }else if (month.equals("03") || month.equals("3")){
            MONTH = "Maret";
        }else if (month.equals("04") || month.equals("4")){
            MONTH = "April";
        }else if (month.equals("05") || month.equals("5")){
            MONTH = "Mei";
        }else if (month.equals("06") || month.equals("6")){
            MONTH = "Juni";
        }else if (month.equals("07") || month.equals("7")){
            MONTH = "Juli";
        }else if (month.equals("08") || month.equals("8")){
            MONTH = "Agustus";
        }else if (month.equals("09") || month.equals("9")){
            MONTH = "September";
        }else if (month.equals("10")){
            MONTH = "Oktober";
        }else if (month.equals("11")){
            MONTH = "November";
        }else if (month.equals("12")){
            MONTH = "Desember";
        }
        return Day+"-"+MONTH+"-"+Year;
    }
    public static String dayName(String inputDate, String format){
        Date date = null;
        try {
            date = new SimpleDateFormat(format).parse(inputDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return new SimpleDateFormat("EEEE", Locale.ENGLISH).format(date);
    }
}
