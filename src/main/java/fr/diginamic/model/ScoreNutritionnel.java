package fr.diginamic.model;

public enum ScoreNutritionnel
{

    A("a"),
    B("b"),
    C("c"),
    D("d"),
    E("e"),
    F("f");

    private final String label;

    ScoreNutritionnel(String label)
    {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }


    public static ScoreNutritionnel fromLabel(String label) {
        if (label == null || label.trim().isEmpty()) {
            throw new IllegalArgumentException("Score nutritionnel cannot be null or empty");
        }

        String cleanLabel = label.trim().toLowerCase();

        for (ScoreNutritionnel score : values()) {
            if (score.label.equals(cleanLabel)) {
                return score;
            }
        }
        throw new IllegalArgumentException("Unknown score nutritionnel: " + label);
    }


}