package model.Predators;

import model.Animal;

public abstract class Predators extends Animal {
    public Predators(String name , int weight, int maxInCell, int maxStep, double needToSaturation, double saturation, int id, int x, int y,int numberInArray) {
        super(name,weight, maxInCell, maxStep, needToSaturation, saturation, id,x,y,numberInArray);
    }


    //public abstract int GetWeight();
    public abstract double chanceToEat(String foodName);

}
