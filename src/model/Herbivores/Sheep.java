package model.Herbivores;

import model.Plants.Plants;

public class Sheep extends Herbivores {
    public Sheep(int x, int y) {
        super("Sheep", 70, 140, 3,15, 15, x, y);
    }

    @Override
    public boolean canEat(Object object) {
        return object instanceof Plants;
    }

    @Override
    public double chanceToEat(String foodName) {
        return 0;
    }
}
