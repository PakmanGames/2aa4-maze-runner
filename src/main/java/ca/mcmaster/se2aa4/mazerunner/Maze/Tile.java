package ca.mcmaster.se2aa4.mazerunner.Maze;

public enum Tile {
    WALL('#'), 
    PASS(' ');

    private final char symbol;

    Tile(char symbol) {
        this.symbol = symbol;
    }

    public char getSymbol() {
        return symbol;
    }

    public Boolean isWalkable() {
        return this == WALL ? false : true;
    }

    public static Tile fromSymbol(char symbol) {
        if (symbol == '#') {
            return WALL;
        } else if (symbol == ' ') {
            return PASS;
        } else {
            throw new IllegalArgumentException("Invalid symbol: " + symbol);
        }
    }
}