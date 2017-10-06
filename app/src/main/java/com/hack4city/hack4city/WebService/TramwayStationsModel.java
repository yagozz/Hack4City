package com.hack4city.hack4city.WebService;

/**
 * Created by Johnson on 7.10.2017.
 */

public class TramwayStationsModel {
    private String IstastonId;
    private String Adi;

    public TramwayStationsModel() {
        this("","");
    }

    public TramwayStationsModel(String istastonId, String adi) {
        IstastonId = istastonId;
        Adi = adi;
    }

    public String getIstastonId() {
        return IstastonId;
    }

    public void setIstastonId(String istastonId) {
        IstastonId = istastonId;
    }

    public String getAdi() {
        return Adi;
    }

    public void setAdi(String adi) {
        Adi = adi;
    }
}
