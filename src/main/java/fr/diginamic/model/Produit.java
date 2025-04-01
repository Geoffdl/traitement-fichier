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

import java.util.List;


public class Produit {
    Categorie categorie;
    Marque marque;
    ScoreNutritionnel scoreNutritionnel;
    List<Ingredients> ingredients;
    List<Additif> additifs;
    List<Allergene> allergenes;
    String nom;

    public Produit(Categorie categorie, Marque marque, ScoreNutritionnel scoreNutritionnel,
            List<Ingredients> ingredients, List<Additif> additifs, List<Allergene> allergenes, String nom) {
        this.categorie = categorie;
        this.marque = marque;
        this.scoreNutritionnel = scoreNutritionnel;
        this.ingredients = ingredients;

        this.additifs = additifs;
        this.allergenes = allergenes;
        this.nom = nom;
    }


    public Categorie getCategorie()
    {
        return categorie;
    }

    public Marque getMarque()
    {
        return marque;
    }

    public ScoreNutritionnel getScoreNutritionnel()
    {
        return scoreNutritionnel;
    }

    public List<Ingredients> getIngredients()
    {
        return ingredients;
    }

    public List<Additif> getAdditifs()
    {
        return this.additifs;
    }

    public List<Allergene> getAllergenes()
    {
        return allergenes;
    }

    public String getNom()
    {
        return nom;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("\nProduit{");
        sb.append("categorie=").append(categorie);
        sb.append(", marque=").append(marque);
        sb.append(", scoreNutritionnel=").append(scoreNutritionnel);
        sb.append(", ingredients=").append(ingredients);
        sb.append(", additifs=").append(additifs);
        sb.append(", allergenes=").append(allergenes);
        sb.append('}');
        return sb.toString();
    }

}