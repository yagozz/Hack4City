package com.hack4city.hack4city.WebService;

/**
 * Created by Johnson on 7.10.2017.
 */

public class BisimStations {
    private String IstasyonId;
    private String IstasyonAdi;
    private String Durumu;
    private String Kapasite;
    private String BisikletSayisi;
    private String BosParkYeri;
    private String Koordinat;
    private String KoordinatX;
    private String KoordinatY;

    public BisimStations() {
        this("","","","","","","","","");
    }

    public BisimStations(String istasyonId, String istasyonAdi, String durumu, String kapasite, String bisikletSayisi, String bosParkYeri, String koordinat, String koordinatX, String koordinatY) {
        IstasyonId = istasyonId;
        IstasyonAdi = istasyonAdi;
        Durumu = durumu;
        Kapasite = kapasite;
        BisikletSayisi = bisikletSayisi;
        BosParkYeri = bosParkYeri;
        Koordinat = koordinat;
        KoordinatX = koordinatX;
        KoordinatY = koordinatY;
    }

    public String getIstasyonId() {
        return IstasyonId;
    }

    public void setIstasyonId(String istasyonId) {
        IstasyonId = istasyonId;
    }

    public String getIstasyonAdi() {
        return IstasyonAdi;
    }

    public void setIstasyonAdi(String istasyonAdi) {
        IstasyonAdi = istasyonAdi;
    }

    public String getDurumu() {
        return Durumu;
    }

    public void setDurumu(String durumu) {
        Durumu = durumu;
    }

    public String getKapasite() {
        return Kapasite;
    }

    public void setKapasite(String kapasite) {
        Kapasite = kapasite;
    }

    public String getBisikletSayisi() {
        return BisikletSayisi;
    }

    public void setBisikletSayisi(String bisikletSayisi) {
        BisikletSayisi = bisikletSayisi;
    }

    public String getBosParkYeri() {
        return BosParkYeri;
    }

    public void setBosParkYeri(String bosParkYeri) {
        BosParkYeri = bosParkYeri;
    }

    public String getKoordinat() {
        return Koordinat;
    }

    public void setKoordinat(String koordinat) {
        Koordinat = koordinat;
    }

    public String getKoordinatX() {
        return KoordinatX;
    }

    public void setKoordinatX(String koordinatX) {
        KoordinatX = koordinatX;
    }

    public String getKoordinatY() {
        return KoordinatY;
    }

    public void setKoordinatY(String koordinatY) {
        KoordinatY = koordinatY;
    }


}
