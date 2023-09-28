package model.Predators;

import model.Herbivores.Herbivores;

public class Snake extends Predators {
    public Snake(int x, int y) {
        super("Snake", 15, 30, 1, 3, 2, x, y);
    }

    @Override
    public boolean canEat(Object object) {
        return object instanceof Herbivores || object instanceof Fox;//добавить когда будут все классы
    }

    @Override
    public double chanceToEat(String foodName) {
        return switch (foodName) {
            case "Mouse" -> 0.4;
            case "Duck" -> 0.1;
            case "Fox" -> 0.15;
            case "Rabbit" -> 0.2;
            default -> 0;
        };
    }
}
