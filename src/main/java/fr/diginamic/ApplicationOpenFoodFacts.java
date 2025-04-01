package fr.diginamic;

import fr.diginamic.model.Produit;
import fr.diginamic.model.Stock;
import fr.diginamic.service.MenuService;
import fr.diginamic.service.RechercheMeilleurProduitCategorie;
import fr.diginamic.service.RechercheMeilleurProduitCategorieMarque;
import fr.diginamic.service.RechercheMeilleurProduitMarque;
import fr.diginamic.utils.CsvDataParser;
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
        List<Produit> produits = CsvDataParser.parse(file);

        Scanner scanner = new Scanner(System.in);
        Stock stock = new Stock(produits);

        MenuService service;

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
                    System.out.println("Au revoir !");
                    scanner.close();
                    return;
            }
        }
    }
}