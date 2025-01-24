package ca.mcmaster.se2aa4.mazerunner.Runner;

import ca.mcmaster.se2aa4.mazerunner.Navigation.Direction;
import ca.mcmaster.se2aa4.mazerunner.Navigation.Location;

public class Runner {
    private Location location;
    private Direction direction;

    public void setLocation(Location location) {
        this.location = location;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public void turnLeft() {
        this.direction = this.direction.turnLeft();
    }

    public void turnRight() {
        this.direction = this.direction.turnRight();
    }

    public Location getLocation() {
        return this.location;
    }

    public Direction getDirection() {
        return this.direction;
    }

    public void move() {
        this.location = this.location.move(this.direction);
    }
}
