package model.Herbivores;

import model.IslandInterface;
import model.Plants.Plants;


public class Rabbit extends Herbivores implements IslandInterface {

    public Rabbit(int idRabbits, int x, int y) {
        super("Кролик", 2, 150, 2, 0.45, 0.45, idRabbits, x, y);
    }

    @Override
    public boolean canEat(Object object) {
        return object instanceof Plants;
    }


}
