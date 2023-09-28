package model.IslandSettings;

import java.util.ArrayList;

import static model.IslandSettings.CompletionIsland.AddInField;

public class IslandSize {

    public static void FillIsland() {
        AddInField("Wolf");
        AddInField("Grass");
        AddInField("Rabbit");
        AddInField("Snake");
        AddInField("Fox");
        AddInField("Bear");
        AddInField("Eagle");
        AddInField("Horse");
        AddInField("Deer");
        AddInField("Mouse");
        AddInField("Goat");
        AddInField("Sheep");
        AddInField("Boar");
        AddInField("Buffalo");
        AddInField("Duck");
        AddInField("Caterpillar");
    }


    public static final int WIDTH_ISLAND = 5;
    public static final int HEIGHT_ISLAND = 5;

    public static ArrayList<Object>[][] islandModel = new ArrayList[WIDTH_ISLAND][HEIGHT_ISLAND];


}
