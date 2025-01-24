package ca.mcmaster.se2aa4.mazerunner;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ca.mcmaster.se2aa4.mazerunner.Maze.Maze;
import ca.mcmaster.se2aa4.mazerunner.Maze.MazeReader;
import ca.mcmaster.se2aa4.mazerunner.Path.CanonicalPath;
import ca.mcmaster.se2aa4.mazerunner.Path.Path;
import ca.mcmaster.se2aa4.mazerunner.Solver.RightHandSolver;

public class Main {

    private static final Logger logger = LogManager.getLogger();
    // info, error, debug, trace

    public static void main(String[] args) {
        try {
            System.out.println(args.length);
            if (args.length == 0) {
                logger.error("No arguments passed.");
            } else if (args.length > 0) {
                if (args.length == 2 && args[0].equals("-i")) {
                    Maze maze = MazeReader.readMaze(args[1]);
                    logger.info("** Starting Maze Runner");
                    logger.info("**** Reading the maze from file " + args[1]);
                    maze.printMaze();
                    System.out.println(maze.getStartLocation());
                    System.out.println(maze.getEndLocation());

                    // logger.info("Testing path");
                    // Path path = new CanonicalPath();
                    // path.add('F');
                    // path.add('L');
                    // path.add('F');
                    // path.add('F');
                    // path.add('F');
                    // path.add('F');
                    // path.add('F');
                    // path.add('R');
                    // path.add('F');
                    // path.add('F');
                    // path.add('R');
                    // path.add('F');
                    // path.add('F');
                    // path.add('L');
                    // path.add('F');
                    // path.add('F');
                    // path.add('F');
                    // path.add('F');
                    // path.add('F');
                    // path.add('F');
                    // path.add('R');
                    // path.add('F');
                    // path.add('F');
                    // path.add('F');
                    // path.add('F');
                    // path.add('F');
                    // path.add('L');
                    // path.add('F');
                    // System.out.println(path.toString());

                    RightHandSolver solver = new RightHandSolver();
                    String path = solver.solve(maze);
                    logger.info("**** Path computed: " + path);

                } else if (args.length == 4 && args[0].equals("-i") && args[2].equals("-p")) {
                    Maze maze = MazeReader.readMaze(args[1]);
                    logger.info("** Starting Maze Runner");
                    logger.info("**** Reading the maze from file " + args[1]);
                    maze.printMaze();

                    // do something with args[3]
                }
            }
        } catch(Exception e) {
            logger.error("/!\\ An error has occured /!\\");
            logger.warn("PATH NOT COMPUTED");
            logger.error(e);
            e.printStackTrace();
        }
        logger.info("**** Computing path");
        logger.info("** End of MazeRunner");
    }
}
