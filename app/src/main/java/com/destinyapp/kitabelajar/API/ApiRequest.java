package com.destinyapp.kitabelajar.API;

import com.destinyapp.kitabelajar.Model.ResponseDestiny;
import com.destinyapp.kitabelajar.Model.ResponseModel;

import java.util.ArrayList;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;

public interface ApiRequest {
    @FormUrlEncoded
    @POST("auth/login")
    Call<ResponseModel> login(@Field("username") String username,
                              @Field("password") String password);

    @Multipart
    @POST("ubahphotoprofil")
    Call<ResponseModel> ChangeFoto(@Header("Authorization") String authHeader,
                                   @Part MultipartBody.Part photo);
    @FormUrlEncoded
    @POST("ubahpassword")
    Call<ResponseModel> UbahPassword(@Header("Authorization") String authHeader,
                                     @Field("passwordNew") String passwordNew,
                                     @Field("passwordConfirm") String passwordConfirm,
                                     @Field("passwordOld") String passwordOld);
    @FormUrlEncoded
    @POST("supray/kitabelajar")
    Call<ResponseDestiny> Checkers(@Header("Authorization") String authHeader,
                                   @Field("supri_key") String supri_key);

    //GET
    @GET("kabarsekolah")
    Call<ResponseModel> KabarSekolah(@Header("Authorization") String authHeader);

    @GET("strukturoganisasi")
    Call<ResponseModel> StrukturSekolah(@Header("Authorization") String authHeader);

    @GET("prestasi")
    Call<ResponseModel> Prestasi(@Header("Authorization") String authHeader);

    @GET("getmapelkelasjadwal")
    Call<ResponseModel> GetMapel(@Header("Authorization") String authHeader,
                                 @Query("tglKelas") String tglKelas);

    @GET("kamis_nyunda")
    Call<ResponseModel> GetKemisNyunda(@Header("Authorization") String authHeader,
                                 @Query("tipe") String tipe);

    @GET("mediainformasi")
    Call<ResponseModel> GetMediaInformasi(@Header("Authorization") String authHeader,
                                       @Query("tipe_media") String tipe_media);

    @GET("khutbah")
    Call<ResponseModel> GetKhutbah(@Header("Authorization") String authHeader);

    @GET("teman")
    Call<ResponseModel> Teman(@Header("Authorization") String authHeader,
                              @Query("idKelas") String idKelas);

    @GET("raport")
    Call<ResponseModel> Raport(@Header("Authorization") String authHeader);

    @GET("mediapembelajaran")
    Call<ResponseModel> MediaPembelajaran(@Header("Authorization") String authHeader);


    @GET("poinsiswa")
    Call<ResponseModel> PointSiswa(@Header("Authorization") String authHeader);

    @GET("agenda_sekolah")
    Call<ResponseModel> AgendaSekolah(@Header("Authorization") String authHeader);

    @GET("tugas")
    Call<ResponseModel> Tugas(@Header("Authorization") String authHeader);

    @GET("gallery")
    Call<ResponseModel> Gallery(@Header("Authorization") String authHeader);

    @GET("gurusekolah")
    Call<ResponseModel> GuruSekolah(@Header("Authorization") String authHeader);

    @GET("profilsekolah")
    Call<ResponseModel> ProfileSekolah(@Header("Authorization") String authHeader);

    @GET("infodisdik")
    Call<ResponseModel> InfoDisdik(@Header("Authorization") String authHeader);

    @GET("sponsor")
    Call<ResponseModel> Sponsor(@Header("Authorization") String authHeader);

    @Multipart
    @POST("izin")
    Call<ResponseModel> Izins(@Header("Authorization") String authHeader,
                             @Part("namaIzin") RequestBody nama_izin,
                             @Part("deskripsiIzin") RequestBody deskripsi_izin,
                             @Part("tanggalMulai") RequestBody tanggalMulai,
                             @Part("tanggalAkhir") RequestBody tanggalAkhir,
                             @Part MultipartBody.Part fileIzin);
    //FAJAR KONTOL
    @FormUrlEncoded
    @POST("info_dinas")
    Call<ResponseModel> InfoDinas(@Field("id_daerah") String id_daerah,
                              @Field("tipe_info") String tipe_info);

//    @FormUrlEncoded
//    @POST("izin")
//    Call<ResponseModel> Izin(@Field("id_siswa") String id_siswa,
//                                  @Field("nama_izin") String nama_izin,
//                                  @Field("deskripsi_izin") String deskripsi_izin,
//                                  @Field("tgl_mulai") String tgl_mulai,
//                                  @Field("tgl_akhir") String tgl_akhir,
//                                  @Field("file_izin") String file_izin);

    @Multipart
    @POST("izin")
    Call<ResponseModel> Izin(@Part("id_siswa") RequestBody id_siswa,
                                @Part("nama_izin") RequestBody nama_izin,
                                @Part("deskripsi_izin") RequestBody deskripsi_izin,
                                @Part("tgl_mulai") RequestBody tgl_mulai,
                                @Part("tgl_akhir") RequestBody tgl_akhir,
                                @Part MultipartBody.Part photo);

    @GET("info_publik")
    Call<ResponseModel> InfoPublik();
}
