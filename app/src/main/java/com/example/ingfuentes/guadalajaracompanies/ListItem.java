package com.example.ingfuentes.guadalajaracompanies;
import android.graphics.drawable.Drawable;

/*** Created by Ing. Fuentes on 15/11/2014.*/

public class ListItem {
    private String txtCompanyName =null;
    private String txtCompanyGiro =null;
    private Drawable imgCompany =null;

    public void setTxtCompanyName(String txtCompanyName) {
        this.txtCompanyName = txtCompanyName;
    }

    public void setTxtCompanyGiro(String txtCompanyGiro) {
        this.txtCompanyGiro = txtCompanyGiro;
    }

    public void setImgCompany(Drawable imgCompany) {
        this.imgCompany = imgCompany;
    }

    public String getTxtCompanyName() {
        return txtCompanyName;
    }

    public String getTxtCompanyGiro() {
        return txtCompanyGiro;
    }

    public Drawable getImgCompany() {
        return imgCompany;
    }
}
