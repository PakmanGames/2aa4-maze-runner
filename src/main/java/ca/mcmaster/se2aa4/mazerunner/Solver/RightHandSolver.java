package ca.mcmaster.se2aa4.mazerunner.Solver;

import ca.mcmaster.se2aa4.mazerunner.Maze.Maze;
import ca.mcmaster.se2aa4.mazerunner.Navigation.Direction;
import ca.mcmaster.se2aa4.mazerunner.Navigation.Location;
import ca.mcmaster.se2aa4.mazerunner.Path.Path;
import ca.mcmaster.se2aa4.mazerunner.Path.CanonicalPath;
import ca.mcmaster.se2aa4.mazerunner.Runner.Runner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class RightHandSolver implements Solver {
    private static final Logger logger = LogManager.getLogger();

    @Override
    public String solve(Maze maze) {
        Location endLocation = maze.getEndLocation();
        Runner runner = new Runner();
        runner.setLocation(maze.getStartLocation());
        runner.setDirection(Direction.RIGHT);
        

        Path path = new CanonicalPath();
        logger.info("Starting at: " + runner.getLocation());
        logger.info("End location: " + endLocation);
        // System.out.println(runner.getLocation());
        // System.out.println(endLocation);
        // System.out.println(runner.getLocation().equals(endLocation));
        // System.out.println(runner.getLocation().move(runner.getDirection()));
        // runner.move();
        // System.out.println(runner.getLocation());

        // runner.turnRight();
        // System.out.println(runner.getDirection());
        // runner.move();
        // System.out.println(runner.getLocation());
        // System.out.println(maze.getTile(runner.getLocation().move(runner.getDirection())).isWalkable());

        // logger.info("Tile: " + maze.getTile(runner.getLocation().move(runner.getDirection())).isWalkable());

        // while (!runner.getLocation().equals(endLocation)) {
        //     Location currentLocation = runner.getLocation();
        //     logger.info("Current location: " + currentLocation + ", Direction: " + runner.getDirection());

        //     if (maze.getTile(currentLocation.move(runner.getDirection())).isWalkable()) {
        //         path.add('F');
        //         runner.move();
        //         logger.info("Moved forward to: " + runner.getLocation());
        //     } else {
        //         runner.turnRight();
        //         path.add('R');
        //         logger.info("Turned right, new direction: " + runner.getDirection());
        //     }
        // }


        while (!runner.getLocation().equals(endLocation)) {
            Location currentLocation = runner.getLocation();
            Direction currentDirection = runner.getDirection();

            Location leftLocation = currentLocation.move(currentDirection.turnLeft());
            Location rightLocation = currentLocation.move(currentDirection.turnRight());
            Location forwardLocation = currentLocation.move(currentDirection);

            boolean leftWall = !maze.getTile(leftLocation).isWalkable();
            boolean frontWall = !maze.getTile(forwardLocation).isWalkable();
            boolean rightWall = !maze.getTile(rightLocation).isWalkable();

            if (!rightWall) {
                runner.turnRight();
                path.add('R');
            } else if (frontWall) {
                if (leftWall) {
                    runner.turnRight();
                    runner.turnRight();
                    path.add('R');
                    path.add('R');
                } else {
                    runner.turnLeft();
                    path.add('L');
                }
            }
            path.add('F');
            runner.move();
            logger.info("Moved to: " + runner.getLocation() + ", Direction: " + runner.getDirection());
        }
        return path.toString();
    }
}
