package fr.diginamic.service;

import fr.diginamic.model.Additif;
import fr.diginamic.model.Allergene;
import fr.diginamic.model.Ingredients;

import java.util.ArrayList;
import java.util.List;

public class Parser
{
    public static List<Ingredients> parseIngredients(String ingredientsStr) {


        List<Ingredients> ingredients = new ArrayList<>();

        String[] tokens = ingredientsStr.split("," + ":" + "%");

        for ( int i = 0; i< tokens.length; i ++ ){
            ingredients.add(new Ingredients(tokens[i]));
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