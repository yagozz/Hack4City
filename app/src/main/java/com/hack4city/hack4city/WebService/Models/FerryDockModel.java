package com.hack4city.hack4city.WebService.Models;

public class FerryDockModel {
    private int IskeleId;
    private String Adi;
    private double KoorX;
    private double KoorY;
    private boolean ArabalıVapurIskelesiMi;
    private boolean AktifMi;

    public FerryDockModel() {
        this(0,"",0.0,0.0,false,false);
    }

    public FerryDockModel(int iskeleId, String adi, double koorX, double koorY, boolean arabalıVapurIskelesiMi, boolean aktifMi) {
        IskeleId = iskeleId;
        Adi = adi;
        KoorX = koorX;
        KoorY = koorY;
        ArabalıVapurIskelesiMi = arabalıVapurIskelesiMi;
        AktifMi = aktifMi;
    }

    public int getIskeleId() {
        return IskeleId;
    }

    public void setIskeleId(int iskeleId) {
        IskeleId = iskeleId;
    }

    public String getAdi() {
        return Adi;
    }

    public void setAdi(String adi) {
        Adi = adi;
    }

    public double getKoorX() {
        return KoorX;
    }

    public void setKoorX(double koorX) {
        KoorX = koorX;
    }

    public double getKoorY() {
        return KoorY;
    }

    public void setKoorY(double koorY) {
        KoorY = koorY;
    }

    public boolean isArabalıVapurIskelesiMi() {
        return ArabalıVapurIskelesiMi;
    }

    public void setArabalıVapurIskelesiMi(boolean arabalıVapurIskelesiMi) {
        ArabalıVapurIskelesiMi = arabalıVapurIskelesiMi;
    }

    public boolean isAktifMi() {
        return AktifMi;
    }

    public void setAktifMi(boolean aktifMi) {
        AktifMi = aktifMi;
    }
}
