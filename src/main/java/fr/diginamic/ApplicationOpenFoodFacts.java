package fr.diginamic;

import fr.diginamic.model.Produit;
import fr.diginamic.model.Stock;
import fr.diginamic.service.CsvDataParser;
import fr.diginamic.utils.MenuDisplay;
import org.apache.commons.io.FileUtils;

import java.io.File;
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

//        File file = new File("src/main/resources/open-food-facts.csv");
//        List<String> produits = FileUtils.readLines(file, "UTF-8");

        Scanner scanner = new Scanner(System.in);
        Stock stock = new Stock(produits);

        System.out.println(stock);


        while (true)
        {
            MenuDisplay.displayHomeMenu();

            int choix = scanner.nextInt();

            switch (choix)
            {
//                case 1:
//                    service = new RecherchePopulationVille();
//                    service.traiter(recensement, scanner);
//                    break;
//                case 2:
//                    ....

                case 5:
                    System.out.println("Au revoir !");
                    scanner.close();
                    return;
            }
        }
    }
}