package ca.mcmaster.se2aa4.mazerunner.Maze;

import java.util.ArrayList;
import java.util.List;

import ca.mcmaster.se2aa4.mazerunner.Navigation.Location;
import ca.mcmaster.se2aa4.mazerunner.Solver.RightHandSolver;
import ca.mcmaster.se2aa4.mazerunner.Path.CanonicalPath;

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

    public Tile getTile(Location location) {
        return this.getTile(location.getRow(), location.getColumn());
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

    public Location getStartLocation() {
        for (int row = 0; row < this.getRowCount(); row++) {
            if(this.getTile(row, 0) == Tile.PASS) {
                return new Location(row, 0);
            }
        }
        return null;
    }

    public Location getEndLocation() {
        for (int row = 0; row < this.getRowCount(); row++) {
            if(this.getTile(row, this.getColumnCount() - 1) == Tile.PASS) {
                return new Location(row, this.getColumnCount() - 1);
            }
        }
        return null;
    }

    public String getCorrectPath() {
        RightHandSolver solver = new RightHandSolver();
        return solver.solve(this);
    }

    public Boolean isPathCorrect(String path) {
        RightHandSolver solver = new RightHandSolver();
        String factorizedPathAnswer = solver.solve(this);
        String canonicalPathAnswer = CanonicalPath.convertToCanonical(factorizedPathAnswer);

        return factorizedPathAnswer.equals(path) || canonicalPathAnswer.equals(path);
    }
}