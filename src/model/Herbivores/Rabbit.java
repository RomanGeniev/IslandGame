package model.Herbivores;

import model.Animal;
import model.IslandInterface;
import model.Plants.Grass;

import java.util.ArrayList;

public class Rabbit extends Herbivores implements IslandInterface {

private final int idRabbits;
int x;
int y;
    private double saturation = 0.40d;

    public Rabbit(int idRabbits, double saturation, int x, int y,int numberInArray) {
        super("Кролик",2,150,2,0.45,saturation,idRabbits, x, y,numberInArray);
        this.idRabbits = idRabbits;
        this.saturation = saturation;
        this.x = x;
        this.y = y;
    }

    @Override
    public int getId() {
        return idRabbits;
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
    public String getName() {
        return "Кролик";
    }

    @Override
    public void setSaturation(double saturation) {
        this.saturation = saturation;
    }

    @Override
    public int getWeight() {
        return 2;
    }

    @Override
    public int getMaxInCell() {
        return 150;
    }

    @Override
    public int getMaxStep() {
        return 2;
    }

    @Override
    public double getNeedToSaturation() {
        return 0.45;
    }

    @Override
    public double getSaturation() {
        return saturation;
    }

    @Override
    public boolean canEat(Object object) {
        return object instanceof Grass;
    }
    public boolean saturationNow(){
        if(saturation == getNeedToSaturation()) {
            return false;
        }else {
            return true;
        }
    }

    @Override
    public void eatObject() {
//        for (int i = 0; i < islandModel.length; i++) {
//            for (int j = 0; j < islandModel[i].length; j++) {
//                for (int k = 0; k < islandModel[i][j].size(); k++) {
//                    if (islandModel[i][j].get(k) instanceof Rabbit ){
//                        Rabbit rabbit = (Rabbit) islandModel[i][j].get(k);
//                        for (int l = 0; l < islandModel[i][j].size(); l++) {
//                            if(rabbit.canEat(islandModel[i][j].get(l)) && rabbit.saturation < rabbit.getNeedToSaturation()){
//                                Plants plants = (Plants) islandModel[i][j].get(l);
//                                if(rabbit.saturation < rabbit.getNeedToSaturation()) {
//                                    rabbit.setSaturation(rabbit.getNeedToSaturation());
//                                    System.out.println( rabbit.getId() + " Кролик сыт" + rabbit.getX() + rabbit.getY());
//                                    plants.setCanEat(false);
//                                }
//                            }
//                        }
//                    }
//                }
//            }
//            System.out.println();
//
//        }
    }

    @Override
    public void move(ArrayList<Animal> animals) {

    }
}
