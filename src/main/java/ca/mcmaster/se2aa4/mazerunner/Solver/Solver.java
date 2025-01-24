package ca.mcmaster.se2aa4.mazerunner.Solver;

import ca.mcmaster.se2aa4.mazerunner.Maze.Maze;

public interface Solver {
    public String solve(Maze maze) throws InterruptedException;
}
