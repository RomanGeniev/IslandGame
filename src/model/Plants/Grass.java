package model.Plants;

import model.ActionInterfaces.Eating;
import model.IslandInterface;
import model.IslandSettings.IslandSize;

public class Grass extends Plants implements IslandInterface, Eating {


    public Grass(int id, int x, int y) {
        super(200, "Трава", 1, id, x, y);
    }

    @Override
    public boolean canEat(Object object) {
        return false;
    }
}
