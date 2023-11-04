package Game;

import java.util.Objects;

public class Coordinate implements Comparable<Coordinate>{
    private int X;
    private int Y;

    public Coordinate(int x, int y) {
        this.X = x;
        this.Y = y;
    }

    public int getX() {
        return X;
    }

    public int getY() {
        return Y;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Coordinate that = (Coordinate) obj;
        return X == that.X && Y == that.Y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(X, Y);
    }

    @Override
    public int compareTo(Coordinate c) {
        int compareX = Integer.compare(this.X, c.X);
        if (compareX == 0) {
            return Integer.compare(this.Y, c.Y);
        }
        return compareX;
    }
}