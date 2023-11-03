package Game;

public class Rules {
    public Grid grid;
    public Move move;

    public static boolean isWon(Grid grid) {
        for (int i = 0; i < grid.rows; i++) {
            for (int j = 0; j < grid.columns; j++) {
                if (!(grid.grid[i][j] == 0 || grid.grid[i][j] == 6)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isStuck(Grid grid) {
        for (int i = 0; i < grid.positions.size(); i++) {
            Coordinate location = grid.positions.get(i);
            int x = location.getX();
            int y = location.getY();

            if (!Move.isValidMove(i, 8, grid) && !Move.isValidMove(i, 6, grid) && !Move.isValidMove(i, 4, grid) && !Move.isValidMove(i, 2, grid)) {
                return true;
            }
        }

        return false;
    }
}