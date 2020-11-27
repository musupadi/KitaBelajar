package com.destinyapp.kitabelajar.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DataModel {
    @SerializedName("accessToken")
    @Expose
    public String accessToken;

    @SerializedName("name")
    @Expose
    public String name;
    
    @SerializedName("usernameUser")
    @Expose
    public String usernameUser;

    @SerializedName("as")
    @Expose
    public String as;

    @SerializedName("photo")
    @Expose
    public String photo;

    //Kabar Sekolah
    @SerializedName("id_kabar_sekolah")
    @Expose
    public String id_kabar_sekolah;

    @SerializedName("id_sekolah")
    @Expose
    public String id_sekolah;

    @SerializedName("judul_kabar")
    @Expose
    public String judul_kabar;

    @SerializedName("cover_kabar")
    @Expose
    public String cover_kabar;

    @SerializedName("isi_kabar")
    @Expose
    public String isi_kabar;

    @SerializedName("status_kabar")
    @Expose
    public String status_kabar;

    @SerializedName("created_at_kabar")
    @Expose
    public String created_at_kabar;

    @SerializedName("link_youtube_kabar")
    @Expose
    public String link_youtube_kabar;


    //Struktur Organisasi
    @SerializedName("id_struktur_org")
    @Expose
    public String id_struktur_org;

    @SerializedName("nama_guru")
    @Expose
    public String nama_guru;

    @SerializedName("jabatan")
    @Expose
    public String jabatan;

    @SerializedName("file_foto_struktur")
    @Expose
    public String file_foto_struktur;

    @SerializedName("sort_num")
    @Expose
    public String sort_num;

    @SerializedName("created_at")
    @Expose
    public String created_at;

    //Prestasi
    @SerializedName("id_prestasi")
    @Expose
    public String id_prestasi;

    @SerializedName("judul_prestasi")
    @Expose
    public String judul_prestasi;

    @SerializedName("deskripsi_prestasi")
    @Expose
    public String deskripsi_prestasi;

    @SerializedName("tgl_prestasi")
    @Expose
    public String tgl_prestasi;

    @SerializedName("foto_prestasi")
    @Expose
    public String foto_prestasi;

    @SerializedName("created_at_prestasi")
    @Expose
    public String created_at_prestasi;

    //Jadwal Mata Pelajaran
    @SerializedName("id_mapel_kelas_jadwal")
    @Expose
    public String id_mapel_kelas_jadwal;

    @SerializedName("id_mapel_kelas")
    @Expose
    public String id_mapel_kelas;

    @SerializedName("id_mapel")
    @Expose
    public String id_mapel;

    @SerializedName("id_guru")
    @Expose
    public String id_guru;

    @SerializedName("jam_mulai")
    @Expose
    public String jam_mulai;

    @SerializedName("jam_selesai")
    @Expose
    public String jam_selesai;

    @SerializedName("id_kelas")
    @Expose
    public String id_kelas;

    @SerializedName("tgl_kelas")
    @Expose
    public String tgl_kelas;

    @SerializedName("nama_hari")
    @Expose
    public String nama_hari;

    @SerializedName("tgl_tambah_mapel_kelas")
    @Expose
    public String tgl_tambah_mapel_kelas;

    @SerializedName("nama_mapel")
    @Expose
    public String nama_mapel;

    @SerializedName("kode_mapel")
    @Expose
    public String kode_mapel;

    @SerializedName("tgl_tambah_mapel")
    @Expose
    public String tgl_tambah_mapel;

    @SerializedName("created_at_mapel")
    @Expose
    public String created_at_mapel;

    //E-Raport
    @SerializedName("id_raport_siswa")
    @Expose
    public String id_raport_siswa;

    @SerializedName("id_siswa")
    @Expose
    public String id_siswa;

    @SerializedName("nama_raport")
    @Expose
    public String nama_raport;

    @SerializedName("link_file_raport")
    @Expose
    public String link_file_raport;

    @SerializedName("tgl_raport_upload")
    @Expose
    public String tgl_raport_upload;

    //Poin
    @SerializedName("poin")
    @Expose
    public String poin;

    //Poin
    @SerializedName("nama_kelas")
    @Expose
    public String nama_kelas;

    @SerializedName("nama_siswa")
    @Expose
    public String nama_siswa;

    //Agenda
    @SerializedName("id_agenda_sekolah")
    @Expose
    public String id_agenda_sekolah;

    @SerializedName("judul_agenda")
    @Expose
    public String judul_agenda;

    @SerializedName("cover_agenda")
    @Expose
    public String cover_agenda;

    @SerializedName("isi_agenda")
    @Expose
    public String isi_agenda;

    @SerializedName("status_agenda")
    @Expose
    public String status_agenda;

    @SerializedName("created_at_agenda")
    @Expose
    public String created_at_agenda;

    //Tugas
    @SerializedName("id_tugas")
    @Expose
    public String id_tugas;

    @SerializedName("isi_tugas")
    @Expose
    public String isi_tugas;

    @SerializedName("tgl_mulai")
    @Expose
    public String tgl_mulai;

    @SerializedName("tgl_selesai")
    @Expose
    public String tgl_selesai;

    @SerializedName("tugas_created_at")
    @Expose
    public String tugas_created_at;

    //Gallery
    @SerializedName("id_gallery")
    @Expose
    public String id_gallery;

    @SerializedName("link_file_foto")
    @Expose
    public String link_file_foto;

    //Guru
    @SerializedName("foto_guru")
    @Expose
    public String foto_guru;

    @SerializedName("nip_guru")
    @Expose
    public String nip_guru;

    //Profile
    //Profile Sekolah
    @SerializedName("nama_sekolah")
    @Expose
    public String nama_sekolah;

    @SerializedName("alamat_sekolah")
    @Expose
    public String alamat_sekolah;

    @SerializedName("akreditasi_sekolah")
    @Expose
    public String akreditasi_sekolah;

    @SerializedName("npsn")
    @Expose
    public String npsn;

    @SerializedName("no_izin_sekolah")
    @Expose
    public String no_izin_sekolah;

    @SerializedName("kepala_sekolah")
    @Expose
    public String kepala_sekolah;

    @SerializedName("nama_yayasan")
    @Expose
    public String nama_yayasan;

    @SerializedName("ketua_yayasan")
    @Expose
    public String ketua_yayasan;

    @SerializedName("logo_sekolah")
    @Expose
    public String logo_sekolah;

    //GETTER SETTER
    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getUsernameUser() {
        return usernameUser;
    }

    public void setUsernameUser(String usernameUser) {
        this.usernameUser = usernameUser;
    }

    public String getAs() {
        return as;
    }

    public void setAs(String as) {
        this.as = as;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getId_kabar_sekolah() {
        return id_kabar_sekolah;
    }

    public void setId_kabar_sekolah(String id_kabar_sekolah) {
        this.id_kabar_sekolah = id_kabar_sekolah;
    }

    public String getId_sekolah() {
        return id_sekolah;
    }

    public void setId_sekolah(String id_sekolah) {
        this.id_sekolah = id_sekolah;
    }

    public String getCover_kabar() {
        return cover_kabar;
    }

    public void setCover_kabar(String cover_kabar) {
        this.cover_kabar = cover_kabar;
    }

    public String getIsi_kabar() {
        return isi_kabar;
    }

    public void setIsi_kabar(String isi_kabar) {
        this.isi_kabar = isi_kabar;
    }

    public String getStatus_kabar() {
        return status_kabar;
    }

    public void setStatus_kabar(String status_kabar) {
        this.status_kabar = status_kabar;
    }

    public String getCreated_at_kabar() {
        return created_at_kabar;
    }

    public void setCreated_at_kabar(String created_at_kabar) {
        this.created_at_kabar = created_at_kabar;
    }

    public String getId_struktur_org() {
        return id_struktur_org;
    }

    public void setId_struktur_org(String id_struktur_org) {
        this.id_struktur_org = id_struktur_org;
    }

    public String getNama_guru() {
        return nama_guru;
    }

    public void setNama_guru(String nama_guru) {
        this.nama_guru = nama_guru;
    }

    public String getJabatan() {
        return jabatan;
    }

    public void setJabatan(String jabatan) {
        this.jabatan = jabatan;
    }

    public String getFile_foto_struktur() {
        return file_foto_struktur;
    }

    public void setFile_foto_struktur(String file_foto_struktur) {
        this.file_foto_struktur = file_foto_struktur;
    }

    public String getSort_num() {
        return sort_num;
    }

    public void setSort_num(String sort_num) {
        this.sort_num = sort_num;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getId_prestasi() {
        return id_prestasi;
    }

    public void setId_prestasi(String id_prestasi) {
        this.id_prestasi = id_prestasi;
    }

    public String getJudul_prestasi() {
        return judul_prestasi;
    }

    public void setJudul_prestasi(String judul_prestasi) {
        this.judul_prestasi = judul_prestasi;
    }

    public String getDeskripsi_prestasi() {
        return deskripsi_prestasi;
    }

    public void setDeskripsi_prestasi(String deskripsi_prestasi) {
        this.deskripsi_prestasi = deskripsi_prestasi;
    }

    public String getTgl_prestasi() {
        return tgl_prestasi;
    }

    public void setTgl_prestasi(String tgl_prestasi) {
        this.tgl_prestasi = tgl_prestasi;
    }

    public String getFoto_prestasi() {
        return foto_prestasi;
    }

    public void setFoto_prestasi(String foto_prestasi) {
        this.foto_prestasi = foto_prestasi;
    }

    public String getCreated_at_prestasi() {
        return created_at_prestasi;
    }

    public void setCreated_at_prestasi(String created_at_prestasi) {
        this.created_at_prestasi = created_at_prestasi;
    }

    public String getJudul_kabar() {
        return judul_kabar;
    }

    public void setJudul_kabar(String judul_kabar) {
        this.judul_kabar = judul_kabar;
    }

    public String getId_mapel_kelas_jadwal() {
        return id_mapel_kelas_jadwal;
    }

    public void setId_mapel_kelas_jadwal(String id_mapel_kelas_jadwal) {
        this.id_mapel_kelas_jadwal = id_mapel_kelas_jadwal;
    }

    public String getId_mapel_kelas() {
        return id_mapel_kelas;
    }

    public void setId_mapel_kelas(String id_mapel_kelas) {
        this.id_mapel_kelas = id_mapel_kelas;
    }

    public String getId_mapel() {
        return id_mapel;
    }

    public void setId_mapel(String id_mapel) {
        this.id_mapel = id_mapel;
    }

    public String getId_guru() {
        return id_guru;
    }

    public void setId_guru(String id_guru) {
        this.id_guru = id_guru;
    }

    public String getJam_mulai() {
        return jam_mulai;
    }

    public void setJam_mulai(String jam_mulai) {
        this.jam_mulai = jam_mulai;
    }

    public String getJam_selesai() {
        return jam_selesai;
    }

    public void setJam_selesai(String jam_selesai) {
        this.jam_selesai = jam_selesai;
    }

    public String getId_kelas() {
        return id_kelas;
    }

    public void setId_kelas(String id_kelas) {
        this.id_kelas = id_kelas;
    }

    public String getTgl_kelas() {
        return tgl_kelas;
    }

    public void setTgl_kelas(String tgl_kelas) {
        this.tgl_kelas = tgl_kelas;
    }

    public String getNama_hari() {
        return nama_hari;
    }

    public void setNama_hari(String nama_hari) {
        this.nama_hari = nama_hari;
    }

    public String getTgl_tambah_mapel_kelas() {
        return tgl_tambah_mapel_kelas;
    }

    public void setTgl_tambah_mapel_kelas(String tgl_tambah_mapel_kelas) {
        this.tgl_tambah_mapel_kelas = tgl_tambah_mapel_kelas;
    }

    public String getNama_mapel() {
        return nama_mapel;
    }

    public void setNama_mapel(String nama_mapel) {
        this.nama_mapel = nama_mapel;
    }

    public String getKode_mapel() {
        return kode_mapel;
    }

    public void setKode_mapel(String kode_mapel) {
        this.kode_mapel = kode_mapel;
    }

    public String getTgl_tambah_mapel() {
        return tgl_tambah_mapel;
    }

    public void setTgl_tambah_mapel(String tgl_tambah_mapel) {
        this.tgl_tambah_mapel = tgl_tambah_mapel;
    }

    public String getCreated_at_mapel() {
        return created_at_mapel;
    }

    public void setCreated_at_mapel(String created_at_mapel) {
        this.created_at_mapel = created_at_mapel;
    }

    public String getId_raport_siswa() {
        return id_raport_siswa;
    }

    public void setId_raport_siswa(String id_raport_siswa) {
        this.id_raport_siswa = id_raport_siswa;
    }

    public String getId_siswa() {
        return id_siswa;
    }

    public void setId_siswa(String id_siswa) {
        this.id_siswa = id_siswa;
    }

    public String getNama_raport() {
        return nama_raport;
    }

    public void setNama_raport(String nama_raport) {
        this.nama_raport = nama_raport;
    }

    public String getLink_file_raport() {
        return link_file_raport;
    }

    public void setLink_file_raport(String link_file_raport) {
        this.link_file_raport = link_file_raport;
    }

    public String getTgl_raport_upload() {
        return tgl_raport_upload;
    }

    public void setTgl_raport_upload(String tgl_raport_upload) {
        this.tgl_raport_upload = tgl_raport_upload;
    }

    public String getPoin() {
        return poin;
    }

    public void setPoin(String poin) {
        this.poin = poin;
    }

    public String getNama_kelas() {
        return nama_kelas;
    }

    public void setNama_kelas(String nama_kelas) {
        this.nama_kelas = nama_kelas;
    }

    public String getNama_siswa() {
        return nama_siswa;
    }

    public void setNama_siswa(String nama_siswa) {
        this.nama_siswa = nama_siswa;
    }

    public String getId_agenda_sekolah() {
        return id_agenda_sekolah;
    }

    public void setId_agenda_sekolah(String id_agenda_sekolah) {
        this.id_agenda_sekolah = id_agenda_sekolah;
    }

    public String getJudul_agenda() {
        return judul_agenda;
    }

    public void setJudul_agenda(String judul_agenda) {
        this.judul_agenda = judul_agenda;
    }

    public String getCover_agenda() {
        return cover_agenda;
    }

    public void setCover_agenda(String cover_agenda) {
        this.cover_agenda = cover_agenda;
    }

    public String getIsi_agenda() {
        return isi_agenda;
    }

    public void setIsi_agenda(String isi_agenda) {
        this.isi_agenda = isi_agenda;
    }

    public String getStatus_agenda() {
        return status_agenda;
    }

    public void setStatus_agenda(String status_agenda) {
        this.status_agenda = status_agenda;
    }

    public String getCreated_at_agenda() {
        return created_at_agenda;
    }

    public void setCreated_at_agenda(String created_at_agenda) {
        this.created_at_agenda = created_at_agenda;
    }

    public String getId_tugas() {
        return id_tugas;
    }

    public void setId_tugas(String id_tugas) {
        this.id_tugas = id_tugas;
    }

    public String getIsi_tugas() {
        return isi_tugas;
    }

    public void setIsi_tugas(String isi_tugas) {
        this.isi_tugas = isi_tugas;
    }

    public String getTgl_mulai() {
        return tgl_mulai;
    }

    public void setTgl_mulai(String tgl_mulai) {
        this.tgl_mulai = tgl_mulai;
    }

    public String getTgl_selesai() {
        return tgl_selesai;
    }

    public void setTgl_selesai(String tgl_selesai) {
        this.tgl_selesai = tgl_selesai;
    }

    public String getTugas_created_at() {
        return tugas_created_at;
    }

    public void setTugas_created_at(String tugas_created_at) {
        this.tugas_created_at = tugas_created_at;
    }

    public String getId_gallery() {
        return id_gallery;
    }

    public void setId_gallery(String id_gallery) {
        this.id_gallery = id_gallery;
    }

    public String getLink_file_foto() {
        return link_file_foto;
    }

    public void setLink_file_foto(String link_file_foto) {
        this.link_file_foto = link_file_foto;
    }

    public String getFoto_guru() {
        return foto_guru;
    }

    public void setFoto_guru(String foto_guru) {
        this.foto_guru = foto_guru;
    }

    public String getNip_guru() {
        return nip_guru;
    }

    public void setNip_guru(String nip_guru) {
        this.nip_guru = nip_guru;
    }

    public String getNama_sekolah() {
        return nama_sekolah;
    }

    public void setNama_sekolah(String nama_sekolah) {
        this.nama_sekolah = nama_sekolah;
    }

    public String getAlamat_sekolah() {
        return alamat_sekolah;
    }

    public void setAlamat_sekolah(String alamat_sekolah) {
        this.alamat_sekolah = alamat_sekolah;
    }

    public String getAkreditasi_sekolah() {
        return akreditasi_sekolah;
    }

    public void setAkreditasi_sekolah(String akreditasi_sekolah) {
        this.akreditasi_sekolah = akreditasi_sekolah;
    }

    public String getNpsn() {
        return npsn;
    }

    public void setNpsn(String npsn) {
        this.npsn = npsn;
    }

    public String getNo_izin_sekolah() {
        return no_izin_sekolah;
    }

    public void setNo_izin_sekolah(String no_izin_sekolah) {
        this.no_izin_sekolah = no_izin_sekolah;
    }

    public String getKepala_sekolah() {
        return kepala_sekolah;
    }

    public void setKepala_sekolah(String kepala_sekolah) {
        this.kepala_sekolah = kepala_sekolah;
    }

    public String getNama_yayasan() {
        return nama_yayasan;
    }

    public void setNama_yayasan(String nama_yayasan) {
        this.nama_yayasan = nama_yayasan;
    }

    public String getKetua_yayasan() {
        return ketua_yayasan;
    }

    public void setKetua_yayasan(String ketua_yayasan) {
        this.ketua_yayasan = ketua_yayasan;
    }

    public String getLogo_sekolah() {
        return logo_sekolah;
    }

    public void setLogo_sekolah(String logo_sekolah) {
        this.logo_sekolah = logo_sekolah;
    }

    public String getLink_youtube_kabar() {
        return link_youtube_kabar;
    }

    public void setLink_youtube_kabar(String link_youtube_kabar) {
        this.link_youtube_kabar = link_youtube_kabar;
    }
}
