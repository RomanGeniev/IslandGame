package model.Herbivores;

import model.Plants.Plants;

public class Duck extends Herbivores {
    public Duck(int x, int y) {
        super("Duck", 1, 200, 4, 0.15, 0.15, x, y);
    }

    @Override
    public boolean canEat(Object object) {//Сделать чтобы ела гусеницу
        return object instanceof Plants;
    }

    @Override
    public double chanceToEat(String foodName) {
        return switch (foodName) {
            case "Caterpillar" -> 0.9;
            case " Grass" -> 1.0;
            default -> 0;
        };
    }
}
