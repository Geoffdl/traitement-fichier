package fr.diginamic;

import fr.diginamic.model.Produit;
import fr.diginamic.model.Stock;
import fr.diginamic.service.*;
import fr.diginamic.utils.ParserRawCsv;
import fr.diginamic.utils.InputValidator;
import fr.diginamic.utils.MenuDisplay;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class ApplicationOpenFoodFacts
{
    public static void main(String[] args) throws IOException
    {
        Path file = Paths.get("src/main/resources/open-food-facts.csv");
        List<Produit> produits = ParserRawCsv.parse(file);

        Scanner scanner = new Scanner(System.in);
        Stock stock = new Stock(produits);

        MenuService service;

//        debugging(stock);

        while (true)
        {
            MenuDisplay.displayHomeMenu();

            int choix = InputValidator.userInputInt(scanner);

            switch (choix)
            {
                case 1:
                    service = new RechercheMeilleurProduitMarque();
                    service.traiter(stock, scanner);
                    break;
                case 2:
                    service = new RechercheMeilleurProduitCategorie();
                    service.traiter(stock, scanner);
                    break;
                case 3:
                    service = new RechercheMeilleurProduitCategorieMarque();
                    service.traiter(stock,scanner);
                    break;
                case 4:
                    service = new RechercheRecurrenceAllergnes();
                    service.traiter(stock, scanner);
                    break;
                case 5:
                    service = new RechercheRecurrenceAdditifs();
                    service.traiter(stock, scanner);
                    break;

                case 6:
                    System.out.println("Au revoir !");
                    scanner.close();
                    return;
            }
        }
    }

    public static void debugging(Stock stock){

        for(Produit produit : stock.getProduits()){
            System.out.println(produit.getAdditifs());
            System.out.println(produit.getAllergenes());
        }
    }
}