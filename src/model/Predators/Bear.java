package model.Predators;

import model.Herbivores.Herbivores;

public class Bear extends Predators{
    public Bear(int x, int y) {
        super("Bear", 500, 5,2, 80, 80, x, y);
    }

    @Override
    public boolean canEat(Object object) {
        return object instanceof Snake || object instanceof Herbivores;
    }

    @Override
    public double chanceToEat(String foodName) {
        return switch (foodName) {
            case "Snake","Deer","Rabbit" -> 0.8;
            case "Horse" -> 0.4;
            case "Mouse" -> 0.9;
            case "Goat","Sheep" -> 0.7;
            case "Boar" -> 0.5;
            case "Buffalo" -> 0.2;
            case "Duck" -> 0.1;
            default -> 0;
        };
    }
}
