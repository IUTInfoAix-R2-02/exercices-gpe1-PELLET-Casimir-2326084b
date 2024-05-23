package fr.amu.iut.exercice12;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.control.Button;

public class CustomButton extends Button {

    private String couleur;

    public int getNbClics() {
        return nbClics.get();
    }

    public String getCouleur(){
        return couleur;
    }
    public IntegerProperty nbClicsProperty() {
        return nbClics;
    }

    public void setNbClics(int nbClics) {
        this.nbClics.set(nbClics);
    }

    private IntegerProperty nbClics;

    public CustomButton(String texte, String couleur) {
        super(texte);
        this.couleur = couleur;
        nbClics = new SimpleIntegerProperty(0);
    }
}
