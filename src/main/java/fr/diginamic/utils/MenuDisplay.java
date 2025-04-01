package fr.diginamic.utils;

public class MenuDisplay
{
    public static void displayHomeMenu(){
        System.out.println("\n ============= OPEN FOOD FACTS INFO PRODUITS =============");
        System.out.println("\n1. Rechercher les meilleurs produits pour une marque donnée");
        System.out.println("2. Rechercher les meilleurs produits par par Catégorie ");
        System.out.println("3. Rechercher les meilleurs produits par Marque et par Catégorie ");
        System.out.println("4. Afficher les allergènes les plus courants avec le nb de produits dans lesquels ils apparaissent");
        System.out.println("5. Afficher les additifs les plus courants avec le nb de produits dans lesquels ils apparaissent");
        System.out.println("6. Quitter");
        System.out.print("\nVotre choix: ");
    }
}