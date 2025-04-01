package fr.diginamic.service;

import fr.diginamic.model.Additif;
import fr.diginamic.model.Allergene;
import fr.diginamic.model.Ingredients;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Parser
{
    private static Map<String, Ingredients> uniqueIngredients = new HashMap<>();

    public static List<Ingredients> parseIngredients(String ingredientsStr) {
        List<Ingredients> ingredients = new ArrayList<>();

        if (ingredientsStr == null || ingredientsStr.trim().isEmpty()) {
            return ingredients;
        }

        String[] tokens = ingredientsStr.split(",");

        for (String token : tokens) {
            String trimmed = token.trim();
            if (!trimmed.isEmpty()) {
                // Check if we already have this ingredient
                Ingredients ingredient = uniqueIngredients.computeIfAbsent(
                        trimmed,
                        k -> new Ingredients(trimmed)
                );
                ingredients.add(ingredient);
            }
        }

        return ingredients;
    }

    public static List<Additif> parseAdditifs(String additifStr) {

        List<Additif> additifs = new ArrayList<>();
        if(additifStr == null){
            return additifs;
        }

        String[] tokens = additifStr.split("," + ":" + "%");

        for ( int i = 0; i< tokens.length; i ++ ){
            additifs.add(new Additif(tokens[i]));
        }

        return additifs;
    }

    public static List<Allergene> parseAllergenes(String allergenesStr) {


        List<Allergene> allergenes = new ArrayList<>();
        if(allergenesStr == null){
            return allergenes;
        }

        String[] tokens = allergenesStr.split("," + ":" + "%");

        for ( int i = 0; i< tokens.length; i ++ ){
            allergenes.add(new Allergene(tokens[i]));
        }

        return allergenes;
    }
}