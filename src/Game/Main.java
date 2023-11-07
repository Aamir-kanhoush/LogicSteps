package Game;

import java.util.*;


public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        State state = new State(new Grid());
        state.grid.loadLevel("D:\\Intellij projects\\LogicSteps\\src\\Game\\level.txt");
        System.out.println("Available Modes:\nhmn: You play the game\nbfs: solve the game using bfs\ndfs: solve the game using dfs\nucs: solve the game using ucs\nEnter game mode:");
        String Mode=scanner.next();
        switch (Mode){
            case "hmn":
                System.out.println("Human is on the game");
                GameLoop(state,scanner);

            case "bfs":
                System.out.println("BFS is on the game");
                BFS.searchBFS(state,1000);

            case "dfs":
                System.out.println("DFS is on the game");
                BFS.searchBFS(state,1000);

            case "UCS":
                System.out.println("UCS is on the game");
                UCS.searchUCS(state,1000);
        }






    }




    public static void GameLoop(State state,Scanner scanner) {
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