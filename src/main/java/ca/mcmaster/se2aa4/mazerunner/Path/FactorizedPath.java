package ca.mcmaster.se2aa4.mazerunner.Path;

public class FactorizedPath extends Path {
    private char lastDirection;
    private int count;

    public FactorizedPath() {
        super();
        this.lastDirection = '\0';
        this.count = 0;
    }

    @Override
    public void add(char direction) {
        if (this.path.length() == 0) {
            this.path.append(direction);
            this.lastDirection = direction;
            this.count = 1;
        } else {
            if (this.lastDirection == direction) {
                this.count++;
            } else {
                if (this.count > 1) {
                    this.path.append(this.count);
                }
                this.path.append(" ");
                this.path.append(direction);
                this.lastDirection = direction;
                this.count = 1;
            }
        }
    }

    @Override
    public String toString() {
        if (this.count > 1) {
            this.path.append(this.count);
        }
        return this.path.toString().trim();
    }
}