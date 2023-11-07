package Game;

import java.util.*;

import static Game.Move.moveLocation;

public class Main {
    public static void main(String[] args) {
//        GameLoop();
        State state = new State(new Grid());
        state.grid.loadLevel("D:\\Intellij projects\\LogicSteps\\src\\Game\\level.txt");
        System.out.println("start:");
        state.grid.printGrid();
        state.grid.printLocations();
        System.out.println("Game on:");
//        UCS.searchUCS(state, 2000000000);
//        BFS.searchBFS(state,2000000000);
//        DFS.searchDFS(state,2000000000);
//        Set<State> nextState = State.getNextState(state);
//        for (State obj:nextState) {
//            obj.grid.printLocations();
//            obj.grid.printGrid();
//            System.out.println("my parent state");
//            State temp=State.getParentState(obj);
//            temp.grid.printLocations();
//            temp.grid.printGrid();
//        }


    }




    public static void GameLoop() {
        State state = new State(new Grid());
        state.grid.loadLevel("D:\\Intellij projects\\LogicSteps\\src\\Game\\level2.txt");
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
                if(Move.isValidMove(positionIndex,direction,state)){
                    state=Move.moveLocation(positionIndex,direction,state);
                    state.grid.printGrid();
                    state.grid.printLocations();
                }else {
                    System.out.println("Invalid move.");
                }
            }else {
                System.out.println("Bad index");
            }
        }
        System.out.println("YOU WIN!!!\nHURRAY!!!");
    }


}