package fr.diginamic.model;

public class Allergene
{
    private String libelle;

    public Allergene(String libelle)
    {
        this.libelle = libelle;
    }


    @Override
    public String toString()
    {
        final StringBuilder sb = new StringBuilder("Allergene{");
        sb.append("libelle='").append(libelle).append('\'');
        sb.append('}');
        return sb.toString();
    }
}