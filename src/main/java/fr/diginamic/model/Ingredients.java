package fr.diginamic.model;

public class Ingredients
{
    private String libelle;


    public Ingredients(String libelle)
    {
        this.libelle = libelle;
    }


    @Override
    public String toString()
    {
        final StringBuilder sb = new StringBuilder("Ingredients{");
        sb.append("libelle='").append(libelle).append('\'');
        sb.append('}');
        return sb.toString();
    }
}