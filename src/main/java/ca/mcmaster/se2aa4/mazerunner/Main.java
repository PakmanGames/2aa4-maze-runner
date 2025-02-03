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
import ca.mcmaster.se2aa4.mazerunner.Path.CanonicalPath;

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
        String pathInput = cmd.getOptionValue("path");

        try {
            if (inputFilePath != null && pathInput == null) {
                Maze maze = MazeReader.readMaze(inputFilePath);
                maze.printMaze();

                RightHandSolver solver = new RightHandSolver();
                String path = solver.solve(maze);
                System.out.println("The correct path is " + path);

            } else if (inputFilePath != null && pathInput != null) {
                Maze maze = MazeReader.readMaze(inputFilePath);
                maze.printMaze();

                if (maze.isPathCorrect(pathInput)) {
                    System.out.println("Correct path.");
                } else {
                    System.out.println("Incorrect path.");
                    System.out.println("The correct path is " + CanonicalPath.convertToCanonical(maze.getCorrectPath()));
                }
            }
        } catch(Exception e) {
            System.out.println("Error occurred while computing path.");
            e.printStackTrace();
        }
    }
}
