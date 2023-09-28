package model.Predators;

import model.Animal;
import model.Herbivores.Herbivores;
import model.Herbivores.Rabbit;

import java.util.ArrayList;

public class Wolf extends Predators {

    public Wolf(int x, int y) {
        super("Wolf", 50, 30, 3, 8, 8, x, y);
    }

    @Override
    public boolean canEat(Object object) {
        return object instanceof Herbivores;// Add fox
    }

    @Override
    public double chanceToEat(String foodName) {
        return switch (foodName) {
            case "Horse", "Buffalo" -> 0.1;
            case "Deer", "WildBoar" -> 0.15;
            case "Duck" -> 0.4;
            case "Goat", "Rabbit" -> 0.6;
            case "Sheep" -> 0.7;
            case "Mouse" -> 0.8;
            default -> 0;
        };
    }
}

