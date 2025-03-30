package fr.diginamic.model;

/*
La classe Produit possède :
une catégorie
une marque
un grade nutritionnel (de A à F)
un tas de données nutritionnelles (sucre, sel, etc..)
une liste d’ingrédients
une liste d’allergènes
une liste d’additifs.
 */

public class Produit
{
    String categorie;
    String marque;
    ScoreNutritionnel nutriscore;
    String valeursNutritionnels;
    String ingredients;
    String additifs;
}