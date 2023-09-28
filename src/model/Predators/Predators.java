package model.Predators;

import model.Animal;

public abstract class Predators extends Animal {
    public Predators(String name , float weight, int maxInCell, int maxStep, double needToSaturation, double saturation, int x, int y) {
        super(name,weight, maxInCell, maxStep, needToSaturation, saturation,x,y);
    }


    //public abstract int GetWeight();
    public abstract double chanceToEat(String foodName);

}
