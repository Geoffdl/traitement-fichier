package fr.diginamic.model;

public class Marque
{
    private String Marque;

    public Marque(String marque)
    {
        Marque = marque;
    }

    @Override
    public String toString()
    {
        final StringBuilder sb = new StringBuilder("Marque{");
        sb.append("Marque='").append(Marque).append('\'');
        sb.append('}');
        return sb.toString();
    }
}