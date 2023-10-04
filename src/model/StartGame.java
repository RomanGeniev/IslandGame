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
            CompletionIsland.soutGrass();
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



        }
    }

