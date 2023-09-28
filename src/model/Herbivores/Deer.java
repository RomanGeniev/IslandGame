package model.Herbivores;

import model.Plants.Plants;

public class Deer extends Herbivores{
    public Deer( int x, int y) {
        super("Deer", 300, 20, 4, 50, 50, x, y);
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
