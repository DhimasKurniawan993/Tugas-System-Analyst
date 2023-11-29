/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package perpustakaanxyz;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 *
 * @author ASUS
 */
public class TransaksiPengembalian {
    int idTransaksi;
    LocalDate tanggalKembali;

    public TransaksiPengembalian(int idTransaksi, LocalDate tanggalKembali) {
        this.idTransaksi = idTransaksi;
        this.tanggalKembali = tanggalKembali;
    }

    public void kembalikanBuku(TransaksiPeminjaman transaksiPeminjaman) {
        if (transaksiPeminjaman != null) {
            long durasiPeminjaman = transaksiPeminjaman.durasi;
            LocalDate tanggalPeminjaman = transaksiPeminjaman.tanggalPinjam;

            long selisihHari = ChronoUnit.DAYS.between(tanggalPeminjaman, tanggalKembali);
            
            if (selisihHari <= durasiPeminjaman) {
                System.out.println("Buku berhasil dikembalikan.");
            } else {
                // Hitung denda (Rp. 500 per hari)
                long denda = (selisihHari - durasiPeminjaman) * 500;
                System.out.println("Buku berhasil dikembalikan dengan denda sebesar Rp. " + denda);
            }
        } else {
            System.out.println("Transaksi tidak ditemukan.");
        }
    }
}
