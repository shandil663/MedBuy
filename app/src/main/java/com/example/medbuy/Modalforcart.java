package com.example.medbuy;

public class Modalforcart {
    String Medname,Medprice,Medqt,Medimg,totalprice;

    public String getMedname() {
        return Medname;
    }

    public void setMedname(String medname) {
        Medname = medname;
    }

    public String getMedprice() {
        return Medprice;
    }

    public void setMedprice(String medprice) {
        Medprice = medprice;
    }

    public String getMedqt() {
        return Medqt;
    }

    public void setMedqt(String medqt) {
        Medqt = medqt;
    }

    public String getMedimg() {
        return Medimg;
    }

    public void setMedimg(String medimg) {
        Medimg = medimg;
    }

    public String getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(String totalprice) {
        this.totalprice = totalprice;
    }

    public Modalforcart(String medname, String medprice, String medqt, String medimg, String totalprice) {
        Medname = medname;
        Medprice = medprice;
        Medqt = medqt;
        Medimg = medimg;
        this.totalprice = totalprice;
    }

    public Modalforcart() {
    }
}
