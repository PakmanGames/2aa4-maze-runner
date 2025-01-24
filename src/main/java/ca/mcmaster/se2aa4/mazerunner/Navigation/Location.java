package ca.mcmaster.se2aa4.mazerunner.Navigation;

public class Location {
    private int row;
    private int column;

    public Location(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public int getRow() {
        return this.row;
    }

    public int getColumn() {
        return this.column;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public boolean equals(Location location) {
        return this.row == location.getRow() && this.column == location.getColumn();
    }

    @Override
    public String toString() {
        return "(" + this.row + ", " + this.column + ")";
    }
}
