/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package perpustakaanxyz;

import java.util.List;

public class Admin {
    private String username;
    private String password;

    public Admin(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public void tambahAnggota(List<AnggotaPerpustakaan> anggotaList, AnggotaPerpustakaan anggota) {
        anggotaList.add(anggota);
        System.out.println("Anggota berhasil ditambahkan: " + anggota.nama);
    }

    public void tambahBuku(List<Buku> bukuList, Buku buku) {
        bukuList.add(buku);
        System.out.println("Buku berhasil ditambahkan: " + buku.judul);
    }

    public void kirimNotifikasi(AnggotaPerpustakaan anggota, String isiPesan) {
        Notifikasi notifikasi = new Notifikasi(isiPesan, anggota.nama);
        System.out.println("Notifikasi dikirim kepada " + anggota.nama + ": " + isiPesan);
    }

    public boolean isAdmin(String masukanUsername, String masukanPassword) {
        // Membandingkan dengan username dan password yang ada di objek Admin
        return this.username.equals(masukanUsername) && this.password.equals(masukanPassword);
    }

    public void lihatSemuaTransaksi(List<TransaksiPeminjaman> transaksiList) {
        System.out.println("### Daftar Transaksi ###");
        for (TransaksiPeminjaman transaksi : transaksiList) {
            System.out.println("ID Transaksi: " + transaksi.idTransaksi);
            System.out.println("Anggota: " + transaksi.anggota.nama);
            System.out.println("Buku: " + transaksi.buku.judul);
            System.out.println("Tanggal Pinjam: " + transaksi.tanggalPinjam);
            System.out.println("Durasi Peminjaman: " + transaksi.durasi + " hari");
            System.out.println("Status Pengembalian: " + (transaksi.buku.statusKetersediaan ? "Belum Dikembalikan" : "Sudah Dikembalikan"));
            System.out.println("------------------------------");
        }
    }
    public void lihatSemuaAnggota(List<AnggotaPerpustakaan> anggotaList) {
        System.out.println("### Daftar Anggota ###");
        for (int i = 0; i < anggotaList.size(); i++) {
            AnggotaPerpustakaan anggota = anggotaList.get(i);
            System.out.println("No. " + (i + 1) + " | ID Anggota: " + anggota.idAnggota + " | Nama: " + anggota.nama + " | Alamat: " + anggota.alamat);
        }
        System.out.println("------------------------------");
    }
    
    public void lihatSemuaBuku(List<Buku> bukuList) {
        System.out.println("### Daftar Buku ###");
        for (int i = 0; i < bukuList.size(); i++) {
            Buku buku = bukuList.get(i);
            System.out.println("No. " + (i + 1) + " | Judul: " + buku.judul + " | Pengarang: " + buku.pengarang + " | ISBN: " + buku.isbn);
        }
        System.out.println("------------------------------");
    }
    
}
