package fr.diginamic.service;

import fr.diginamic.model.Additif;
import fr.diginamic.model.Produit;
import fr.diginamic.model.Stock;
import fr.diginamic.utils.InputValidator;

import java.util.*;

public class RechercheRecurrenceAdditifs extends MenuService
{

    /**
     * Affiche les N additifs les plus courants avec le nb de produits dans lesquels ils
     * apparaissent
     * @param stock
     * @param scanner
     */
    @Override
    public void traiter(Stock stock, Scanner scanner)
    {
        System.out.print("Veuillez saisir le nombre d'additifs à afficher : ");
        int limit = InputValidator.userInputInt(scanner);

        Map<Additif, Integer> additifCount = new HashMap();

        for (Produit produit : stock.getProduits())
        {
            for (Additif additif : produit.getAdditifs())
            {
                additifCount.merge(additif, 1, Integer::sum);
            }
        }

        List<Map.Entry<Additif, Integer>> sortedAdditifs = additifCount.entrySet()
                .stream()
                .sorted(Map.Entry.<Additif, Integer>comparingByValue().reversed())
                .limit(limit)
                .toList();

        System.out.printf("\nLes %d additifs les plus courants :\n", limit);
        for(Map.Entry<Additif, Integer> entry : sortedAdditifs) {
            System.out.printf("%s :\n\t %d produits\n", entry.getKey().getLibelle(), entry.getValue());
        }

        InputValidator.waitForEnter(scanner);
    }
}