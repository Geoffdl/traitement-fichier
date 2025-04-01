package fr.diginamic.utils;

import java.util.Arrays;
import java.util.stream.Collectors;

public class StringCleaner
{
    public static String cleanMyString(String dirtyString) {

        // Split on spaces, commas, colons and hyphens
        String[] tokens = dirtyString.split("\\s+|,\\s*|-\\s*|:\\s*");

        // Filter out empty strings and common words
        return Arrays.stream(tokens)
                .map(String::trim)
                .filter(s -> !s.isEmpty())
                .filter(s -> !s.equalsIgnoreCase("de"))
                .filter(s -> !s.equalsIgnoreCase("et"))
                .filter(s -> !s.equalsIgnoreCase("d"))
                .filter(s -> !s.equalsIgnoreCase("des"))
                .filter(s -> !s.equalsIgnoreCase("du"))
                .filter(s -> !s.equalsIgnoreCase("le"))
                .filter(s -> !s.equalsIgnoreCase("la"))
                .filter(s -> !s.equalsIgnoreCase("les"))
                .filter(s -> !s.equalsIgnoreCase("en"))
                .collect(Collectors.joining(" "));
    }
}