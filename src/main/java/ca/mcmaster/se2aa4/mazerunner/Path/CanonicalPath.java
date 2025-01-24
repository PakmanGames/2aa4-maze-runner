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
}
