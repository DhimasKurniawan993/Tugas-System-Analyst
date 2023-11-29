/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package perpustakaanxyz;

import java.util.ArrayList;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class PerpustakaanXYZ {

    public static void main(String[] args) {
        List<AnggotaPerpustakaan> anggotaList = new ArrayList<>();
        List<Buku> bukuList = new ArrayList<>();
        List<TransaksiPeminjaman> transaksiList = new ArrayList<>();
        
        AnggotaPerpustakaan anggota1 = new AnggotaPerpustakaan("John Doe", 101, "Jl. ABC No. 123");
        AnggotaPerpustakaan anggota2 = new AnggotaPerpustakaan("Jane Smith", 102, "Jl. XYZ No. 456");

        anggotaList.add(anggota1);
        anggotaList.add(anggota2);
        
        Buku buku1 = new Buku("Harry Potter", "J.K. Rowling", "123456", true);
        Buku buku2 = new Buku("Sherlock Holmes", "Arthur Conan Doyle", "789012", true);

        bukuList.add(buku1);
        bukuList.add(buku2);


        Admin admin = new Admin("admin", "adminpass");

        Scanner input = new Scanner(System.in);
        int menu = 1;

        while (true) {
            if (menu == 1) {
                System.out.println("--------------------------------\n"
                        + "Pilih Menu\n"
                        + "(1) Menu Anggota perpustakaan\n"
                        + "(2) Menu Admin perpustakaan\n"
                        + "(3) Keluar\n"
                        + "--------------------------------\n");
                int pilih = input.nextInt();
                if (pilih == 1) {
                    menu = 2;
                } else if (pilih == 2) {
                    menu = 3;
                } else if (pilih == 3) {
                    menu = 4;
                } else {
                    System.out.println("Input Salah");
                    menu = 1;
                }
            } else if (menu == 2) {
                System.out.println("--------------------------------\n"
                        + "Menu Anggota perpustakaan\n"
                        + "Pilih Menu\n"
                        + "(1) Pinjam Buku\n"
                        + "(2) Kembalikan Buku\n"
                        + "(3) Cari Buku\n"
                        + "(4) Kembali\n"
                        + "--------------------------------\n");
                int pilih = input.nextInt();

                if (pilih == 1) {
                    admin.lihatSemuaAnggota(anggotaList);
                    System.out.print("Masukkan nomor anggota yang dipilih: ");
                    int selectedMemberIndex = input.nextInt();
                    input.nextLine();
                    AnggotaPerpustakaan selectedMember = anggotaList.get(selectedMemberIndex - 1);
                    admin.lihatSemuaBuku(bukuList);
                    System.out.print("Masukkan nomor buku yang dipilih: ");
                    int selectedBookIndex = input.nextInt();
                    input.nextLine();
                    Buku selectedBook = bukuList.get(selectedBookIndex - 1);
                    TransaksiPeminjaman peminjaman = new TransaksiPeminjaman(transaksiList.size() + 1, selectedMember, selectedBook, LocalDate.now(), 14);
                    peminjaman.pinjamBuku();

                } else if (pilih == 2) {
                    admin.lihatSemuaTransaksi(transaksiList);
                    System.out.print("Masukkan nomor transaksi yang akan dikembalikan: ");
                    int selectedTransactionIndex = input.nextInt();
                    input.nextLine();
                    if (selectedTransactionIndex >= 1 && selectedTransactionIndex <= transaksiList.size()) {
                        TransaksiPeminjaman selectedTransaction = transaksiList.get(selectedTransactionIndex - 1);
                        TransaksiPengembalian pengembalian = new TransaksiPengembalian(transaksiList.size() + 1, LocalDate.now());
                        pengembalian.kembalikanBuku(selectedTransaction);
                    }

                } else if (pilih == 3) {
                    admin.lihatSemuaBuku(bukuList);
                    input.nextLine();
                    System.out.print("Masukkan kata kunci pencarian: ");
                    String keyword = input.nextLine();

                    TransaksiPeminjaman.cariBuku(bukuList, keyword);

                } else if (pilih == 4) {
                    menu = 1;
                } else {
                    System.out.println("Input Salah");
                    menu = 2;
                }
            } else if (menu == 3) {
                System.out.print("Masukkan password admin: ");
                String password = input.nextLine();

                System.out.println("--------------------------------\n"
                        + "Menu Admin perpustakaan\n"
                        + "Pilih Menu\n"
                        + "(1) Tambah Anggota\n"
                        + "(2) Tambah Buku\n"
                        + "(3) Kirim Notifikasi\n"
                        + "(4) Lihat Semua Transaksi\n"
                        + "(5) Lihat Semua Anggota\n"
                        + "(6) Kembali\n"
                        + "--------------------------------\n");
                int pilih = input.nextInt();
                if (pilih == 1) {
                    input.nextLine();
                    System.out.print("Masukkan nama anggota baru: ");
                    String nama = input.nextLine();
                    System.out.print("Masukkan ID anggota baru: ");
                    int idanggota = input.nextInt();
                    input.nextLine();
                    System.out.print("Masukkan alamat anggota baru: ");
                    String alamat = input.nextLine();
                    AnggotaPerpustakaan anggotabaru = new AnggotaPerpustakaan(nama, idanggota, alamat);
                    admin.tambahAnggota(anggotaList, anggotabaru);
                } else if (pilih == 2) {
                    input.nextLine();
                    System.out.print("Masukkan judul buku baru: ");
                    String judul = input.nextLine();
                    System.out.print("Masukkan pengarang buku baru: ");
                    String pengarang = input.nextLine();
                    System.out.print("Masukkan ISBN buku baru: ");
                    String isbn = input.nextLine();
                    admin.tambahBuku(bukuList, new Buku(judul, pengarang, isbn, true));
                } else if (pilih == 3) {
                    admin.lihatSemuaAnggota(anggotaList);
                    System.out.print("Masukkan nomor anggota yang akan dikirim notifikasi: ");
                    int urutanggota = input.nextInt();
                    AnggotaPerpustakaan targetAnggota = anggotaList.get(urutanggota - 1);
                    input.nextLine();
                    admin.kirimNotifikasi(targetAnggota, "Selamat datang di perpustakaan!");
                } else if (pilih == 4) {
                    admin.lihatSemuaTransaksi(transaksiList);
                } else if (pilih == 5) {
                    admin.lihatSemuaAnggota(anggotaList);
                } else if (pilih == 6) {
                    menu = 1;
                } else {
                    System.out.println("Input Salah");
                    menu = 2;
                }
            } else if (menu == 4) {
                System.exit(0);
            }
        }
    }
}
