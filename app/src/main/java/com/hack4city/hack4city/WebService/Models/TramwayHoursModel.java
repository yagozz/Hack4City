package com.hack4city.hack4city.WebService.Models;

/**
 * Created by Johnson on 7.10.2017.
 */

public class TramwayHoursModel {
    private String BaslangicSaati;
    private String BitisSaati;
    private String Aralik;

    public TramwayHoursModel() {
        this("","","");
    }

    public TramwayHoursModel(String baslangicSaati, String bitisSaati, String aralik) {

        BaslangicSaati = baslangicSaati;
        BitisSaati = bitisSaati;
        Aralik = aralik;
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

    public String getAralik() {
        return Aralik;
    }

    public void setAralik(String aralik) {
        Aralik = aralik;
    }
}
