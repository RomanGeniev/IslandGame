package model.Predators;

import model.Animal;
import model.Herbivores.Herbivores;
import model.Herbivores.Rabbit;

import java.util.ArrayList;

public class Wolf extends Predators {
    int x;
    int y;
    private int idWolf;
    private double saturation;

    @Override
    public int getId() {
        return idWolf;
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public void setX(int x) {
        this.x = x;
    }

    @Override
    public int getY() {
        return y;
    }

    @Override
    public void setY(int y) {
        this.y = y;
    }

    @Override
    public boolean saturationNow() {
        if (saturation == getNeedToSaturation()) {
            return false;
        } else if (saturation < getNeedToSaturation()) {
            return true;
        }else {
            return false;
        }
    }

    public String getName() {
        return "Волк";
    }

    public Wolf(int idWolf,double saturation, int x, int y, int numberInArray) {
        super("Волк",50,30,3,8,saturation,idWolf, x, y,numberInArray);
        this.idWolf = idWolf;
        this.saturation = saturation;
        this.x = x;
        this.y = y;
    }

    @Override
    public void setSaturation(double saturation) {
        if (saturation > getNeedToSaturation()){
            this.saturation = getNeedToSaturation();
        }else if (saturation < getNeedToSaturation()){
            this.saturation = saturation;
        }
    }

    @Override
    public int getWeight() {
        return 50;
    }

    @Override
    public int getMaxInCell() {
        return 30;
    }

    @Override
    public int getMaxStep() {
        return 3;
    }

    @Override
    public double getNeedToSaturation() {
        return 8;
    }

    @Override
    public double getSaturation() {
        return this.saturation;
    }

    @Override
    public boolean canEat(Object object) {
        return object instanceof Rabbit;
    }

    @Override
    public void eatObject() {
//        for (int i = 0; i < islandModel.length; i++) {
//            for (int j = 0; j < islandModel[i].length; j++) {
//                for (int k = 0; k < islandModel[i][j].size(); k++) {
//                    if (islandModel[i][j].get(k) instanceof Predators){
//                        Predators animal = (Predators) islandModel[i][j].get(k);
//                        for (int l = 0; l < islandModel[i][j].size(); l++) {
//                            if(animal.canEat(islandModel[i][j].get(l)) && animal.saturationNow()){
//                                Animal animal1 = (Animal) islandModel[i][j].get(l);
//                                if(animal.saturationNow()) {
//                                    animal.setSaturation(animal1.getWeight());
//                                    islandModel[i][j].remove(l);
//                                    break;
//                                    //System.out.println( "Он : " + animal.getName() + "Сьел: " + animal1.getName());
//                                }
//                            }
//                        }
//                    }
//                }
//            }
//        }
    }

    @Override
    public void move(ArrayList<Animal> animals) {

    }

    @Override
    public double chanceToEat(String foodName) {
        return switch (foodName) {
            case "Horse", "Buffalo" -> 0.1;
            case "Deer", "WildBoar" -> 0.15;
            case "Duck" -> 0.4;
            case "Goat", "Кролик" -> 0.6;
            case "Sheep" -> 0.7;
            case "Mouse" -> 0.8;
            default -> 0;
        };
    }
}

