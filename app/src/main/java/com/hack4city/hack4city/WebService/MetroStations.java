package com.hack4city.hack4city.WebService;

/**
 * Created by Johnson on 7.10.2017.
 */

public class MetroStations {
    private String IstasyonId;
    private String Adi;
    private String Fotograf;
    private String Sira;
    private String AktifMi;
    private String KoorX;
    private String KoorY;

    public MetroStations() {
        this("","","","","","","");
    }

    public MetroStations(String istasyonId, String adi, String fotograf, String sira, String aktifMi, String koorX, String koorY) {
        IstasyonId = istasyonId;
        Adi = adi;
        Fotograf = fotograf;
        Sira = sira;
        AktifMi = aktifMi;
        KoorX = koorX;
        KoorY = koorY;
    }

    public String getIstasyonId() {
        return IstasyonId;
    }

    public void setIstasyonId(String istasyonId) {
        IstasyonId = istasyonId;
    }

    public String getAdi() {
        return Adi;
    }

    public void setAdi(String adi) {
        Adi = adi;
    }

    public String getFotograf() {
        return Fotograf;
    }

    public void setFotograf(String fotograf) {
        Fotograf = fotograf;
    }

    public String getSira() {
        return Sira;
    }

    public void setSira(String sira) {
        Sira = sira;
    }

    public String getAktifMi() {
        return AktifMi;
    }

    public void setAktifMi(String aktifMi) {
        AktifMi = aktifMi;
    }

    public String getKoorX() {
        return KoorX;
    }

    public void setKoorX(String koorX) {
        KoorX = koorX;
    }

    public String getKoorY() {
        return KoorY;
    }

    public void setKoorY(String koorY) {
        KoorY = koorY;
    }


}
