package model.Herbivores;

import model.Animal;

public abstract class Herbivores extends Animal {
    public Herbivores(String name , float weight, int maxInCell, int maxStep, double needToSaturation, double saturation, int x, int y) {
        super(name ,weight, maxInCell, maxStep, needToSaturation, saturation, x, y);
    }

    public abstract boolean canEat(Object object);
    public abstract double chanceToEat(String foodName);
}
