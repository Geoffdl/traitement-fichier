package fr.diginamic.utils;

import java.util.Scanner;

public class InputValidator
{
    public static int userInputInt(Scanner sc)
    {
        while (true)
        {
            try
            {
                return Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e)
            {
                System.out.println("Veuillez entrer un nombre valide.");
            }
        }

    }

    public static String userInputString(Scanner sc)
    {
        while (true)
        {
            String input = sc.nextLine().trim();
            if (!input.isEmpty())
            {
                return input;
            } else
            {
                System.out.println("Veuillez entrer une chaîne de caractères non vide.");
            }
        }
    }

    public static void waitForEnter(Scanner sc){
        System.out.println("\nAppuyez sur Entrée pour continuer...");
        sc.nextLine();
    }
}