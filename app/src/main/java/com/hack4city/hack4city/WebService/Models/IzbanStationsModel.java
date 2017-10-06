package com.hack4city.hack4city.WebService.Models;

/**
 * Created by Johnson on 7.10.2017.
 */

public class IzbanStationsModel {
    private String IstasyonId;
    private String IstasyonAdi;
    private String IstasyonSirasi;
    private String KoordinatX;
    private String KoordinatY;

    public IzbanStationsModel() {
        this("","","","","");
    }

    public IzbanStationsModel(String istasyonId, String istasyonAdi, String istasyonSirasi, String koordinatX, String koordinatY) {
        IstasyonId = istasyonId;
        IstasyonAdi = istasyonAdi;
        IstasyonSirasi = istasyonSirasi;
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

    public String getIstasyonSirasi() {
        return IstasyonSirasi;
    }

    public void setIstasyonSirasi(String istasyonSirasi) {
        IstasyonSirasi = istasyonSirasi;
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
