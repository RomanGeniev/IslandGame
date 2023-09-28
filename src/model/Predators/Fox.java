package model.Predators;

import model.Herbivores.Herbivores;

public class Fox extends Predators {
    public Fox(int x, int y) {
        super("Fox", 8, 30, 2, 2, 2, x, y);
    }

    @Override
    public boolean canEat(Object object) {
        return object instanceof Herbivores;
    }

    @Override
    public double chanceToEat(String foodName) {
        return switch (foodName) {
            case "Mouse" -> 0.9;
            case "Duck" -> 0.6;
            case "Rabbit" -> 0.7;
            case "Caterpillar" -> 0.4;
            default -> 0;
        };
    }
}
