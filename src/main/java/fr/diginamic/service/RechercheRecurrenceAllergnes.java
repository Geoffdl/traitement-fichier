package fr.diginamic.service;

import fr.diginamic.model.Allergene;
import fr.diginamic.model.Produit;
import fr.diginamic.model.Stock;
import fr.diginamic.utils.InputValidator;
import fr.diginamic.utils.ParserProduitParams;

import java.util.*;
import java.util.stream.Collectors;

public class RechercheRecurrenceAllergnes extends MenuService
{

    /**
     * Affiche les N additifs les plus courants avec le nb de produits dans lesquels ils
     * apparaissent
     */
    @Override
    public void traiter(Stock stock, Scanner scanner)
    {
        System.out.print("Veuillez saisir le nombre d'additifs à afficher : ");
        int limit = InputValidator.userInputInt(scanner);

        Map<Allergene, Integer> additifCount = new HashMap();

        for (Produit produit : stock.getProduits())
        {
            for (Allergene additif : produit.getAllergenes())
            {
                additifCount.merge(additif, 1, Integer::sum);
            }
        }

        List<Map.Entry<Allergene, Integer>> sortedAdditifs = additifCount.entrySet()
                .stream()
                .sorted(Map.Entry.<Allergene, Integer>comparingByValue().reversed())
                .limit(limit)
                .toList();

        System.out.printf("\nLes %d allergenes les plus courants :\n", limit);
        for(Map.Entry<Allergene, Integer> entry : sortedAdditifs) {
            System.out.printf("%s :\n\t %d produits\n", entry.getKey().getLibelle(), entry.getValue());
        }

        InputValidator.waitForEnter(scanner);
    }
}