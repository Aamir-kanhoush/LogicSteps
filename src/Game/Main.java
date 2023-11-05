package Game;

import java.util.Scanner;
import java.util.Set;

import static Game.Move.moveLocation;

public class Main {
    public static void main(String[] args) {
        //GameLoop();
        State state = new State(new Grid());
        state.grid.loadLevel("D:\\Intellij projects\\LogicSteps\\src\\Game\\level.txt");

        Set<State> next= State.getNextState(state);
        for (State n:next) {
            State.getNextState(n);
        }

     }




    public static void GameLoop() {
        State state = new State(new Grid());
        state.grid.loadLevel("D:\\Intellij projects\\LogicSteps\\src\\Game\\level.txt");
        Scanner scanner = new Scanner(System.in);
        int positionIndex, direction;
        state.grid.printGrid();
        state.grid.printLocations();
        while (!Rules.isWon(state)) {
            if (Rules.isStuck(state)) {
                System.out.println("Game Over!\nYou Lost");
                return;
            }
            System.out.println("Enter position index");
            positionIndex=scanner.nextInt();

            if(Move.isValidPosition(positionIndex,state)){
                System.out.println("Enter the direction to move (8 for up, 6 for right, 4 for left, 2 for down):");
                direction = scanner.nextInt();
                state=moveLocation(positionIndex,direction,state);

                    state.grid.printGrid();
                    state.grid.printLocations();

            }else {
                System.out.println("Bad index");
            }
        }
        System.out.println("YOU WIN!!!\nHURRAY!!!");
    }

}