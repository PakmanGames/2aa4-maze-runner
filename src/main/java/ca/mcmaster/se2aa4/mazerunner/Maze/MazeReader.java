package ca.mcmaster.se2aa4.mazerunner.Maze;

import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;

public class MazeReader {
    public static Maze readMaze(String filename) {
        Maze maze = new Maze();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            String line;
            while ((line = reader.readLine()) != null) {
                List<Tile> row = new ArrayList<>();
                for (int idx = 0; idx < line.length(); idx++) {
                    row.add(Tile.fromSymbol(line.charAt(idx)));
                }
                maze.addRow(row);
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return maze;
    }
}