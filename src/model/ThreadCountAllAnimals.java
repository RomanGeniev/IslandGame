package model;

import model.Herbivores.*;
import model.IslandSettings.IslandSize;
import model.Predators.*;

public class ThreadCountAllAnimals extends IslandSize implements Runnable {

    @Override
    public void run() {
        int countWolf = 0;
        int countRabbits = 0;
        int countSnake = 0;
        int countFox = 0;
        int countBear = 0;
        int countEagle = 0;
        int countHorse = 0;
        int countDeer = 0;
        int countMouses = 0;
        int countGoat = 0;
        int countSheep = 0;
        int countBoar = 0;
        int countBuffalo = 0;
        int countDuck = 0;
        int countCaterpillar = 0;
        for (int i = 0; i < islandModel.length; i++) {
            for (int j = 0; j < islandModel[i].length; j++) {
                for (int k = 0; k < islandModel[i][j].size(); k++) {
                    if (islandModel[i][j].get(k) instanceof Predators) {// хищники
                        if (((Predators) islandModel[i][j].get(k)) instanceof Wolf) {
                            countWolf++;
                        } else if (((Predators) islandModel[i][j].get(k)) instanceof Snake) {
                            countSnake++;
                        } else if (((Predators) islandModel[i][j].get(k)) instanceof Fox) {
                            countFox++;
                        } else if (((Predators) islandModel[i][j].get(k)) instanceof Bear) {
                            countBear++;
                        } else if (((Predators) islandModel[i][j].get(k)) instanceof Eagle) {
                            countEagle++;
                        }


                    } else if (islandModel[i][j].get(k) instanceof Herbivores) {
                        if (((Herbivores) islandModel[i][j].get(k)) instanceof Rabbit) {
                            countRabbits++;
                        } else if (((Herbivores) islandModel[i][j].get(k)) instanceof Horse) {
                            countHorse++;
                        } else if (((Herbivores) islandModel[i][j].get(k)) instanceof Deer) {
                            countDeer++;
                        } else if (((Herbivores) islandModel[i][j].get(k)) instanceof Mouse) {
                            countMouses++;
                        } else if (((Herbivores) islandModel[i][j].get(k)) instanceof Goat) {
                            countGoat++;
                        } else if (((Herbivores) islandModel[i][j].get(k)) instanceof Sheep) {
                            countSheep++;
                        } else if (((Herbivores) islandModel[i][j].get(k)) instanceof Boar) {
                            countBoar++;
                        } else if (((Herbivores) islandModel[i][j].get(k)) instanceof Buffalo) {
                            countBuffalo++;
                        } else if (((Herbivores) islandModel[i][j].get(k)) instanceof Duck) {
                            countDuck++;
                        } else if (((Herbivores) islandModel[i][j].get(k)) instanceof Caterpillar) {
                            countCaterpillar++;
                        }
                    }
                }
            }
        }
        System.out.println("Осталось животных на острове : ");
        System.out.println("Волков : " + countWolf);
        System.out.println("Кроликов : " + countRabbits);
        System.out.println("Змей :" + countSnake);
        System.out.println("Лис: " + countFox);
        System.out.println("Медведей: " + countBear);
        System.out.println("Орлов: " + countEagle);
        System.out.println("Лошадей: " + countHorse);
        System.out.println("Оленей:" + countDeer);
        System.out.println("Мышей: " + countMouses);
        System.out.println("Коз: " + countGoat);
        System.out.println("Овец: " + countSheep);
        System.out.println("Кабанов: " + countBoar);
        System.out.println("Буйволов: " + countBuffalo);
        System.out.println("Уток: " + countDuck);
        System.out.println("Гусениц: " + countCaterpillar);
    }

}
