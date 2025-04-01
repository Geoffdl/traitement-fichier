package fr.diginamic.model;

public class Categorie
{
    private String libelle;

    public Categorie(String libelle)
    {
        this.libelle = libelle;
    }

    public String getLibelle()
    {
        return libelle;
    }

    @Override
    public String toString()
    {
        final StringBuilder sb = new StringBuilder("Categorie{");
        sb.append("libelle='").append(libelle).append('\'');
        sb.append('}');
        return sb.toString();
    }
}