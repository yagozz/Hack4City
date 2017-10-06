package com.hack4city.hack4city.WebService.Models;

public class FerryHoursModel {
    public static class ServiceHoursModel{
        public String VarisSaati;
        public String KalkisSaati;

        public ServiceHoursModel() {
            this(null,null);
        }
        public ServiceHoursModel(String varisSaati, String kalkisSaati) {
            VarisSaati = varisSaati;
            KalkisSaati = kalkisSaati;
        }
        public String getVarisSaati() {
            return VarisSaati;
        }
        public void setVarisSaati(String varisSaati) {
            VarisSaati = varisSaati;
        }
        public String getKalkisSaati() {
            return KalkisSaati;
        }
        public void setKalkisSaati(String kalkisSaati) {
            KalkisSaati = kalkisSaati;
        }
    }
    public static class ServiceRowModel{
        private String Aciklama;
        private String IptalAciklama;
        private boolean IptalMi;
        private ServiceHoursModel seferSaatleri;
        public ServiceRowModel() {
            this(null,null,false,null);
        }
        public ServiceRowModel(String aciklama, String iptalAciklama, boolean iptalMi, ServiceHoursModel seferSaatleri) {
            Aciklama = aciklama;
            IptalAciklama = iptalAciklama;
            IptalMi = iptalMi;
            this.seferSaatleri = seferSaatleri;
        }
        public ServiceHoursModel getSeferSaatleri() {
            return seferSaatleri;
        }
        public void setSeferSaatleri(ServiceHoursModel seferSaatleri) {
            this.seferSaatleri = seferSaatleri;
        }
        public String getAciklama() {
            return Aciklama;
        }
        public void setAciklama(String aciklama) {
            Aciklama = aciklama;
        }
        public String getIptalAciklama() {
            return IptalAciklama;
        }
        public void setIptalAciklama(String iptalAciklama) {
            IptalAciklama = iptalAciklama;
        }
        public boolean isIptalMi() {
            return IptalMi;
        }
        public void setIptalMi(boolean iptalMi) {
            IptalMi = iptalMi;
        }
    }

    private String hatAdi;
    private String[] iskeleler;
    private ServiceRowModel[] seferSatirlari;

    public FerryHoursModel() {
        this(null,null,null);
    }

    public FerryHoursModel(String hatAdi, String[] iskeleler, ServiceRowModel[] seferSatirlari) {
        this.hatAdi = hatAdi;
        this.iskeleler = iskeleler;
        this.seferSatirlari = seferSatirlari;
    }

    public String getHatAdi() {
        return hatAdi;
    }

    public void setHatAdi(String hatAdi) {
        this.hatAdi = hatAdi;
    }

    public String[] getIskeleler() {
        return iskeleler;
    }

    public void setIskeleler(String[] iskeleler) {
        this.iskeleler = iskeleler;
    }

    public ServiceRowModel[] getSeferSatirlari() {
        return seferSatirlari;
    }

    public void setSeferSatirlari(ServiceRowModel[] seferSatirlari) {
        this.seferSatirlari = seferSatirlari;
    }
}
