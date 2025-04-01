package fr.diginamic.utils;

import fr.diginamic.model.Additif;
import fr.diginamic.model.Allergene;
import fr.diginamic.model.Ingredients;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static fr.diginamic.utils.StringCleaner.cleanMyString;

public class ParserProduitParams
{
    private static Map<String, Ingredients> uniqueIngredients = new HashMap<>();
    private static Map<String, Additif> uniqueAdditifs = new HashMap<>();
    private static Map<String, Allergene> uniqueAllergenes = new HashMap<>();

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
        if(additifStr == null || additifStr.trim().isEmpty()){
            return additifs;
        }

        // Clean the string first
        String cleanedAdditif = cleanMyString(additifStr).toLowerCase();

        // Split the cleaned string
        String[] tokens = cleanedAdditif.split("\\s+");

        // Create Additif objects from cleaned tokens, using the cache
        for (String token : tokens) {
            if (!token.isEmpty()) {
                // Check if we already have this additif
                Additif additif = uniqueAdditifs.computeIfAbsent(
                        token,
                        k -> new Additif(token)
                );
                additifs.add(additif);
            }
        }

        return additifs;
    }

    public static List<Allergene> parseAllergenes(String allergenesStr) {
        List<Allergene> allergenes = new ArrayList<>();
        if(allergenesStr == null || allergenesStr.trim().isEmpty()){
            return allergenes;
        }

        String cleanedAllergenes = cleanMyString(allergenesStr).toLowerCase();
        String[] tokens = cleanedAllergenes.split(" ");

//        String[] tokens = allergenesStr.split("," + ":" + "%");

        for (String token : tokens){
            if(!token.isEmpty()){
                Allergene allergene = uniqueAllergenes.computeIfAbsent(
                        token,
                        k -> new Allergene(token));
                allergenes.add(allergene);
            }
        }

        return allergenes;
    }
}