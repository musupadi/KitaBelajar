package com.destinyapp.kitabelajar.API;

import com.destinyapp.kitabelajar.Model.DataAbsen;
import com.destinyapp.kitabelajar.Model.DataModel;
import com.destinyapp.kitabelajar.Model.ResponseDestiny;
import com.destinyapp.kitabelajar.Model.ResponseModel;

import java.util.ArrayList;
import java.util.List;

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

    @FormUrlEncoded
    @POST("kelas")
    Call<ResponseModel> GetKelas(@Field("id_sekolah") String id_sekolah);


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
    @POST("kelasmuridabsen")
    Call<ResponseModel> KelasMuridAbsen(@Header("Authorization") String authHeader,
                                        @Field("idkelas") String idkelas,
                                        @Field("tanggalabsen") String tanggalabsen,
                                        @Field("idmapel") String idmapel,
                                        @Field("piket") String piket,
                                        @Field("dataabsen") List<DataAbsen> dataabsen);
    @FormUrlEncoded
    @POST("supray/kitabelajar")
    Call<ResponseDestiny> Checkers(@Header("Authorization") String authHeader,
                                   @Field("supri_key") String supri_key);

    //GET
    @GET("kelasabsen")
    Call<ResponseModel> KelasAbsen(@Header("Authorization") String authHeader);

    @GET("gurumapel")
    Call<ResponseModel> GuruMapelAbsen(@Header("Authorization") String authHeader);

    @GET("kabarsekolah")
    Call<ResponseModel> KabarSekolah(@Header("Authorization") String authHeader);

    @GET("strukturoganisasi")
    Call<ResponseModel> StrukturSekolah(@Header("Authorization") String authHeader);

    @GET("prestasi")
    Call<ResponseModel> Prestasi(@Header("Authorization") String authHeader);

    @GET("getmapelkelasjadwal")
    Call<ResponseModel> GetMapel(@Header("Authorization") String authHeader,
                                 @Query("tglKelas") String tglKelas);

    @GET("sponsorsekolah")
    Call<ResponseModel> SponsorSekolah(@Header("Authorization") String authHeader,
                                 @Query("idsponsor") String idsponsor);

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

    @GET("sekolahguest")
    Call<ResponseModel> SekolahGuest(@Query("lembaga") String lembaga,
                                     @Query("searchbyname") String searchbyname);

    @GET("banner")
    Call<ResponseModel> Banner();

    @Multipart
    @POST("izin")
    Call<ResponseModel> Izins(@Header("Authorization") String authHeader,
                             @Part("namaIzin") RequestBody nama_izin,
                             @Part("deskripsiIzin") RequestBody deskripsi_izin,
                             @Part("tanggalMulai") RequestBody tanggalMulai,
                             @Part("tanggalAkhir") RequestBody tanggalAkhir,
                             @Part MultipartBody.Part fileIzin);

    @Multipart
    @POST("ppdb")
    Call<ResponseModel> PPDB(@Header("Authorization") String authHeader,
                             @Part("nomorujian") RequestBody nomorujian,
                             @Part("nisn") RequestBody nisn,
                             @Part("nik") RequestBody nik,
                             @Part("idsekolah") RequestBody idsekolah,
                             @Part("namalengkapsiswa") RequestBody namalengkapsiswa,
                             @Part("nomortelepon") RequestBody nomortelepon,
                             @Part("jeniskelamin") RequestBody jeniskelamin,
                             @Part("tempatlahir") RequestBody tempatlahir,
                             @Part("tanggallahir") RequestBody tanggallahir,
                             @Part("namaayahkandung") RequestBody namaayahkandung,
                             @Part("namaibukandung") RequestBody namaibukandung,
                             @Part("whatsappwaliortu") RequestBody whatsappwaliortu);

    @Multipart
    @POST("ppdb")
    Call<ResponseModel> PPDB(@Header("Authorization") String authHeader,
                              @Part("nomorujian") RequestBody nama_izin,
                              @Part("nisn") RequestBody deskripsi_izin,
                              @Part("nik") RequestBody tanggalMulai,
                              @Part("idsekolah") RequestBody idsekolah,
                              @Part("namalengkapsiswa") RequestBody namalengkapsiswa,
                              @Part("nomortelepon") RequestBody nomortelepon,
                              @Part("jeniskelamin") RequestBody jeniskelamin,
                              @Part("tempatlahir") RequestBody tempatlahir,
                              @Part("tanggallahir") RequestBody tanggallahir,
                              @Part("namaayahkandung") RequestBody namaayahkandung,
                              @Part("namaibukandung") RequestBody namaibukandung,
                              @Part("whatsappwaliortu") RequestBody whatsappwaliortu,
                              @Part MultipartBody.Part Foto1);

    @Multipart
    @POST("ppdb")
    Call<ResponseModel> PPDB(@Header("Authorization") String authHeader,
                             @Part("nomorujian") RequestBody nama_izin,
                             @Part("nisn") RequestBody deskripsi_izin,
                             @Part("nik") RequestBody tanggalMulai,
                             @Part("idsekolah") RequestBody idsekolah,
                             @Part("namalengkapsiswa") RequestBody namalengkapsiswa,
                             @Part("nomortelepon") RequestBody nomortelepon,
                             @Part("jeniskelamin") RequestBody jeniskelamin,
                             @Part("tempatlahir") RequestBody tempatlahir,
                             @Part("tanggallahir") RequestBody tanggallahir,
                             @Part("namaayahkandung") RequestBody namaayahkandung,
                             @Part("namaibukandung") RequestBody namaibukandung,
                             @Part("whatsappwaliortu") RequestBody whatsappwaliortu,
                             @Part MultipartBody.Part Foto1,
                             @Part MultipartBody.Part foto2);

    @Multipart
    @POST("ppdb")
    Call<ResponseModel> PPDB(@Header("Authorization") String authHeader,
                             @Part("nomorujian") RequestBody nama_izin,
                             @Part("nisn") RequestBody deskripsi_izin,
                             @Part("nik") RequestBody tanggalMulai,
                             @Part("idsekolah") RequestBody idsekolah,
                             @Part("namalengkapsiswa") RequestBody namalengkapsiswa,
                             @Part("nomortelepon") RequestBody nomortelepon,
                             @Part("jeniskelamin") RequestBody jeniskelamin,
                             @Part("tempatlahir") RequestBody tempatlahir,
                             @Part("tanggallahir") RequestBody tanggallahir,
                             @Part("namaayahkandung") RequestBody namaayahkandung,
                             @Part("namaibukandung") RequestBody namaibukandung,
                             @Part("whatsappwaliortu") RequestBody whatsappwaliortu,
                             @Part MultipartBody.Part Foto1,
                             @Part MultipartBody.Part foto2,
                             @Part MultipartBody.Part Foto3);

    @Multipart
    @POST("ppdb")
    Call<ResponseModel> PPDB(@Header("Authorization") String authHeader,
                             @Part("nomorujian") RequestBody nama_izin,
                             @Part("nisn") RequestBody deskripsi_izin,
                             @Part("nik") RequestBody tanggalMulai,
                             @Part("idsekolah") RequestBody idsekolah,
                             @Part("namalengkapsiswa") RequestBody namalengkapsiswa,
                             @Part("nomortelepon") RequestBody nomortelepon,
                             @Part("jeniskelamin") RequestBody jeniskelamin,
                             @Part("tempatlahir") RequestBody tempatlahir,
                             @Part("tanggallahir") RequestBody tanggallahir,
                             @Part("namaayahkandung") RequestBody namaayahkandung,
                             @Part("namaibukandung") RequestBody namaibukandung,
                             @Part("whatsappwaliortu") RequestBody whatsappwaliortu,
                             @Part MultipartBody.Part Foto1,
                             @Part MultipartBody.Part foto2,
                             @Part MultipartBody.Part Foto3,
                             @Part MultipartBody.Part Foto4);

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
