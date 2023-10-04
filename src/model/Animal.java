package model;

import model.ActionInterfaces.Eating;
import model.Herbivores.Caterpillar;
import model.Herbivores.Herbivores;
import model.IslandSettings.IslandSize;
import model.Predators.Predators;
import model.Predators.Wolf;

public abstract class Animal extends IslandSize implements Eating {
    String name;
    float weight;
    int maxInCell;
    int maxStep;
    double needToSaturation;
    double saturation;
    int x;
    int y;
    boolean canMove = false;


    public Animal(String name, float weight, int maxInCell, int maxStep, double needToSaturation, double saturation, int x, int y) {
        this.name = name;
        this.weight = weight;
        this.maxInCell = maxInCell;
        this.maxStep = maxStep;
        this.needToSaturation = needToSaturation;
        this.saturation = saturation;
        this.x = x;
        this.y = y;
    }

    public void setCanMove(boolean canMove) {
        this.canMove = canMove;
    }

    public void reproduction(Object partner) {
        if (partner instanceof Animal) {
            for (int i = 0; i < islandModel[((Animal) partner).getX()][((Animal) partner).getY()].size(); i++) {
                if (partner instanceof Predators) {
                    if (partner instanceof Wolf) {
                        int countWolf = 0;
                        for (int j = 0; j < islandModel[((Wolf) partner).getX()][((Wolf) partner).getY()].size(); j++) {
                            countWolf++;
                        }
                        for (int j = 0; j < countWolf / 2; j++) {
                            islandModel[((Wolf) partner).getX()][((Wolf) partner).getY()].add(new Wolf( 1, 2));
                        }
                    }

                } else if (partner instanceof Herbivores) {

                }

            }
        }
    }

    public void hungry() {
        if (this.canMove && !(this instanceof Caterpillar)) {
            this.saturation = this.saturation - this.needToSaturation / 3;
            if (this.saturation <= 0) {
                islandModel[this.x][this.y].remove(this);
            }
        }
        this.canMove = false;
    }

    public int getX() {
        return this.x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return this.y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public boolean saturationNow() {
        if (saturation == getNeedToSaturation()) {
            return false;
        } else if (saturation < getNeedToSaturation()) {
            return true;
        } else {
            return false;
        }
    }

    public String getName() {
        return name;
    }

    public void setSaturation(double saturation) {
        if (saturation > getNeedToSaturation()) {
            this.saturation = getNeedToSaturation();
        } else if (saturation < getNeedToSaturation()) {
            this.saturation = saturation;
        }
    }

    public float getWeight() {
        return weight;
    }

    public int getMaxInCell() {
        return maxInCell;
    }

    public int getMaxStep() {
        return maxStep;
    }

    public double getNeedToSaturation() {
        return needToSaturation;
    }

    public double getSaturation() {
        return saturation;
    }
}
