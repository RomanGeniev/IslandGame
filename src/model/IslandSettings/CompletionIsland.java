package model.IslandSettings;

import model.Animal;
import model.Herbivores.*;
import model.Plants.Grass;
import model.Plants.Plants;
import model.Predators.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import static model.IslandSettings.IslandSize.islandModel;

public class CompletionIsland {

    public static ArrayList<Animal> allAnimals = new ArrayList<>();
    public static ArrayList<Grass> allPlants = new ArrayList<>();

    public static int count;

    public synchronized static void getAllAnimals() {
        allAnimals.clear();
        for (int i = 0; i < islandModel.length; i++) {
            for (int j = 0; j < islandModel[i].length; j++) {
                for (int k = 0; k < islandModel[i][j].size(); k++) {
                    if (islandModel[i][j].get(k) instanceof Animal) {
                        allAnimals.add((Animal) islandModel[i][j].get(k));
                        ((Animal) islandModel[i][j].get(k)).setCanMove(true);
                    }
                }
            }
        }
    }

    public synchronized static void getAllPlants() {
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
                            CompletionIsland.allAnimals.remove(rabbit);
                            break;
                        } else {
                            break;
                        }
                    }
                }
            } else if (object instanceof Snake) {
                for (int i = 0; i < islandModel[((Snake) object).getX()][((Snake) object).getY()].size(); i++) {
                    if (((Snake) object).canEat(islandModel[((Snake) object).getX()][((Snake) object).getY()].get(i)) && ((Snake) object).saturationNow()) {
                        Animal rabbit = (Animal) islandModel[((Snake) object).getX()][((Snake) object).getY()].get(i);
                        if (new Random().nextFloat(1.0f) < ((Snake) object).chanceToEat(rabbit.getName())) {
                            ((Snake) object).setSaturation((rabbit.getWeight() + ((Snake) object).getSaturation()));
                            islandModel[rabbit.getX()][rabbit.getY()].remove(rabbit);
                            CompletionIsland.allAnimals.remove(rabbit);
                            break;
                        } else {
                            break;
                        }
                    }
                }
            } else if (object instanceof Fox) {
                for (int i = 0; i < islandModel[((Fox) object).getX()][((Fox) object).getY()].size(); i++) {
                    if (((Fox) object).canEat(islandModel[((Fox) object).getX()][((Fox) object).getY()].get(i)) && ((Fox) object).saturationNow()) {
                        Animal rabbit = (Animal) islandModel[((Fox) object).getX()][((Fox) object).getY()].get(i);
                        if (new Random().nextFloat(1.0f) < ((Fox) object).chanceToEat(rabbit.getName())) {
                            ((Fox) object).setSaturation((rabbit.getWeight() + ((Fox) object).getSaturation()));
                            islandModel[rabbit.getX()][rabbit.getY()].remove(rabbit);
                            CompletionIsland.allAnimals.remove(rabbit);
                            break;
                        } else {
                            break;
                        }
                    }
                }
            } else if (object instanceof Bear) {
                for (int i = 0; i < islandModel[((Bear) object).getX()][((Bear) object).getY()].size(); i++) {
                    if (((Bear) object).canEat(islandModel[((Bear) object).getX()][((Bear) object).getY()].get(i)) && ((Bear) object).saturationNow()) {
                        Animal rabbit = (Animal) islandModel[((Bear) object).getX()][((Bear) object).getY()].get(i);
                        if (new Random().nextFloat(1.0f) < ((Bear) object).chanceToEat(rabbit.getName())) {
                            ((Bear) object).setSaturation((rabbit.getWeight() + ((Bear) object).getSaturation()));
                            islandModel[rabbit.getX()][rabbit.getY()].remove(rabbit);
                            CompletionIsland.allAnimals.remove(rabbit);
                            break;
                        } else {
                            break;
                        }
                    }
                }
            } else if (object instanceof Eagle) {
                for (int i = 0; i < islandModel[((Eagle) object).getX()][((Eagle) object).getY()].size(); i++) {
                    if (((Eagle) object).canEat(islandModel[((Eagle) object).getX()][((Eagle) object).getY()].get(i)) && ((Eagle) object).saturationNow()) {
                        Animal rabbit = (Animal) islandModel[((Eagle) object).getX()][((Eagle) object).getY()].get(i);
                        if (new Random().nextFloat(1.0f) < ((Eagle) object).chanceToEat(rabbit.getName())) {
                            ((Eagle) object).setSaturation((rabbit.getWeight() + ((Eagle) object).getSaturation()));
                            islandModel[rabbit.getX()][rabbit.getY()].remove(rabbit);
                            CompletionIsland.allAnimals.remove(rabbit);
                            break;
                        } else {
                            break;
                        }
                    }
                }
            }
        } else if (object instanceof Herbivores) {
            if (object instanceof Rabbit) {
                for (int i = 0; i < islandModel[((Rabbit) object).getX()][((Rabbit) object).getY()].size(); i++) {
                    if (((Rabbit) object).canEat(islandModel[((Rabbit) object).getX()][((Rabbit) object).getY()].get(i)) && ((Rabbit) object).saturationNow()) {
                        Plants plants = (Plants) islandModel[((Rabbit) object).getX()][((Rabbit) object).getY()].get(i);
                        if (plants.isCanEat()) {
                            ((Rabbit) object).setSaturation((plants.getWEIGHT() + ((Rabbit) object).getSaturation()));
                            plants.setCanEat(false);
                            break;
                        }
                    }
                }
            }else if (object instanceof Horse) {
                for (int i = 0; i < islandModel[((Horse) object).getX()][((Horse) object).getY()].size(); i++) {
                    if (((Horse) object).canEat(islandModel[((Horse) object).getX()][((Horse) object).getY()].get(i)) && ((Horse) object).saturationNow()) {
                        Plants plants = (Plants) islandModel[((Horse) object).getX()][((Horse) object).getY()].get(i);
                        if (plants.isCanEat()) {
                            ((Horse) object).setSaturation((plants.getWEIGHT() + ((Horse) object).getSaturation()));
                            plants.setCanEat(false);
                            break;
                        }
                    }
                }
            }else if (object instanceof Deer) {
                for (int i = 0; i < islandModel[((Deer) object).getX()][((Deer) object).getY()].size(); i++) {
                    if (((Deer) object).canEat(islandModel[((Deer) object).getX()][((Deer) object).getY()].get(i)) && ((Deer) object).saturationNow()) {
                        Plants plants = (Plants) islandModel[((Deer) object).getX()][((Deer) object).getY()].get(i);
                        if (plants.isCanEat()) {
                            ((Deer) object).setSaturation((plants.getWEIGHT() + ((Deer) object).getSaturation()));
                            plants.setCanEat(false);
                            break;
                        }
                    }
                }
            }else if (object instanceof Mouse) {
                for (int i = 0; i < islandModel[((Mouse) object).getX()][((Mouse) object).getY()].size(); i++) {
                    if (((Mouse) object).canEat(islandModel[((Mouse) object).getX()][((Mouse) object).getY()].get(i)) && ((Mouse) object).saturationNow()) {
                        //Добавить чтобы ела гусеницу
                        Plants plants = (Plants) islandModel[((Mouse) object).getX()][((Mouse) object).getY()].get(i);



                        if (plants.isCanEat()) {
                            ((Mouse) object).setSaturation((plants.getWEIGHT() + ((Mouse) object).getSaturation()));
                            plants.setCanEat(false);
                            break;
                        }
                    }
                }
            } else if (object instanceof Goat) {
                for (int i = 0; i < islandModel[((Goat) object).getX()][((Goat) object).getY()].size(); i++) {
                    if (((Goat) object).canEat(islandModel[((Goat) object).getX()][((Goat) object).getY()].get(i)) && ((Goat) object).saturationNow()) {
                        Plants plants = (Plants) islandModel[((Goat) object).getX()][((Goat) object).getY()].get(i);
                        if (plants.isCanEat()) {
                            ((Goat) object).setSaturation((plants.getWEIGHT() + ((Goat) object).getSaturation()));
                            plants.setCanEat(false);
                            break;
                        }
                    }
                }
            }
            else if (object instanceof Sheep) {
                for (int i = 0; i < islandModel[((Sheep) object).getX()][((Sheep) object).getY()].size(); i++) {
                    if (((Sheep) object).canEat(islandModel[((Sheep) object).getX()][((Sheep) object).getY()].get(i)) && ((Sheep) object).saturationNow()) {
                        Plants plants = (Plants) islandModel[((Sheep) object).getX()][((Sheep) object).getY()].get(i);
                        if (plants.isCanEat()) {
                            ((Sheep) object).setSaturation((plants.getWEIGHT() + ((Sheep) object).getSaturation()));
                            plants.setCanEat(false);
                            break;
                        }
                    }
                }
            } else if (object instanceof Boar) {// Сделать чтобы ел гусеницу и мышь
                for (int i = 0; i < islandModel[((Boar) object).getX()][((Boar) object).getY()].size(); i++) {
                    if (((Boar) object).canEat(islandModel[((Boar) object).getX()][((Boar) object).getY()].get(i)) && ((Boar) object).saturationNow()) {
                        Plants plants = (Plants) islandModel[((Boar) object).getX()][((Boar) object).getY()].get(i);
                        if (plants.isCanEat()) {
                            ((Boar) object).setSaturation((plants.getWEIGHT() + ((Boar) object).getSaturation()));
                            plants.setCanEat(false);
                            break;
                        }
                    }
                }
            } else if (object instanceof Buffalo) {
                for (int i = 0; i < islandModel[((Buffalo) object).getX()][((Buffalo) object).getY()].size(); i++) {
                    if (((Buffalo) object).canEat(islandModel[((Buffalo) object).getX()][((Buffalo) object).getY()].get(i)) && ((Buffalo) object).saturationNow()) {
                        Plants plants = (Plants) islandModel[((Buffalo) object).getX()][((Buffalo) object).getY()].get(i);
                        if (plants.isCanEat()) {
                            ((Buffalo) object).setSaturation((plants.getWEIGHT() + ((Buffalo) object).getSaturation()));
                            plants.setCanEat(false);
                            break;
                        }
                    }
                }
            } else if (object instanceof Duck) {
                for (int i = 0; i < islandModel[((Duck) object).getX()][((Duck) object).getY()].size(); i++) {
                    if (((Duck) object).canEat(islandModel[((Duck) object).getX()][((Duck) object).getY()].get(i)) && ((Duck) object).saturationNow()) {
                        Plants plants = (Plants) islandModel[((Duck) object).getX()][((Duck) object).getY()].get(i);
                        if (plants.isCanEat()) {
                            ((Duck) object).setSaturation((plants.getWEIGHT() + ((Duck) object).getSaturation()));
                            plants.setCanEat(false);
                            break;
                        }
                    }
                }
            } else if (object instanceof Caterpillar) {
                for (int i = 0; i < islandModel[((Caterpillar) object).getX()][((Caterpillar) object).getY()].size(); i++) {
                    if (((Caterpillar) object).canEat(islandModel[((Caterpillar) object).getX()][((Caterpillar) object).getY()].get(i))) {
                        Plants plants = (Plants) islandModel[((Caterpillar) object).getX()][((Caterpillar) object).getY()].get(i);
                        if (plants.isCanEat()) {
                            ((Caterpillar) object).setSaturation((plants.getWEIGHT() + ((Caterpillar) object).getSaturation()));
                            plants.setCanEat(false);
                            break;
                        }
                    }
                }
            }
        }
    }

    public static void AddInField(String type) throws NullPointerException {
        switch (type) {
            case "Wolf": {
                for (int i = 0; i < islandModel.length; i++) {
                    for (int j = 0; j < islandModel[i].length; j++) {
                        int n = new Random().nextInt(30);
                        for (int k = 0; k < n + 1; k++) {
                            islandModel[i][j].add(new Wolf(i, j));
                        }
                    }
                }
                break;
            }

            case "Grass": {
                for (int i = 0; i < islandModel.length; i++) {
                    for (int j = 0; j < islandModel[i].length; j++) {
                        int n = new Random().nextInt(200);
                        for (int k = 0; k < n + 1; k++) {
                            islandModel[i][j].add(new Grass(i, j));
                        }
                    }
                }
                break;
            }

            case "Rabbit": {
                for (int i = 0; i < islandModel.length; i++) {
                    for (int j = 0; j < islandModel[i].length; j++) {
                        int n = new Random().nextInt(150);
                        for (int k = 0; k < n + 1; k++) {
                            islandModel[i][j].add(new Rabbit(i, j));
                        }
                    }
                }
                break;
            }


            case "Snake": {
                for (int i = 0; i < islandModel.length; i++) {
                    for (int j = 0; j < islandModel[i].length; j++) {
                        int n = new Random().nextInt(30);
                        for (int k = 0; k < n + 1; k++) {
                            islandModel[i][j].add(new Snake(i, j));
                        }
                    }
                }
                break;
            }

            case "Fox": {
                for (int i = 0; i < islandModel.length; i++) {
                    for (int j = 0; j < islandModel[i].length; j++) {
                        int n = new Random().nextInt(30);
                        for (int k = 0; k < n + 1; k++) {
                            islandModel[i][j].add(new Fox(i, j));
                        }
                    }
                }
                break;
            }
            case "Bear": {
                for (int i = 0; i < islandModel.length; i++) {
                    for (int j = 0; j < islandModel[i].length; j++) {
                        int n = new Random().nextInt(5);
                        for (int k = 0; k < n + 1; k++) {
                            islandModel[i][j].add(new Bear(i, j));
                        }
                    }
                }
                break;
            }
            case "Eagle": {
                for (int i = 0; i < islandModel.length; i++) {
                    for (int j = 0; j < islandModel[i].length; j++) {
                        int n = new Random().nextInt(20);
                        for (int k = 0; k < n + 1; k++) {
                            islandModel[i][j].add(new Eagle(i, j));
                        }
                    }
                }
                break;
            }
            case "Horse": {
                for (int i = 0; i < islandModel.length; i++) {
                    for (int j = 0; j < islandModel[i].length; j++) {
                        int n = new Random().nextInt(20);
                        for (int k = 0; k < n + 1; k++) {
                            islandModel[i][j].add(new Horse(i, j));
                        }
                    }
                }
                break;
            }
            case "Deer": {
                for (int i = 0; i < islandModel.length; i++) {
                    for (int j = 0; j < islandModel[i].length; j++) {
                        int n = new Random().nextInt(20);
                        for (int k = 0; k < n + 1; k++) {
                            islandModel[i][j].add(new Deer(i, j));
                        }
                    }
                }
                break;
            }
            case "Mouse": {
                for (int i = 0; i < islandModel.length; i++) {
                    for (int j = 0; j < islandModel[i].length; j++) {
                        int n = new Random().nextInt(500);
                        for (int k = 0; k < n + 1; k++) {
                            islandModel[i][j].add(new Mouse(i, j));
                        }
                    }
                }
                break;
            }
            case "Goat": {
                for (int i = 0; i < islandModel.length; i++) {
                    for (int j = 0; j < islandModel[i].length; j++) {
                        int n = new Random().nextInt(140);
                        for (int k = 0; k < n + 1; k++) {
                            islandModel[i][j].add(new Goat(i, j));
                        }
                    }
                }
                break;
            }
            case "Sheep": {
                for (int i = 0; i < islandModel.length; i++) {
                    for (int j = 0; j < islandModel[i].length; j++) {
                        int n = new Random().nextInt(140);
                        for (int k = 0; k < n + 1; k++) {
                            islandModel[i][j].add(new Sheep(i, j));
                        }
                    }
                }
                break;
            }
            case "Boar": {
                for (int i = 0; i < islandModel.length; i++) {
                    for (int j = 0; j < islandModel[i].length; j++) {
                        int n = new Random().nextInt(50);
                        for (int k = 0; k < n + 1; k++) {
                            islandModel[i][j].add(new Boar(i, j));
                        }
                    }
                }
                break;
            }
            case "Buffalo": {
                for (int i = 0; i < islandModel.length; i++) {
                    for (int j = 0; j < islandModel[i].length; j++) {
                        int n = new Random().nextInt(10);
                        for (int k = 0; k < n + 1; k++) {
                            islandModel[i][j].add(new Buffalo(i, j));
                        }
                    }
                }
                break;
            }
            case "Duck": {
                for (int i = 0; i < islandModel.length; i++) {
                    for (int j = 0; j < islandModel[i].length; j++) {
                        int n = new Random().nextInt(200);
                        for (int k = 0; k < n + 1; k++) {
                            islandModel[i][j].add(new Duck(i, j));
                        }
                    }
                }
                break;
            }
            case "Caterpillar": {
                for (int i = 0; i < islandModel.length; i++) {
                    for (int j = 0; j < islandModel[i].length; j++) {
                        int n = new Random().nextInt(1000);
                        for (int k = 0; k < n + 1; k++) {
                            islandModel[i][j].add(new Caterpillar(i, j));
                        }
                    }
                }
                break;
            }
        }
    }

    public static void soutRabbits() {
        for (int i = 0; i < islandModel.length; i++) {
            for (int j = 0; j < islandModel[i].length; j++) {
                int count = 0;
                for (int k = 0; k < islandModel[i][j].size(); k++) {
                    if (islandModel[i][j].get(k) instanceof Snake) {
                        count++;
                    }
                }
                System.out.print(count + " ");
            }
            System.out.println();
        }
        System.out.println();
    }


    public static void soutWolf() {
        for (int i = 0; i < islandModel.length; i++) {
            for (int j = 0; j < islandModel[i].length; j++) {
                int count = 0;
                for (int k = 0; k < islandModel[i][j].size(); k++) {
                    if (islandModel[i][j].get(k) instanceof Goat) {
                        count++;
                    }
                }
                System.out.print(count + " ");
            }
            System.out.println();
        }
        System.out.println();
    }


    public static void soutGrass() {
        for (int i = 0; i < islandModel.length; i++) {
            for (int j = 0; j < islandModel[i].length; j++) {
                int count = 0;
                for (int k = 0; k < islandModel[i][j].size(); k++) {
                    if (islandModel[i][j].get(k) instanceof Mouse) {
                        count++;
                    }
                }
                System.out.print(count + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void move(Object object) {
        if (object instanceof Animal) {
            //System.out.println("Новый объект");
            int oldX = ((Animal) object).getX();
            int oldY = ((Animal) object).getY();
            //System.out.println(oldX +" " + oldY);
            for (int i = 0; i < ((Animal) object).getMaxStep(); i++) {
                if (new Random().nextInt(0, 2) == 0) {//Передвижение x
                    if (new Random().nextInt(0, 2) == 0) {// -x
                        if (((Animal) object).getX() - 1 < 0) {
                            ((Animal) object).setX(((Animal) object).getX() + 1);
                        } else {
                            ((Animal) object).setX(((Animal) object).getX() - 1);
                        }

                    } else {// +x
                        if (((Animal) object).getX() + 1 > 4) {
                            ((Animal) object).setX(((Animal) object).getX() - 1);
                        } else {
                            ((Animal) object).setX(((Animal) object).getX() + 1);
                        }
                    }

                } else {//передвижение по y
                    if (new Random().nextInt(0, 2) == 0) {//Передвижение по -y
                        if (((Animal) object).getY() - 1 < 0) {
                            ((Animal) object).setY(((Animal) object).getY() + 1);
                        } else {
                            ((Animal) object).setY(((Animal) object).getY() - 1);
                        }

                    } else {// +y
                        if (((Animal) object).getY() + 1 > 4) {
                            ((Animal) object).setY(((Animal) object).getY() - 1);
                        } else {
                            ((Animal) object).setY(((Animal) object).getY() + 1);
                        }
                    }

                }
            }
            islandModel[oldX][oldY].remove(object);
            islandModel[((Animal) object).getX()][((Animal) object).getY()].add(object);
            //System.out.println(((Animal) object).getSaturation());
            ((Animal) object).hungry();
            //System.out.println(((Animal) object).getSaturation());
        }
    }


    public static void shuffleAllArrayLists() {
        for (int i = 0; i < islandModel.length; i++) {
            for (int j = 0; j < islandModel[i].length; j++) {
                Collections.shuffle(islandModel[i][j]);
            }
        }
    }


}





