
import model.Animal;
import model.Herbivores.Rabbit;
import model.IslandSettings.CompletionIsland;
import model.Predators.Wolf;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Iterator;

import static model.IslandSettings.IslandSize.FillIsland;
import static model.IslandSettings.IslandSize.islandModel;

public class Main {


    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        for (int i = 0; i < islandModel.length; i++) {
            for (int j = 0; j < islandModel[i].length; j++) {
                islandModel[i][j] = new ArrayList();
            }
        }
        FillIsland();

        //Не забыть обратно поменять сытость у волков и кроликов !!!!!
    // rfffef
        int countRabbits = 0;
        int countWolf = 0;
        for (int i = 0; i < islandModel.length; i++) {
            for (int j = 0; j < islandModel[i].length; j++) {
                for (int k = 0; k < islandModel[i][j].size(); k++) {
                    if(islandModel[i][j].get(k) instanceof Rabbit){
                        countRabbits++;
                    } else if (islandModel[i][j].get(k) instanceof Wolf) {
                        //CompletionIsland.startEat(islandModel[i][j].get(k));
                        countWolf++;
                    }
                }
            }
        }
        System.out.println(countRabbits);
        System.out.println(countWolf);

        CompletionIsland.getAllAnimals();
        CompletionIsland.getAllPlants();


        for (int i = 0; i < CompletionIsland.allAnimals.size(); i++){
            CompletionIsland.startEat(CompletionIsland.allAnimals.get(i));
        }
        //for (int i = 0; i < CompletionIsland.allAnimals.size(); i++) {
          //  CompletionIsland.move(CompletionIsland.allAnimals.get(i));
        //}






        int countRabbits1 = 0;
        int countWolf1 = 0;
        for (int i = 0; i < islandModel.length; i++) {
            for (int j = 0; j < islandModel[i].length; j++) {
                for (int k = 0; k < islandModel[i][j].size(); k++) {
                    if(islandModel[i][j].get(k) instanceof Rabbit){
                        countRabbits1++;
                    } else if (islandModel[i][j].get(k) instanceof Wolf) {
                        countWolf1++;
                    }
                }
            }
        }
        System.out.println("Кроликов: " + countRabbits1);
        System.out.println("Волков: " + countWolf1);

        System.out.println();




    }

}








