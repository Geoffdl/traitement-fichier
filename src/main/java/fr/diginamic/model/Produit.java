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

import java.util.ArrayList;
import java.util.List;

public class Produit
{
    Categorie categore;
    Marque marque;
    ScoreNutritionnel scoreNutritionnel;
    ArrayList<Ingredients> ingredients;
    List<Ingredients> ingredientss;
    List<Additif> additifs;
    List<Allergene> allergenes;

}