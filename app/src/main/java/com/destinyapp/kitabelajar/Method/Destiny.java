package com.destinyapp.kitabelajar.Method;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.util.Base64;
import android.util.Log;
import android.widget.Toast;

import com.destinyapp.kitabelajar.API.ApiRequest;
import com.destinyapp.kitabelajar.API.RetroServer;
import com.destinyapp.kitabelajar.Acitvity.HomeActivity;
import com.destinyapp.kitabelajar.Acitvity.InfoDinasActivity;
import com.destinyapp.kitabelajar.Acitvity.menu.AgendaSekolah.AgendaSekolahActivity;
import com.destinyapp.kitabelajar.Acitvity.menu.BiayaAkademik;
import com.destinyapp.kitabelajar.Acitvity.menu.ERaportActivity;
import com.destinyapp.kitabelajar.Acitvity.menu.EvadirActivity;
import com.destinyapp.kitabelajar.Acitvity.menu.FormulirPPDBActivity;
import com.destinyapp.kitabelajar.Acitvity.menu.GalleryActivity;
import com.destinyapp.kitabelajar.Acitvity.menu.GuruActivity;
import com.destinyapp.kitabelajar.Acitvity.menu.JadwalPelajaranActivity;
import com.destinyapp.kitabelajar.Acitvity.menu.JumatNgaji.JumatNgajiActivity;
import com.destinyapp.kitabelajar.Acitvity.menu.KemisNyunda.KemisNyundaActivity;
import com.destinyapp.kitabelajar.Acitvity.menu.MediaInformasi.MediaInformasiActivity;
import com.destinyapp.kitabelajar.Acitvity.menu.MediaPembelajaran.MediaPembelajaranActivity;
import com.destinyapp.kitabelajar.Acitvity.menu.PembayaranActivity;
import com.destinyapp.kitabelajar.Acitvity.menu.PrestasiActivity;
import com.destinyapp.kitabelajar.Acitvity.menu.ProfileSekolahActivity;
import com.destinyapp.kitabelajar.Acitvity.menu.ROBDanaActivity;
import com.destinyapp.kitabelajar.Acitvity.menu.StrukturOrganisasiActivity;
import com.destinyapp.kitabelajar.Acitvity.menu.TugasActivity;
import com.destinyapp.kitabelajar.Model.ResponseModel;
import com.destinyapp.kitabelajar.SharedPreferance.DB_Helper;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Destiny {
    public String SmallDescription(String description){
        String Des = description;
        if (description.length() >= 100){
            Des = description.substring(0,100)+"...";
        }
        return Des;
    }
    public String AUTH_BASE_64(){
        String username = "destiny_pss_tk";
        String password = "45sq2355sqav139ewxza";

        String base = username+":"+password;

        String authHeader = "Basic "+ Base64.encodeToString(base.getBytes(),Base64.NO_WRAP);
        return authHeader;
    }
    public String GetIDYoutube(String link){
        String replace1 = link.replace("https://www.youtube.com/watch?v=","");
        return replace1;
    }
    public String FajarNangis(String Jessica){
        String replace = Jessica.replace("&#39;","'");
        return replace;
    }
    public static String getThisDayDB(){
        DateFormat dateFormat1 = new SimpleDateFormat("dd");
        DateFormat dateFormat2 = new SimpleDateFormat("MM");
        DateFormat dateFormat3 = new SimpleDateFormat("yyyy");
        Date date = new Date();
        String Day = dateFormat1.format(date);
        String month = dateFormat2.format(date);
        String Year = dateFormat3.format(date);
        String dates = Year+"-"+month+"-"+Day;
        return dates;
    }
    public String FilterTextToJava(String text){
        String replaces = text.replace("</p>\\r\\n<ol>\\r\\n<li>","");
        String replace1 = replaces.replace("<p>","");
        String replace2 = replace1.replace("</p>","");
        String replace3 = replace2.replace("<span style=\"color: #ff6600;\">","");
        String replace4 = replace3.replace("</span>","");
        String replace5 = replace4.replace("<strong>","");
        String replace6 = replace5.replace("</strong>","");
        String replace7 = replace6.replace("<ol>","");
        String replace8 = replace7.replace("</ol>","");
        String replace9 = replace8.replace("<li>","");
        String replace10 = replace9.replace("</li>","");
        String replace11 = replace10.replace("<ul>","");
        String replace12 = replace11.replace("</ul>","");
        String replace13 = replace12.replace("\\n\\n","\\n");
        String replace14 = replace13.replace("<div>","");
        String replace15 = replace14.replace("</div>","");
        String replace16 = replace15.replace("<p>1.","");
        String replace17 = replace16.replace("<p style=\\\"text-align: left;\\\">","");
        String replace18 = replace17.replace("<a href=","");
        return replace18;
    }
    public void AutoLogin(final String username,final String password,final Context ctx){
        final DB_Helper dbHelper = new DB_Helper(ctx);
        ApiRequest api = RetroServer.getClient().create(ApiRequest.class);
        final Call<ResponseModel> login =api.login(username,password);
        login.enqueue(new Callback<ResponseModel>() {
            @Override
            public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {
                try {
                    if (response.body().getStatusCode().equals("000")){
                        dbHelper.Logout();
                        dbHelper.SaveUser(username,password,response.body().getData().get(0).getName(),response.body().getData().get(0).getAccessToken(),response.body().getData().get(0).getAs(),response.body().getData().get(0).getPhoto());
                    }else{
                        Toast.makeText(ctx, response.body().getStatusMessage(), Toast.LENGTH_SHORT).show();
                    }
                }catch (Exception e){
                    Toast.makeText(ctx, "Terjadi Kesalahan "+e.toString(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseModel> call, Throwable t) {
//                Toast.makeText(LoginActivity.this, "Koneksi Gagal", Toast.LENGTH_SHORT).show();
                Toast.makeText(ctx, "Koneksi Gagal", Toast.LENGTH_SHORT).show();
                Log.i("Login Logic : ",t.toString());
            }
        });
    }
    public void Toast(Context context,String message){
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }
    public void ChangeActivity(Context ctx,String Class,String id){
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
            if (id.equals("guest")){
                Intent intent = new Intent(ctx, FormulirPPDBActivity.class);
                ctx.startActivity(intent);
            }else{
                Toast.makeText(ctx, "Harap Logout dahulu dan menggunakan Akun Guest untuk Mendaftar PPDB", Toast.LENGTH_SHORT).show();
            }
        }else if(Class.equals("Struktur Sekolah")){
            Intent intent = new Intent(ctx, StrukturOrganisasiActivity.class);
            ctx.startActivity(intent);
        }else if(Class.equals("Jadwal Pelajaran")){
            if (id.equals("guest")){
                Toast.makeText(ctx, "Mohon Login Untuk Mengakses Menu", Toast.LENGTH_SHORT).show();
            }else{
                Intent intent = new Intent(ctx, JadwalPelajaranActivity.class);
                ctx.startActivity(intent);
            }
        }else if(Class.equals("Evadir")){
            if (id.equals("guest")){
                Toast.makeText(ctx, "Mohon Login Untuk Mengakses Menu", Toast.LENGTH_SHORT).show();
            }else{
                Intent intent = new Intent(ctx, EvadirActivity.class);
                ctx.startActivity(intent);
            }
        }else if(Class.equals("Media Pembelajaran")){
            Intent intent = new Intent(ctx, MediaPembelajaranActivity.class);
            ctx.startActivity(intent);
        }else if(Class.equals("Tugas")){
            if (id.equals("guest")){
                Toast.makeText(ctx, "Mohon Login Untuk Mengakses Menu", Toast.LENGTH_SHORT).show();
            }else{
                Intent intent = new Intent(ctx, TugasActivity.class);
                ctx.startActivity(intent);
            }
        }else if(Class.equals("E Raport")){
            if (id.equals("guest")){
                Toast.makeText(ctx, "Mohon Login Untuk Mengakses Menu", Toast.LENGTH_SHORT).show();
            }else{
                Intent intent = new Intent(ctx, ERaportActivity.class);
                ctx.startActivity(intent);
            }
        }else if(Class.equals("Guru")){
            Intent intent = new Intent(ctx, GuruActivity.class);
            ctx.startActivity(intent);
        }else if(Class.equals("Biaya Akademik")){
            Intent intent = new Intent(ctx, BiayaAkademik.class);
            ctx.startActivity(intent);
        }else if(Class.equals("Pembayaran")){
            if (id.equals("guest")){
                Toast.makeText(ctx, "Mohon Login Untuk Mengakses Menu", Toast.LENGTH_SHORT).show();
            }else{
                Intent intent = new Intent(ctx, PembayaranActivity.class);
                ctx.startActivity(intent);
            }
        }else if(Class.equals("ROB")){
            Intent intent = new Intent(ctx, ROBDanaActivity.class);
            ctx.startActivity(intent);
        }else if(Class.equals("E-Raport")){
            if (id.equals("guest")){
                Toast.makeText(ctx, "Mohon Login Untuk Mengakses Menu", Toast.LENGTH_SHORT).show();
            }else{
                Intent intent = new Intent(ctx, ERaportActivity.class);
                ctx.startActivity(intent);
            }
        }else if(Class.equals("Gallery")){
            Intent intent = new Intent(ctx, GalleryActivity.class);
            ctx.startActivity(intent);
        }else if(Class.equals("Dinas Pendidikan")){
            Intent intent = new Intent(ctx, InfoDinasActivity.class);
            ctx.startActivity(intent);
        }else if(Class.equals("Kemis Nyunda")){
            Intent intent = new Intent(ctx, KemisNyundaActivity.class);
            ctx.startActivity(intent);
        }else if(Class.equals("Jumat Ngaji")){
            Intent intent = new Intent(ctx, JumatNgajiActivity.class);
            ctx.startActivity(intent);
        }else if(Class.equals("Media Informasi")){
            Intent intent = new Intent(ctx, MediaInformasiActivity.class);
            ctx.startActivity(intent);
        }
        
    }
    public String BASE_URL(){
        String BASE_URL = "https://kitabelajar.penaedu.id/";
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
        String month = dates.substring(5,7);
        String day = dates.substring(8,10);

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

    public static String Today(){
        DateFormat dateFormat1 = new SimpleDateFormat("dd");
        DateFormat dateFormat2 = new SimpleDateFormat("MM");
        DateFormat dateFormat3 = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        String dates = dateFormat3.format(date);
        return dates;
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
