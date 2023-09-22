package model.IslandSettings;

import model.Animal;
import model.Herbivores.Herbivores;
import model.Herbivores.Rabbit;
import model.Plants.Grass;
import model.Plants.Plants;
import model.Predators.Predators;
import model.Predators.Wolf;

import java.util.ArrayList;
import java.util.Random;

import static model.IslandSettings.IslandSize.islandModel;

public class CompletionIsland {

    public static ArrayList<Animal> allAnimals = new ArrayList<>();
    public static ArrayList<Grass> allPlants = new ArrayList<>();

    public static void getAllAnimals() {//Работает
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
                            System.out.println("Кролик съел траву");
                            ((Rabbit) object).setSaturation((plants.getWEIGHT() + ((Rabbit) object).getSaturation()));
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
            case "Волк":
                int id = 0;
                for (int i = 0; i < islandModel.length; i++) {
                    for (int j = 0; j < islandModel[i].length; j++) {
                        int n = new Random().nextInt(30);
                        for (int k = 0; k < n + 1; k++) {
                            islandModel[i][j].add(new Wolf(id, i, j));
                            id++;
                        }
                    }
                }
                break;

            case "Травка":
                int idPlants = 0;
                for (int i = 0; i < islandModel.length; i++) {
                    for (int j = 0; j < islandModel[i].length; j++) {
                        int n = new Random().nextInt(200);
                        for (int k = 0; k < n + 1; k++) {
                            islandModel[i][j].add(new Grass(idPlants, i, j));
                            idPlants++;
                        }
                    }
                }
                break;

            case "Кролик": {
                int idRabbits = 0;
                for (int i = 0; i < islandModel.length; i++) {
                    for (int j = 0; j < islandModel[i].length; j++) {
                        int n = new Random().nextInt(150);
                        for (int k = 0; k < n + 1; k++) {
                            islandModel[i][j].add(new Rabbit(idRabbits, i, j));
                            idRabbits++;
                        }
                    }
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

    public static void soutRabbits() {
        for (int i = 0; i < islandModel.length; i++) {
            for (int j = 0; j < islandModel[i].length; j++) {
                int count = 0;
                for (int k = 0; k < islandModel[i][j].size(); k++) {
                    if (islandModel[i][j].get(k) instanceof Rabbit) {
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
                    if (islandModel[i][j].get(k) instanceof Wolf) {
                        count++;
                    }
                }
                System.out.print(count + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

}





