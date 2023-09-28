package model.Plants;

public abstract class Plants {
    private final int MAX_IN_ONE_CELL;
    private final String NAME;
    private final int WEIGHT;
    private final int x;
    private final int y;
    private boolean canEat = true;

    public boolean isCanEat() {
        return canEat;
    }

    public int getWEIGHT() {
        return WEIGHT;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setCanEat(boolean canEat) {
        this.canEat = canEat;
    }

    protected Plants(int max_in_one_cell, String name, int weight, int x, int y) {
        MAX_IN_ONE_CELL = max_in_one_cell;
        NAME = name;
        WEIGHT = weight;
        this.x = x;
        this.y = y;
    }
}
