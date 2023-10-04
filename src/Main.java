
import model.Animal;
import model.GrassGrowth;
import model.Herbivores.Rabbit;
import model.IslandSettings.CompletionIsland;
import model.Plants.Grass;
import model.Predators.Wolf;
import model.StartGame;
import model.ThreadCountAllAnimals;

import java.util.ArrayList;
import java.util.Collections;

import static model.IslandSettings.IslandSize.FillIsland;
import static model.IslandSettings.IslandSize.islandModel;

public class Main {


    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < islandModel.length; i++) {
            for (int j = 0; j < islandModel[i].length; j++) {
                islandModel[i][j] = new ArrayList<>();
            }
        }
        FillIsland();
        StartGame startGame = new StartGame();
        GrassGrowth grassGrowth = new GrassGrowth();
        startGame.run();
        ThreadCountAllAnimals threadCountAllAnimals = new ThreadCountAllAnimals();
        while (true){
            Thread.sleep(2000);
            startGame.run();
            grassGrowth.run();
            threadCountAllAnimals.run();
        }
    }

}








