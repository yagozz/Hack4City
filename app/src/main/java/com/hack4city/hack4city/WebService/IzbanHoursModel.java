package com.hack4city.hack4city.WebService;

/**
 * Created by Johnson on 7.10.2017.
 */

public class IzbanHoursModel {

    private String HareketIstasyonID;
    private String HareketIstasyonAdi;
    private String VarisIstasyonID;
    private String VarisIstasyonAdi;
    private String HareketSaati;
    private String VarisSaati;

    public IzbanHoursModel() {
        this("","","","","","");
    }

    public IzbanHoursModel(String hareketIstasyonID, String hareketIstasyonAdi, String varisIstasyonID, String varisIstasyonAdi, String hareketSaati, String varisSaati) {
        HareketIstasyonID = hareketIstasyonID;
        HareketIstasyonAdi = hareketIstasyonAdi;
        VarisIstasyonID = varisIstasyonID;
        VarisIstasyonAdi = varisIstasyonAdi;
        HareketSaati = hareketSaati;
        VarisSaati = varisSaati;
    }

    public String getHareketIstasyonID() {
        return HareketIstasyonID;
    }

    public void setHareketIstasyonID(String hareketIstasyonID) {
        HareketIstasyonID = hareketIstasyonID;
    }

    public String getHareketIstasyonAdi() {
        return HareketIstasyonAdi;
    }

    public void setHareketIstasyonAdi(String hareketIstasyonAdi) {
        HareketIstasyonAdi = hareketIstasyonAdi;
    }

    public String getVarisIstasyonID() {
        return VarisIstasyonID;
    }

    public void setVarisIstasyonID(String varisIstasyonID) {
        VarisIstasyonID = varisIstasyonID;
    }

    public String getVarisIstasyonAdi() {
        return VarisIstasyonAdi;
    }

    public void setVarisIstasyonAdi(String varisIstasyonAdi) {
        VarisIstasyonAdi = varisIstasyonAdi;
    }

    public String getHareketSaati() {
        return HareketSaati;
    }

    public void setHareketSaati(String hareketSaati) {
        HareketSaati = hareketSaati;
    }

    public String getVarisSaati() {
        return VarisSaati;
    }

    public void setVarisSaati(String varisSaati) {
        VarisSaati = varisSaati;
    }
}
