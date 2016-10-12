package gempa.kampusdeveloper.model;

/**
 * Created by Dodi Rivaldi on 12/10/2016.
 */

public class Gempa {
    private String tgl;
    private String waktu;
    private String lintang_bujur;
    private String magnitudo;
    private String kedalaman;
    private String lokasi;
    private String dirasakan;
    private String img;

    public String getTgl() {
        return tgl;
    }

    public void setTgl(String tgl) {
        this.tgl = tgl;
    }

    public String getWaktu() {
        return waktu;
    }

    public void setWaktu(String waktu) {
        this.waktu = waktu;
    }

    public String getLintang_bujur() {
        return lintang_bujur;
    }

    public void setLintang_bujur(String lintang_bujur) {
        this.lintang_bujur = lintang_bujur;
    }

    public String getMagnitudo() {
        return magnitudo;
    }

    public void setMagnitudo(String magnitudo) {
        this.magnitudo = magnitudo;
    }

    public String getKedalaman() {
        return kedalaman;
    }

    public void setKedalaman(String kedalaman) {
        this.kedalaman = kedalaman;
    }

    public String getLokasi() {
        return lokasi;
    }

    public void setLokasi(String lokasi) {
        this.lokasi = lokasi;
    }

    public String getDirasakan() {
        return dirasakan;
    }

    public void setDirasakan(String dirasakan) {
        this.dirasakan = dirasakan;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
