package model.IslandSettings;

import java.util.ArrayList;

import static model.IslandSettings.CompletionIsland.AddInField;

public class IslandSize {

    public static void FillIsland() {
        AddInField("Волк");
        AddInField("Травка");
        AddInField("Кролик");
    }


    public static final int WIDTH_ISLAND = 5;
    public static final int HEIGHT_ISLAND = 5;

    public static ArrayList<Object>[][] islandModel = new ArrayList[WIDTH_ISLAND][HEIGHT_ISLAND];


}
