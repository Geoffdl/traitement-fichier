package fr.diginamic;

import java.util.Scanner;

public class ApplicationOpenFoodFacts
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);


        while (true)
        {
//            MenuDisplay.display();
            System.out.println("\n1. Les meilleurs produits pour une marque donnée");
            System.out.println("2. Rechercher les meilleurs produits par Marque et par Catégorie ");
            System.out.println("3. Afficher les allergènes les plus courants avec le nb de produits dans lesquels ils apparaissent");
            System.out.println("4. Afficher les additifs les plus courants avec le nb de produits dans lesquels ils apparaissent");

            System.out.println("5. Quitter");

            System.out.print("\nVotre choix: ");
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