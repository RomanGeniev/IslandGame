package model.Herbivores;

import model.GrassGrowth;
import model.Plants.Grass;
import model.Plants.Plants;

public class Goat extends Herbivores{
    public Goat(int x, int y) {
        super("Goat", 60, 140, 3, 10, 10, x, y);
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
