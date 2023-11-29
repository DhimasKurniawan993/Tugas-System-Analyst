/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package perpustakaanxyz;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ASUS
 */
public class AnggotaPerpustakaan {
    String nama;
    int idAnggota;
    String alamat;
    List<TransaksiPeminjaman> riwayatPeminjaman = new ArrayList<>();

    public AnggotaPerpustakaan(String nama, int idAnggota, String alamat) {
        this.nama = nama;
        this.idAnggota = idAnggota;
        this.alamat = alamat;
    }
}
