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
        if (this.lastDirection == '\0') {
            this.lastDirection = direction;
            this.count = 1;
        } else {
            if (this.lastDirection == direction) {
                this.count++;
            } else {
                if (this.count > 1) {
                    this.path.append(this.count).append(this.lastDirection);
                } else {
                    this.path.append(this.lastDirection);
                }
                this.path.append(" ");
                this.lastDirection = direction;
                this.count = 1;
            }
        }
    }

    public static String convertToFactorized(String canonicalPath) {
        StringBuilder factorizedPath = new StringBuilder();
        String[] moves = canonicalPath.split(" ");

        for (String move : moves) {
            char direction = move.charAt(0);
            int count = move.length();

            if (count > 1) {
                factorizedPath.append(count).append(direction);
            } else {
                factorizedPath.append(direction);
            }
            factorizedPath.append(" ");
        }
        return factorizedPath.toString().trim();
    }

    @Override
    public String toString() {
        if (this.count > 1) {
            this.path.append(this.count).append(this.lastDirection);
        } else {
            this.path.append(this.lastDirection);
        }
        return this.path.toString().trim();
    }
}