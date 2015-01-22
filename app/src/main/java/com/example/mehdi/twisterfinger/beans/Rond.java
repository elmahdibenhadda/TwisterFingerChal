package com.example.mehdi.twisterfinger.beans;

import android.widget.ImageView;

/**
 * Created by mehdi on 22/01/2015.
 */
public class Rond {

    private ImageView imageViewRond;
    private String couleur;
    private String num;
    private String nomJoueur="";

    public String getNomJoueur() {
        return nomJoueur;
    }

    public void setNomJoueur(String nomJoueur) {
        this.nomJoueur = nomJoueur;
    }

    public ImageView getImageViewRond() {
        return imageViewRond;
    }

    public void setImageViewRond(ImageView imageViewRond) {
        this.imageViewRond = imageViewRond;
    }

    public String getCouleur() {
        return couleur;
    }

    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }



    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public Rond(ImageView imageViewRond, String couleur, String num) {
        this.imageViewRond = imageViewRond;
        this.couleur = couleur;
        this.num = num;
    }
}
