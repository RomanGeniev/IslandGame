package model;

import model.ActionInterfaces.Eating;
import model.ActionInterfaces.Moving;
import model.IslandSettings.IslandSize;

public abstract class Animal extends IslandSize implements IslandInterface, Eating, Moving {
    String name;
    int weight;
    int maxInCell;
    int maxStep;
    double needToSaturation;
    double saturation;
    int id;
    int x;
    int y;
    int numberInArray;



    public Animal(String name, int weight, int maxInCell, int maxStep, double needToSaturation, double saturation, int id,int x, int y,int numberInArray){
        this.name = name;
        this.weight = weight;
        this.maxInCell = maxInCell;
        this.maxStep = maxStep;
        this.needToSaturation = needToSaturation;
        this.saturation = saturation;
        this.id = id;
        this.numberInArray = numberInArray;
    }

    public int getNumberInArray() {
        return numberInArray;
    }

    public abstract int getId();
    public abstract int getX();
    public abstract void setX( int x);
    public abstract int getY();
    public abstract void setY( int y);
    public abstract boolean saturationNow();

    public abstract String getName();

    public abstract void setSaturation(double saturation);

    public abstract int getWeight();

    public abstract int getMaxInCell();

    public abstract int getMaxStep();

    public abstract double getNeedToSaturation();

    public abstract double getSaturation();
}
