package ca.mcmaster.se2aa4.mazerunner;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ca.mcmaster.se2aa4.mazerunner.Maze.Maze;
import ca.mcmaster.se2aa4.mazerunner.Maze.MazeReader;

public class Main {

    private static final Logger logger = LogManager.getLogger();

    public static void main(String[] args) {
        try {
            System.out.println(args.length);
            if (args.length == 0) {
                System.err.println();
            } else if (args.length > 0) {
                if (args.length == 2 && args[0].equals("-i")) {
                    Maze maze = MazeReader.readMaze(args[1]);
                    System.out.println("** Starting Maze Runner");
                    System.out.println("**** Reading the maze from file " + args[1]);
                    maze.printMaze();
                } else if (args.length == 4 && args[0].equals("-i") && args[2].equals("-p")) {
                    Maze maze = MazeReader.readMaze(args[1]);
                    System.out.println("** Starting Maze Runner");
                    System.out.println("**** Reading the maze from file " + args[1]);
                    maze.printMaze();

                    // do something with args[3]
                }
            }
        } catch(Exception e) {
            System.err.println("/!\\ An error has occured /!\\");
            System.out.println("PATH NOT COMPUTED");
        }
        System.out.println("**** Computing path");
        System.out.println("** End of MazeRunner");
    }
}
