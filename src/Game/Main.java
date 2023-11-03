package Game;

import java.util.Scanner;

import static Game.Move.moveLocation;

public class Main {
    public static void main(String[] args) {
        GameLoop();
    }

    public static void GameLoop() {
        Grid grid = new Grid();
        grid.loadLevel("D:\\Intellij projects\\LogicSteps\\src\\Game\\level.txt");
        Scanner scanner = new Scanner(System.in);
        int positionIndex, direction;
        grid.printGrid();
        grid.printLocations();
        while (!Rules.isWon(grid)) {
            if (Rules.isStuck(grid)) {
                System.out.println("Game Over!\nYou Lost");
                return;
            }
            System.out.println("Enter position index");
            positionIndex=scanner.nextInt();

            if(Move.isValidPosition(positionIndex-1,grid)){
                System.out.println("Enter the direction to move (8 for up, 6 for right, 4 for left, 2 for down):");
                direction = scanner.nextInt();
                moveLocation(positionIndex-1,direction,grid);
                grid.printGrid();
                grid.printLocations();
            }else {
                System.out.println("Bad index");
            }
        }
        System.out.println("YOU WIN!!!\nHURRAY!!!");
    }

}