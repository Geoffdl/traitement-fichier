package fr.diginamic.utils;

import fr.diginamic.model.Produit;

import java.util.Comparator;

public class ComparatorProduitScore implements Comparator<Produit>
{
    @Override
    public int compare(Produit o1, Produit o2)
    {
        return o1.getScoreNutritionnel().compareTo(o2.getScoreNutritionnel());
    }
}