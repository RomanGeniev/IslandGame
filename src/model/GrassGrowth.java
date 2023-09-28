package model;

import model.IslandSettings.CompletionIsland;

public class GrassGrowth implements Runnable{
    @Override
    public void run() {
        //while (true) {

            CompletionIsland.getAllPlants();
            for (int i = 0; i < CompletionIsland.allPlants.size(); i++) {
                if (!CompletionIsland.allPlants.get(i).isCanEat()) {
                    CompletionIsland.allPlants.get(i).setCanEat(true);
                }
            }
            //try {
                //Thread.sleep(500);
            //} catch (InterruptedException e) {
                //throw new RuntimeException(e);
            //}
        //}

    }
}
