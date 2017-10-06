package com.hack4city.hack4city.WebService;

/**
 * Created by Johnson on 7.10.2017.
 */

public class MetroHours {
    private String SeferId;
    private String TarifeId;
    private String BaslangicSaati;
    private String BitisSaati;
    private String Sira;
    private String Aralik;

    public MetroHours() {

        this("","","","","","");
    }

    public MetroHours(String seferId, String tarifeId, String baslangicSaati, String bitisSaati, String sira, String aralik) {

        SeferId = seferId;
        TarifeId = tarifeId;
        BaslangicSaati = baslangicSaati;
        BitisSaati = bitisSaati;
        Sira = sira;
        Aralik = aralik;
    }

    public String getSeferId() {
        return SeferId;
    }

    public void setSeferId(String seferId) {
        SeferId = seferId;
    }

    public String getTarifeId() {
        return TarifeId;
    }

    public void setTarifeId(String tarifeId) {
        TarifeId = tarifeId;
    }

    public String getBaslangicSaati() {
        return BaslangicSaati;
    }

    public void setBaslangicSaati(String baslangicSaati) {
        BaslangicSaati = baslangicSaati;
    }

    public String getBitisSaati() {
        return BitisSaati;
    }

    public void setBitisSaati(String bitisSaati) {
        BitisSaati = bitisSaati;
    }

    public String getSira() {
        return Sira;
    }

    public void setSira(String sira) {
        Sira = sira;
    }

    public String getAralik() {
        return Aralik;
    }

    public void setAralik(String aralik) {
        Aralik = aralik;
    }
}
