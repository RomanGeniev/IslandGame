package model.Plants;

public abstract class Plants {
    private final int MAX_IN_ONE_CELL;
    private final String NAME;
    private final int WEIGHT;
    private int id;
    private int x;
    private int y;


    protected Plants(int max_in_one_cell, String name, int weight, int id, int x, int y) {
        MAX_IN_ONE_CELL = max_in_one_cell;
        NAME = name;
        WEIGHT = weight;
        this.id = id;
        this.x = x;
        this.y = y;
    }
}
