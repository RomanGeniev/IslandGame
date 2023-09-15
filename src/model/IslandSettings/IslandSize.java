package model.IslandSettings;

import java.util.ArrayList;

import static model.IslandSettings.CompletionIsland.AddInField;

public class IslandSize {


    public static void StartingEating(){

        //eatObject();
    }

    public static void FillIsland() {
        AddInField(30, "Волк");
        AddInField(200, "Травка");
        AddInField(150, "Кролик");
    }




    public static final int WIDTH_ISLAND = 5;
    public static final int HEIGHT_ISLAND = 5;

    public static ArrayList<Object>[][] islandModel = new ArrayList[WIDTH_ISLAND][HEIGHT_ISLAND];


}
