package model.Herbivores;

import model.Plants.Plants;

public class Boar extends Herbivores { // Сделать чтобы ел мышь и гусеницу
    public Boar(int x, int y) {
        super("Boar", 400, 50, 2, 50, 50, x, y);
    }

    @Override
    public boolean canEat(Object object) {
        return  object instanceof Plants;// Добавить гусеницу и мышь
    }

    @Override
    public double chanceToEat(String foodName) {
        return switch (foodName) {
            case "Mouse" -> 0.5;
            case "Caterpillar" -> 0.9;
            case " Grass" -> 1.0;
            default -> 0;
        };
    }
}
