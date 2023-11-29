/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package perpustakaanxyz;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ASUS
 */
public class AnggotaPerpustakaan {
    private String nama;
    private int idAnggota;
    private String alamat;
    private List<TransaksiPeminjaman> riwayatPeminjaman;

    public AnggotaPerpustakaan(String nama, int idAnggota, String alamat, List<TransaksiPeminjaman> riwayatPeminjaman) {
        this.nama = nama;
        this.idAnggota = idAnggota;
        this.alamat = alamat;
        this.riwayatPeminjaman = riwayatPeminjaman;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getIdAnggota() {
        return idAnggota;
    }

    public void setIdAnggota(int idAnggota) {
        this.idAnggota = idAnggota;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public List<TransaksiPeminjaman> getRiwayatPeminjaman() {
        return riwayatPeminjaman;
    }

    public void setRiwayatPeminjaman(List<TransaksiPeminjaman> riwayatPeminjaman) {
        this.riwayatPeminjaman = riwayatPeminjaman;
    }

    public void tambahTransaksiPeminjaman(TransaksiPeminjaman transaksi) {
        if (riwayatPeminjaman == null) {
            riwayatPeminjaman = new ArrayList<>();
        }
        riwayatPeminjaman.add(transaksi);
    }

    public void tampilkanRiwayatPeminjaman() {
        System.out.println("Riwayat Peminjaman untuk Anggota: " + nama);
        if (riwayatPeminjaman != null) {
            for (TransaksiPeminjaman transaksi : riwayatPeminjaman) {
                System.out.println(transaksi);
            }
        } else {
            System.out.println("Belum ada riwayat peminjaman.");
        }
    }

    @Override
    public String toString() {
        return "AnggotaPerpustakaan{" +
                "nama='" + nama + '\'' +
                ", idAnggota=" + idAnggota +
                ", alamat='" + alamat + '\'' +
                ", riwayatPeminjaman=" + riwayatPeminjaman +
                '}';
    }
}


