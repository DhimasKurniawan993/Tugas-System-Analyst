/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package perpustakaanxyz;

/**
 *
 * @author ASUS
 */
public class Buku {
    String judul;
    String pengarang;
    String isbn;
    boolean statusKetersediaan;

    public Buku(String judul, String pengarang, String isbn, boolean statusKetersediaan) {
        this.judul = judul;
        this.pengarang = pengarang;
        this.isbn = isbn;
        this.statusKetersediaan = statusKetersediaan;
    }
}
