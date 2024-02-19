package com.example.medbuy;

public class Modal {
    String MedPrice,Meddesc,Medimg,Medname,Medstock;

    public String getMedPrice() {
        return MedPrice;
    }

    public void setMedPrice(String medPrice) {
        MedPrice = medPrice;
    }

    public String getMeddesc() {
        return Meddesc;
    }

    public void setMeddesc(String meddesc) {
        Meddesc = meddesc;
    }

    public String getMedimg() {
        return Medimg;
    }

    public void setMedimg(String medimg) {
        Medimg = medimg;
    }

    public String getMedname() {
        return Medname;
    }

    public void setMedname(String medname) {
        Medname = medname;
    }

    public String getMedstock() {
        return Medstock;
    }

    public void setMedstock(String medstock) {
        Medstock = medstock;
    }

    public Modal(String medPrice, String meddesc, String medimg, String medname, String medstock) {
        MedPrice = medPrice;
        Meddesc = meddesc;
        Medimg = medimg;
        Medname = medname;
        Medstock = medstock;
    }

    public Modal() {
    }
}
