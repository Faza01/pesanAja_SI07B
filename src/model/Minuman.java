/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Faza Bilwildi Emyu_2311103083_SI-07-B
 */
public class Minuman extends Produk {

    private String namaMinuman;
    private String penyajian; // panas, dingin

    public Minuman(String namaMinuman, double harga, String deskripsi, boolean tersedia, String penyajian) throws ValidasiInputException {
        super(harga, deskripsi, tersedia);
        if (namaMinuman == null || namaMinuman.isEmpty()) {
            throw new ValidasiInputException("Nama minuman tidak boleh kosong.");
        }
        if (penyajian == null || penyajian.isEmpty()) {
            throw new ValidasiInputException("Penyajian tidak boleh kosong.");
        }
        this.penyajian = penyajian;
        this.namaMinuman = namaMinuman;
    }

    public String getNamaMinuman() {
        return namaMinuman;
    }

    public String getPenyajian() {
        return penyajian;
    }
}
