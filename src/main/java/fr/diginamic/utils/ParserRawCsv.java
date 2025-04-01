package fr.diginamic.utils;

import fr.diginamic.model.*;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class ParserRawCsv
{
    public static List<Produit> parse(Path filePath) throws IOException
    {
        List<Produit> produits = new ArrayList<>();
        List<String> lines = Files.readAllLines(filePath, StandardCharsets.UTF_8);
        // Skip header
        for (int i = 1; i < lines.size(); i++)
        {
            String line = lines.get(i);
            String[] tokens = line.split("\\|", -1);

            List<Ingredients> ingredients = ParserProduitParams.parseIngredients(tokens[4]);
            List<Additif> additifs = ParserProduitParams.parseAdditifs(tokens[29]);
            List<Allergene> allergenes = ParserProduitParams.parseAllergenes(tokens[28]);

            Produit produit = new Produit(
                    new Categorie(tokens[0]),
                    new Marque(tokens[1]),
                    ScoreNutritionnel.fromLabel(tokens[3]),
                    ingredients,
                    additifs,
                    allergenes,
                    tokens[2]);

            produits.add(produit);
        }
        return produits;
    }
}