package model.Herbivores;

import model.Plants.Plants;

public class Buffalo extends Herbivores{
    public Buffalo(int x, int y) {
        super("Buffalo", 700, 10, 3, 100, 100, x, y);
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
