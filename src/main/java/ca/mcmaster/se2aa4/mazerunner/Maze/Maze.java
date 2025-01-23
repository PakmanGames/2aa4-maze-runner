package ca.mcmaster.se2aa4.mazerunner.Maze;

import java.util.ArrayList;
import java.util.List;

public class Maze {
    private final List<List<Tile>> maze;

    public Maze() {
        this.maze = new ArrayList<>();
    }

    public void addRow(List<Tile> row) {
        this.maze.add(row);
    }

    public List<List<Tile>> getMaze() {
        return this.maze;
    }

    public int getRowCount() {
        return this.maze.size();
    }

    public int getColumnCount() {
        return this.maze.get(0).size();
    }

    public Tile getTile(int row, int column) {
        return this.maze.get(row).get(column);
    }

    public void printMaze() {
        for (List<Tile> row : this.maze) {
            for (Tile tile : row) {
                if (tile == Tile.WALL) {
                    System.out.print("WALL ");
                } else if (tile == Tile.PASS) {
                    System.out.print("PASS ");
                }
            }
            System.out.println();
        }
    }
}