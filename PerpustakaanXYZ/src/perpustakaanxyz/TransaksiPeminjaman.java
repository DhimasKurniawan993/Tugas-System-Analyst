/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package perpustakaanxyz;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ASUS
 */
public class TransaksiPeminjaman {
    int idTransaksi;
    AnggotaPerpustakaan anggota;
    Buku buku;
    LocalDate tanggalPinjam;
    int durasi;

    public TransaksiPeminjaman(int idTransaksi, AnggotaPerpustakaan anggota, Buku buku, LocalDate tanggalPinjam, int durasi) {
        this.idTransaksi = idTransaksi;
        this.anggota = anggota;
        this.buku = buku;
        this.tanggalPinjam = tanggalPinjam;
        this.durasi = durasi;
    }

    // Metode untuk meminjam buku
    public void pinjamBuku() {
        if (buku.statusKetersediaan) {
            System.out.println("Buku " + buku.judul + " berhasil dipinjam oleh " + anggota.nama);
            buku.statusKetersediaan = false;
        } else {
            System.out.println("Maaf, buku " + buku.judul + " sedang tidak tersedia untuk dipinjam.");
        }
    }
    public static List<Buku> cariBuku(List<Buku> bukuList, String keyword) {
        List<Buku> hasilPencarian = new ArrayList<>();
        for (Buku buku : bukuList) {
            if (buku.judul.contains(keyword) || buku.pengarang.contains(keyword) || buku.isbn.contains(keyword)) {
                hasilPencarian.add(buku);
            }
        }
        return hasilPencarian;
    }
}
