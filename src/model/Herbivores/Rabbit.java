package model.Herbivores;

import model.Plants.Plants;


public class Rabbit extends Herbivores {

    public Rabbit(int x, int y) {
        super("Rabbit", 2, 150, 2, 0.45, 0.40, x, y);
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
