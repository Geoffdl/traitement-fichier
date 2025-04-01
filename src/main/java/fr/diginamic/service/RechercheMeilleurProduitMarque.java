package fr.diginamic.service;

import fr.diginamic.model.Stock;
import fr.diginamic.model.Produit;
import fr.diginamic.utils.ComparatorProduitScore;
import fr.diginamic.utils.InputValidator;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class RechercheMeilleurProduitMarque extends MenuService {
    /**
     * Recherche et trie les produits pour une marque donnée en fonction du
     * ScoreNutritionnel
     *
     * @param stock
     * @param scanner
     */
    @Override
    public void traiter(Stock stock, Scanner scanner) {


        System.out.print("Veuillez saisir le nom de la marque : ");
        String nomMarque = InputValidator.userInputString(scanner);

        // Create a list to store products of the specified brand
        List<Produit> produitsMarque = new ArrayList<>();

        // Find all products of the specified brand
        for (Produit produit : stock.getProduits()) {
            if (produit.getMarque().getNom().equalsIgnoreCase(nomMarque)) {
                produitsMarque.add(produit);
            }
        }

        if (produitsMarque.isEmpty()) {
            System.out.println("Aucun produit trouvé pour la marque : " + nomMarque);
            return;
        }

        // Sort products by nutritional score (A to F)
        produitsMarque.sort(new ComparatorProduitScore());

        // Display results
        System.out.println("\nProduits de la marque " + nomMarque + " triés par score nutritionnel :");
        for (Produit produit : produitsMarque) {
            System.out.println("Score : " + produit.getScoreNutritionnel() + " - " + produit.getMarque() + " - " + produit.getNom());
        }

        InputValidator.waitForEnter(scanner);

    }
}