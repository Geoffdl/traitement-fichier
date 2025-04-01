package fr.diginamic.service;

import fr.diginamic.model.Produit;
import fr.diginamic.model.Stock;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RechercheMeilleurProduitCategorie extends MenuService
{
    /**
     * Recherche les meilleurs Produits pour une Categorie donnée en fonction du nutriscore
     * @param stock
     * @param scanner
     */
    @Override
    public void traiter(Stock stock, Scanner scanner)
    {
        scanner.nextLine();

        System.out.print("Veuillez saisir le nom de la catégorie :");
        String nomCategorie = scanner.nextLine().trim();

        // Create a list to store products of the specified brand
        List<Produit> produitsCategorie = new ArrayList<>();

        // Find all products of the specified brand
        for (Produit produit : stock.getProduits()) {
            if (produit.getCategorie().getLibelle().contains(nomCategorie)) {
                produitsCategorie.add(produit);
            }
        }

        if (produitsCategorie.isEmpty()) {
            System.out.println("Aucun produit trouvé pour la catégorie : " + nomCategorie);
            return;
        }

        // Sort products by nutritional score (A to F)
        produitsCategorie.sort((p1, p2) -> p1.getScoreNutritionnel().compareTo(p2.getScoreNutritionnel()));

        // Display results
        System.out.println("\nProduits de la catégorie " + nomCategorie + " triés par score nutritionnel :");
        for (Produit produit : produitsCategorie) {
            System.out.println("Score : " + produit.getScoreNutritionnel() + " - " + produit.getNom());
        }

        System.out.println("\nAppuyez sur Entrée pour continuer...");
        scanner.nextLine();
    }
}