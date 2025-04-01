package fr.diginamic.service;

import fr.diginamic.model.Produit;
import fr.diginamic.model.Stock;
import fr.diginamic.utils.ComparatorProduitScore;
import fr.diginamic.utils.InputValidator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RechercheMeilleurProduitCategorieMarque extends MenuService
{


    @Override
    public void traiter(Stock stock, Scanner scanner)
    {

        // user inputs
        System.out.print("Veuillez saisir le nom de la marque : ");
        String nomMarque = InputValidator.userInputString(scanner);
        System.out.printf("Veuillez saisir la catégorie recherchée pour la marque %s :", nomMarque);
        String nomCategorie = InputValidator.userInputString(scanner);

        //Generate list matching queried categories
        List<Produit> queryList = new ArrayList<>();
        for (Produit produit : stock.getProduits())
        {
            if (nomMarque.equals(produit.getMarque().getNom()) && nomCategorie.equals(produit.getCategorie().getLibelle()))
            {
                queryList.add(produit);
            }
        }
        //sort for result & print
        if (!queryList.isEmpty())
        {
            queryList.sort(new ComparatorProduitScore());
            System.out.printf("\nProduits de la marque %s et de la catégorie %s triés par score nutritionnel :\n", nomMarque, nomCategorie);
            for (Produit item : queryList)
            {
                System.out.printf("\t Score - %s _ Produit - %s \n", item.getScoreNutritionnel(), item.getNom());
            }
        } else
        {
            System.out.println("\nAucun produits trouvés pour ces critères de recherche");
        }
        ;
        InputValidator.waitForEnter(scanner);
    }
}