package com.hack4city.hack4city.WebService.Models;

public class CompleteFerryModel {
    public static class FerryModel {
        private String Adi;
        private String KalkisSaati;
        private String ToplamKapasite;
        private String KalanKapasite;

        public FerryModel() {
            this("","","","");
        }

        public FerryModel(String adi, String kalkisSaati, String toplamKapasite, String kalanKapasite) {
            Adi = adi;
            KalkisSaati = kalkisSaati;
            ToplamKapasite = toplamKapasite;
            KalanKapasite = kalanKapasite;
        }

        public String getAdi() {
            return Adi;
        }

        public void setAdi(String adi) {
            Adi = adi;
        }

        public String getKalkisSaati() {
            return KalkisSaati;
        }

        public void setKalkisSaati(String kalkisSaati) {
            KalkisSaati = kalkisSaati;
        }

        public String getToplamKapasite() {
            return ToplamKapasite;
        }

        public void setToplamKapasite(String toplamKapasite) {
            ToplamKapasite = toplamKapasite;
        }

        public String getKalanKapasite() {
            return KalanKapasite;
        }

        public void setKalanKapasite(String kalanKapasite) {
            KalanKapasite = kalanKapasite;
        }
    }
    private FerryModel ArabaliVapur;
    private FerryModel BirSonrakiArabaliVapur;

    public CompleteFerryModel() {
        this(null,null);
    }

    public CompleteFerryModel(FerryModel arabaliVapur, FerryModel birSonrakiArabaliVapur) {
        ArabaliVapur = arabaliVapur;
        BirSonrakiArabaliVapur = birSonrakiArabaliVapur;
    }

    public FerryModel getArabaliVapur() {
        return ArabaliVapur;
    }

    public void setArabaliVapur(FerryModel arabaliVapur) {
        ArabaliVapur = arabaliVapur;
    }

    public FerryModel getBirSonrakiArabaliVapur() {
        return BirSonrakiArabaliVapur;
    }

    public void setBirSonrakiArabaliVapur(FerryModel birSonrakiArabaliVapur) {
        BirSonrakiArabaliVapur = birSonrakiArabaliVapur;
    }
}
