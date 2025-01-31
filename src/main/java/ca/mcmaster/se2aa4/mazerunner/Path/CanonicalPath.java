package ca.mcmaster.se2aa4.mazerunner.Path;

public class CanonicalPath extends Path {
    public CanonicalPath() {
        super();
    }

    @Override
    public void add(char direction) {
        if (this.path.length() == 0) {
            this.path.append(direction);
        } else {
            char lastDirection = this.path.charAt(this.path.length() - 1);
            if (lastDirection == direction) {
                this.path.append(direction);
            } else {
                this.path.append(" ");
                this.path.append(direction);
            }
        }
    }

    public static String convertToCanonical(String factorizedPath) {
        StringBuilder canonicalPath = new StringBuilder();
        String[] directions = factorizedPath.split(" ");
        for (String direction : directions) {
            if (direction.length() == 1) {
                canonicalPath.append(direction);
            } else {
                int count = Integer.parseInt(direction.substring(0, direction.length() - 1));
                char dir = direction.charAt(direction.length() - 1);
                for (int i = 0; i < count; i++) {
                    canonicalPath.append(dir);
                }
            }
            canonicalPath.append(" ");
        }
        return canonicalPath.toString().trim();
    }

    public String toString() {
        return this.path.toString();
    }
}
