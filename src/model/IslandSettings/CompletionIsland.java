package model.IslandSettings;

import model.Animal;
import model.Herbivores.Herbivores;
import model.Herbivores.Rabbit;
import model.Plants.Grass;
import model.Predators.Predators;
import model.Predators.Wolf;

import java.util.ArrayList;
import java.util.Random;

import static model.IslandSettings.IslandSize.islandModel;

public class CompletionIsland {
    public static ArrayList<Animal> allAnimals = new ArrayList<>();
    public static ArrayList<Grass> allPlants = new ArrayList<>();
    public static int count;

    public static void getAllAnimals() {//Работает
        for (int i = 0; i < islandModel.length; i++) {
            for (int j = 0; j < islandModel[i].length; j++) {
                for (int k = 0; k < islandModel[i][j].size(); k++) {
                    if (islandModel[i][j].get(k) instanceof Animal) {
                        allAnimals.add((Animal) islandModel[i][j].get(k));
                    }
                }
            }
        }
    }

    public static void getAllPlants() {
        for (int i = 0; i < islandModel.length; i++) {
            for (int j = 0; j < islandModel[i].length; j++) {
                for (int k = 0; k < islandModel[i][j].size(); k++) {
                    if (islandModel[i][j].get(k) instanceof Grass) {
                        allPlants.add((Grass) islandModel[i][j].get(k));
                    }
                }
            }
        }
    }

    public static void startEat(Object object) {
        if (object instanceof Predators) {
            if (object instanceof Wolf) {
                for (int i = 0; i < islandModel[((Wolf) object).getX()][((Wolf) object).getY()].size(); i++) {
                    if (((Wolf) object).canEat(islandModel[((Wolf) object).getX()][((Wolf) object).getY()].get(i)) && ((Wolf) object).saturationNow()) {
                        Herbivores rabbit = (Herbivores) islandModel[((Wolf) object).getX()][((Wolf) object).getY()].get(i);
                        if (new Random().nextFloat(1.0f) < ((Wolf) object).chanceToEat(rabbit.getName())) {
                            ((Wolf) object).setSaturation((rabbit.getWeight() + ((Wolf) object).getSaturation()));
                            islandModel[rabbit.getX()][rabbit.getY()].remove(rabbit);
                            break;
                        }else {
                            break;
                        }
                    }
                }
            }
        }
    }

    public static void AddInField(int MAX_IN_ONE_CELL, String type) throws NullPointerException {
        switch (type) {
            case "Волк":
                int id = 0;
                for (int i = 0; i < islandModel.length; i++) {
                    for (int j = 0; j < islandModel[i].length; j++) {
                        int n = new Random().nextInt(MAX_IN_ONE_CELL);
                        for (int k = 0; k < n + 1; k++) {
                            islandModel[i][j].add(new Wolf(id, 7, i, j, n));
                            id++;
                        }
                    }
                    System.out.println(" ");
                }
                break;

            case "Травка":
                int idPlants = 0;
                for (int i = 0; i < islandModel.length; i++) {
                    for (int j = 0; j < islandModel[i].length; j++) {
                        int n = new Random().nextInt(MAX_IN_ONE_CELL);
                        for (int k = 0; k < n + 1; k++) {
                            islandModel[i][j].add(new Grass(idPlants, i, j));
                            idPlants++;
                        }
                    }
                    System.out.println("");
                }
                break;

            case "Кролик": {
                int idRabbits = 0;
                for (int i = 0; i < islandModel.length; i++) {
                    for (int j = 0; j < islandModel[i].length; j++) {
                        int n = new Random().nextInt(MAX_IN_ONE_CELL);
                        for (int k = 0; k < n + 1; k++) {
                            islandModel[i][j].add(new Rabbit(idRabbits, 0.45, i, j, n));
                            idRabbits++;
                        }
                    }
                    System.out.println("");
                }
                break;

            }
        }
    }

    public static void move(Object object) {
        if (object instanceof Animal) {
            //System.out.println("Новый объект");
            int oldX = ((Animal) object).getX();
            int oldY = ((Animal) object).getY();
            //System.out.println(oldX +" " + oldY);
            for (int i = 0; i < ((Animal) object).getMaxStep(); i++) {
                if(new Random().nextInt(0,2) == 0){//Передвижение x
                    if (new Random().nextInt(0,2) == 0){// -x
                        if(((Animal) object).getX() - 1 < 0){
                            ((Animal) object).setX(((Animal) object).getX() + 1);
                        }else {
                            ((Animal) object).setX(((Animal) object).getX() - 1);
                        }

                    }else {// +x
                        if(((Animal) object).getX() + 1 > 4){
                            ((Animal) object).setX(((Animal) object).getX() - 1);
                        }else {
                            ((Animal) object).setX(((Animal) object).getX() + 1);
                        }
                    }

                }else {//передвижение по y
                    if (new Random().nextInt(0,2) == 0){//Передвижение по -y
                        if(((Animal) object).getY() - 1 < 0){
                            ((Animal) object).setY(((Animal) object).getY() + 1);
                        }else {
                            ((Animal) object).setY(((Animal) object).getY() - 1);
                        }

                    }else {// +y
                        if(((Animal) object).getY() + 1 > 4){
                            ((Animal) object).setY(((Animal) object).getY() - 1);
                        }else {
                            ((Animal) object).setY(((Animal) object).getY() + 1);
                        }
                    }

                }
            }
            islandModel[oldX][oldY].remove(object);
            islandModel[((Animal) object).getX()][((Animal) object).getY()].add(object);
        }
    }
}





