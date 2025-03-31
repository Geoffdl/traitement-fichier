package fr.diginamic.model;

import java.util.ArrayList;
import java.util.List;

public class Stock
{
    private List<Produit> produits;

    public Stock(List<Produit> produits){
        this.produits = produits;
    }

    public List<Produit> getProduits()
    {
        return produits;
    }

    @Override
    public String toString()
    {
        final StringBuilder sb = new StringBuilder("Stock{");
        sb.append("\nproduits=").append(produits);
        sb.append('}');
        return sb.toString();
    }
}