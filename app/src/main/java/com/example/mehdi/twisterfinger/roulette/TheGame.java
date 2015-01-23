package com.example.mehdi.twisterfinger.roulette;

/**
 * Created by oussama on 22/01/2015.
 */
public final class TheGame {

    private static volatile TheGame instance = null;
    private int nbrJoueur = 0;
    private int nbrDoigt = 0;
    private Colors currentCircleColor;
    private Colors currentRouletteColor;
    private int currentPlayer = 0;

    private TheGame(int joueur, int doigt){
        nbrDoigt = doigt;
        nbrJoueur = joueur;
        currentPlayer = 1;

    }

    public final static TheGame getInstance(int joueur, int doigt){
        if(TheGame.instance == null){
            synchronized (TheGame.class){
                if(TheGame.instance == null){
                    TheGame.instance = new TheGame(joueur, doigt);
                }
            }
        }
        return TheGame.instance;
    }

    public int getCurrentPlayer() {
        return currentPlayer;
    }

    public void setCurrentPlayer(int currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public Colors getCurrentRouletteColor() {
        return currentRouletteColor;
    }

    public void setCurrentRouletteColor(Colors currentRouletteColor) {
        this.currentRouletteColor = currentRouletteColor;
    }

    public Colors getCurrentCircleColor() {
        return currentCircleColor;
    }

    public void setCurrentCircleColor(Colors currentCircleColor) {
        this.currentCircleColor = currentCircleColor;
    }

    public int getNbrDoigt() {
        return nbrDoigt;
    }

    public void setNbrDoigt(int nbrDoigt) {
        this.nbrDoigt = nbrDoigt;
    }

    public int getNbrJoueur() {
        return nbrJoueur;
    }

    public void setNbrJoueur(int nbrJoueur) {
        this.nbrJoueur = nbrJoueur;
    }

    public static TheGame getInstance() {
        return instance;
    }

    public static void setInstance(TheGame instance) {
        TheGame.instance = instance;
    }

    // ou bien cette fct peut aller chercher d'une autre classe la couleur du cercle appuyé
    // ==> dans ce cas on fait passer que la couleur de la roulette
    public boolean checkForTheGame(){

        if(currentCircleColor == currentRouletteColor)
            return true;
        else
            return false;
    }

}
