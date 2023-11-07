package Game;

import java.util.*;

public class RDFS {
    private static Set<State> visitedStates = new HashSet<>();

    public static void searchRDFS(State initialState, int maxDepth) {
        visitedStates.clear();
        searchDFSRecursive(initialState, maxDepth, 0);
    }

    private static void searchDFSRecursive(State currentState, int maxDepth, int currentDepth) {
        if (currentDepth > maxDepth) {
            System.out.println("No winning state found within the specified depth");
            return;
        }
        currentState.grid.printLocations();
        currentState.grid.printGrid();
        if (Rules.isWon(currentState)) {
            System.out.println("Winning state found: " + currentState);
            printSteps(currentState);
            return;
        }
        visitedStates.add(currentState);
        Set<State> nextStates = State.getNextState(currentState);
        for (State nextState : nextStates) {
            if (!visitedStates.contains(nextState)) {
                visitedStates.add(nextState);
                searchDFSRecursive(nextState, maxDepth, currentDepth + 1);
            }
        }
    }

    private static void printSteps(State state) {
        Stack<State> stack = new Stack<>();
        State currentState = state;
        while (currentState != null) {
            stack.push(currentState);
            currentState = State.getParentState(currentState);
        }
        System.out.println("Steps to reach the winning state:");
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }
}
