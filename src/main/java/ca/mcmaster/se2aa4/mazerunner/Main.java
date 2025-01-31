package ca.mcmaster.se2aa4.mazerunner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Option;
import ca.mcmaster.se2aa4.mazerunner.Maze.Maze;
import ca.mcmaster.se2aa4.mazerunner.Maze.MazeReader;
import ca.mcmaster.se2aa4.mazerunner.Solver.RightHandSolver;

public class Main {

    private static final Logger logger = LogManager.getLogger();

    public static void main(String[] args) {
        Options options = new Options();
        CommandLineParser parser = new DefaultParser();

        Option input = new Option("i", "input", true, "input file path");
        input.setRequired(true);
        options.addOption(input);

        Option mazePath = new Option("p", "path", true, "path to output file");
        mazePath.setRequired(false);
        options.addOption(mazePath);

        CommandLine cmd;

        try {
            cmd = parser.parse(options, args);
        } catch (Exception e) {
            logger.error("Failed to parse command line arguments: " + e.getMessage());
            System.exit(1);
            return;
        }

        String inputFilePath = cmd.getOptionValue("input");
        String pathFilePath = cmd.getOptionValue("path");

        try {
            if (inputFilePath != null && pathFilePath == null) {
                Maze maze = MazeReader.readMaze(inputFilePath);
                logger.info("** Starting Maze Runner");
                logger.info("**** Reading the maze from file " + inputFilePath);
                maze.printMaze();
                System.out.println(maze.getStartLocation());
                System.out.println(maze.getEndLocation());

                RightHandSolver solver = new RightHandSolver();
                String path = solver.solve(maze);
                logger.info("**** Path computed: " + path);

            } else if (inputFilePath != null && pathFilePath != null) {
                Maze maze = MazeReader.readMaze(inputFilePath);
                logger.info("** Starting Maze Runner");
                logger.info("**** Reading the maze from file " + inputFilePath);
                maze.printMaze();

                // do something with -p flag path stuff
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
