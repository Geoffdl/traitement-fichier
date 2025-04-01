package fr.diginamic.model;

public class Additif
{
    private String libelle;

    public Additif(String libelle)
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
        final StringBuilder sb = new StringBuilder("Additif : ").append(libelle);

        return sb.toString();
    }
}