package Game;

import java.util.Objects;

public class Coordinate implements Comparable<Coordinate>{
    private int X;
    private int Y;
    private int cost;

    public Coordinate(int x, int y,int cost) {
        this.X = x;
        this.Y = y;
        this.cost=cost;
    }

    public int getX() {
        return X;
    }

    public int getY() {
        return Y;
    }

    public int getCost() {
        return cost;
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
        return X == that.X && Y == that.Y && cost==that.cost;
    }

    @Override
    public int hashCode() {
        return Objects.hash(X, Y, cost);
    }


    public int compareCoordinate(Coordinate c) {
        int compareX = Integer.compare(this.X, c.X);
        if (compareX == 0) {
            return Integer.compare(this.Y, c.Y);
        }
        return compareX;
    }

    @Override
    public int compareTo(Coordinate c) {
        return this.getCost()-c.getCost();
        }
  }