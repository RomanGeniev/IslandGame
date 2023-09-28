package model;

import model.Herbivores.Rabbit;
import model.IslandSettings.CompletionIsland;
import model.Plants.Grass;
import model.Predators.Wolf;

import java.util.ArrayList;

import static model.IslandSettings.IslandSize.FillIsland;
import static model.IslandSettings.IslandSize.islandModel;

public class StartGame implements Runnable{
    @Override
    public void run() {
        CompletionIsland.shuffleAllArrayLists();



//            int countRabbits = 0;
//            int countWolf = 0;
//            int countGrass = 0;
//            for (int i = 0; i < islandModel.length; i++) {
//                for (int j = 0; j < islandModel[i].length; j++) {
//                    for (int k = 0; k < islandModel[i][j].size(); k++) {
//                        if (islandModel[i][j].get(k) instanceof Rabbit) {
//                            countRabbits++;
//                        } else if (islandModel[i][j].get(k) instanceof Wolf) {
//                            countWolf++;
//                        } else if (islandModel[i][j].get(k) instanceof Grass) {
//                            countGrass++;
//                        }
//                    }
//                }
//            }
            CompletionIsland.soutGrass();
//            System.out.println(countRabbits);
//            System.out.println(countWolf);
//            System.out.println(countGrass);
        //CompletionIsland.soutRabbits();
        //CompletionIsland.soutWolf();

            CompletionIsland.getAllAnimals();
            CompletionIsland.getAllPlants();


            for (int i = 0; i < CompletionIsland.allAnimals.size(); i++) {
                CompletionIsland.startEat(CompletionIsland.allAnimals.get(i));
            }

            CompletionIsland.getAllAnimals();
            CompletionIsland.getAllPlants();

        for (int i = 0; i < CompletionIsland.allAnimals.size(); i++) {
            CompletionIsland.move(CompletionIsland.allAnimals.get(i));
        }

            //CompletionIsland.soutGrass();
            //CompletionIsland.soutRabbits();


//        CompletionIsland.getAllAnimals();
//        for (int i = 0; i < CompletionIsland.allAnimals.size(); i++) {
//           CompletionIsland.move(CompletionIsland.allAnimals.get(i));
//        }


//            System.out.println();
//            int countRabbits1 = 0;
//            int countWolf1 = 0;
//            int countGrass1 = 0;
//            for (int i = 0; i < islandModel.length; i++) {
//                for (int j = 0; j < islandModel[i].length; j++) {
//                    for (int k = 0; k < islandModel[i][j].size(); k++) {
//                        if (islandModel[i][j].get(k) instanceof Rabbit) {
//                            countRabbits1++;
//                        } else if (islandModel[i][j].get(k) instanceof Wolf) {
//                            countWolf1++;
//                        } else if (islandModel[i][j].get(k) instanceof Grass) {
//                            countGrass1++;
//                        }
//                    }
//                }
//            }
//            System.out.println("Rabbits: " + countRabbits1);
//            System.out.println("Wolfs: " + countWolf1);
//            System.out.println("Grasses: " + countGrass1);


        }
    }

