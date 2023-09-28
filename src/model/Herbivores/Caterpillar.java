package model.Herbivores;

public class Caterpillar extends Herbivores{
    public Caterpillar(int x, int y) {
        super("Caterpillar", 0.01F, 1000, 0, 0, 1, x, y);
    }

    @Override
    public boolean canEat(Object object) {
        return false;
    }

    @Override
    public double chanceToEat(String foodName) {
        return 0;
    }
}
