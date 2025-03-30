package fr.diginamic;

import fr.diginamic.utils.MenuDisplay;

import java.util.Scanner;

public class ApplicationOpenFoodFacts
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);


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