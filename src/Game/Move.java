package Game;

public class Move {
    public Grid grid;
    public Rules rules;


    public static boolean isValidPosition(int positionIndex,Grid grid){

        if (positionIndex < 0 || positionIndex >= grid.positions.size()) {
            return false;
        }
        return true;
    }


    public static boolean isValidMove(int positionIndex, int direction, Grid grid) {

        Coordinate location = grid.positions.get(positionIndex);
        int x = location.getX();
        int y = location.getY();

        int newX = x;
        int newY = y;
        if (direction == 8) {
            newX = x - 1;
        } else if (direction == 6) {
            newY = y + 1;
        } else if (direction == 4) {
            newY = y - 1;
        } else if (direction == 2) {
            newX = x + 1;
        }


        if ((direction == 8 || direction == 2) && newX < 0) {
            return false;
        }
        if ((direction == 6 || direction == 4) && newY < 0) {
            return false;
        }
        if ((direction == 8 || direction == 2) && newX >= grid.rows) {
            return false;
        }
        if ((direction == 6 || direction == 4) && newY >= grid.columns) {
            return false;
        }

        Coordinate newLocation = new Coordinate(newX, newY);
        if (grid.positions.contains(newLocation)) {
            return false;
        }

        if (grid.grid[newX][newY] == 0 || grid.grid[newX][newY] == 6) {
            return false;
        }

        return true;
    }

    public static void moveLocation(int positionIndex, int direction, Grid grid) {

        if (isValidMove(positionIndex, direction, grid)&&isValidPosition(positionIndex,grid)) {
            Coordinate location = grid.positions.get(positionIndex);
            int x = location.getX();
            int y = location.getY();

            switch (direction) {
                case 8: // Up
                    x--;
                    break;
                case 6: // Right
                    y++;
                    break;
                case 4: // Left
                    y--;
                    break;
                case 2: // Down
                    x++;
                    break;
                default:
                    System.out.println("Invalid direction. Please use the numpad keys: 8 (up), 6 (right), 4 (left), or 2 (down).");
                    return;
            }

            grid.grid[x][y] += 1;
            grid.positions.set(positionIndex, new Coordinate(x, y));
            System.out.println("moved");
        } else {
            System.out.println("Invalid move.");
        }
    }
}
