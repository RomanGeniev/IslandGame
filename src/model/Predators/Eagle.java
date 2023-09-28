package model.Predators;

import model.Herbivores.Herbivores;

public class Eagle extends Predators{
    public Eagle(int x, int y) {
        super("Eagle", 6, 20, 3, 1, 1, x, y);
    }

    @Override
    public boolean canEat(Object object) {
        return object instanceof Fox || object instanceof Herbivores;
    }

    @Override
    public double chanceToEat(String foodName) {
        return switch (foodName) {
            case "Duck" -> 0.8;
            case "Rabbit", " Mouse" -> 0.9;
            default -> 0;
        };
    }
}
