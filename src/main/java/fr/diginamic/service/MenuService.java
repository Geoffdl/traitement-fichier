package fr.diginamic.service;

import fr.diginamic.model.Stock;

import java.util.Scanner;

public abstract class MenuService
{


    public abstract void traiter(Stock stock, Scanner scanner);

}