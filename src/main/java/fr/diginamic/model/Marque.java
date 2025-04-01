package fr.diginamic.model;

public class Marque {
    private String nom;

    public Marque(String marque) {
        this.nom = marque;
    }

    public String getNom()
    {
        return nom;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Marque : ");
        sb.append(nom);
        return sb.toString();
    }
}