package model.Herbivores;

import model.Plants.Grass;

public class Horse extends Herbivores{
    public Horse( int x, int y) {
        super("Horse", 400, 20, 4, 60, 60, x, y);
    }

    @Override
    public boolean canEat(Object object) {
        return object instanceof Grass;
    }

    @Override
    public double chanceToEat(String foodName) {
        return 0;
    }
}
