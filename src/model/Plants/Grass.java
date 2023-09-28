package model.Plants;

import model.ActionInterfaces.Eating;

public class Grass extends Plants implements Eating {


    public Grass( int x, int y) {
        super(200, "Grass", 1, x, y);
    }

    @Override
    public boolean canEat(Object object) {
        return false;
    }
}
