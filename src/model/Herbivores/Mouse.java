package model.Herbivores;

import model.Plants.Grass;

public class Mouse extends Herbivores{ // сделать чтобы ела гусеницу
    public Mouse(int x, int y) {
        super("Mouse", 0.05F, 500, 1, 0.01, 0.01, x, y);
    }

    @Override
    public boolean canEat(Object object) {
        return object instanceof Grass;
    }

    @Override
    public double chanceToEat(String foodName) {
        return switch (foodName) {
            case "Grass" -> 1.0;
            case "Caterpillar" -> 0.9;
            default -> 0;
        };
    }
}
