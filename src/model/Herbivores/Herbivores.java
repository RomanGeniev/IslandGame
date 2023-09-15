package model.Herbivores;

import model.Animal;
import model.IslandInterface;

public abstract class Herbivores extends Animal implements IslandInterface {
    public Herbivores(String name , int weight, int maxInCell, int maxStep, double needToSaturation, double saturation, int id, int x, int y,int numberInArray) {
        super(name ,weight, maxInCell, maxStep, needToSaturation, saturation,id, x, y,numberInArray);
    }

    public abstract boolean canEat(Object object);
}
