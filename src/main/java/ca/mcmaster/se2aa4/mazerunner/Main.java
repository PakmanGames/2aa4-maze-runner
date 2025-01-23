package ca.mcmaster.se2aa4.mazerunner;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {

    private static final Logger logger = LogManager.getLogger();

    public static void main(String[] args) {
        try {
            System.out.println(args.length);
            if (args.length == 0) {
                System.err.println();
            } else if (args.length > 0) {
                if (args.length == 2 && args[0].equals("-i")) {
                    // read file from args[1]
                    File file = new File(args[1]);
                    if (!file.exists()) {
                        System.err.println("File does not exist");
                        System.exit(1);
                    } else {
                        System.out.println("** Starting Maze Runner");
                        System.out.println("**** Reading the maze from file " + args[1]);
                        BufferedReader reader = new BufferedReader(new FileReader(args[1]));
                        String line;
                        while ((line = reader.readLine()) != null) {
                            for (int idx = 0; idx < line.length(); idx++) {
                                if (line.charAt(idx) == '#') {
                                    System.out.print("WALL ");
                                } else if (line.charAt(idx) == ' ') {
                                    System.out.print("PASS ");
                                }
                            }
                            System.out.print(System.lineSeparator());
                        }
                    }
                } else if (args.length == 4 && args[0].equals("-i") && args[2].equals("-p")) {
                    // read file from args[1]
                    File file = new File(args[1]);
                    if (!file.exists()) {
                        System.err.println("File does not exist");
                        System.exit(1);
                    } else {
                        System.out.println("** Starting Maze Runner");
                        System.out.println("**** Reading the maze from file " + args[1]);
                        BufferedReader reader = new BufferedReader(new FileReader(args[1]));
                        String line;
                        while ((line = reader.readLine()) != null) {
                            for (int idx = 0; idx < line.length(); idx++) {
                                if (line.charAt(idx) == '#') {
                                    System.out.print("WALL ");
                                } else if (line.charAt(idx) == ' ') {
                                    System.out.print("PASS ");
                                }
                            }
                            System.out.print(System.lineSeparator());
                        }
                        // do stuff with path from args[3]
                    } 
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
