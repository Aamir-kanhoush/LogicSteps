package Game;
import java.util.*;
public class HC {

    public static void searchHillClimbing(State initialState, int maxDepth) {
        int depth = 0;
        int visitedCount = 0;
        while (depth < maxDepth) {
            System.out.println("Depth: " + depth);
            initialState.grid.printGrid();
            initialState.grid.printLocations();
            Set<State> nextStates = State.getNextState(initialState);
            Coordinate movedCoordinate = getMovedCoordinate(State.getParentState(initialState),initialState);
            int moveCost = movedCoordinate != null ? movedCoordinate.getCost() : 0;
            System.out.println("Heuristic value: " + heuristicValue(initialState, moveCost));
            State bestState = null;
            int bestCount = Integer.MAX_VALUE;
            for (State state : nextStates) {
                visitedCount++;
                if (state != null && state.grid != null) {
                    movedCoordinate = getMovedCoordinate(state, initialState);
                    int moveCostForNextState = movedCoordinate != null ? movedCoordinate.getCost() : 0;
                    int count = heuristicValue(state, moveCostForNextState);
                    if (count < bestCount) {
                        bestState = state;
                        bestCount = count;
                    }
                }
            }
            if (bestState == null) {
                break;
            }
            initialState = bestState;
            depth++;
        }
        System.out.println("Maximum found (it may be local):");
        System.out.println("Number of visited states: " + visitedCount);
        printSteps(initialState, depth);
    }

    private static int heuristicValue(State state, int moveCost) {
        int count = 0;
        Grid grid = state.grid;
        for (int i = 0; i < grid.rows; i++) {
            for (int j = 0; j < grid.columns; j++) {
                if (grid.grid[i][j] != 0 && grid.grid[i][j] != 5) {
                    count++;
                }
            }
        }
        count += moveCost;
        return count;
    }

    private static Coordinate getMovedCoordinate(State currentState, State nextState) {
        if (currentState == null) {
            return null;
        }
        ArrayList<Coordinate> currentCoordinates = currentState.grid.positions;
        ArrayList<Coordinate> nextCoordinates = nextState.grid.positions;

        for (Coordinate nextCoordinate : nextCoordinates) {
            if (!currentCoordinates.contains(nextCoordinate)) {
                return nextCoordinate;
            }
        }

        return null;
    }


    private static void printSteps(State state, int depth) {
        LinkedList<State> stack = new LinkedList<>();
        State currentState = state;
        while (currentState != null) {
            stack.push(currentState);
            currentState = State.getParentState(currentState);
        }
        System.out.println("Steps to reach the winning state:");
        while (!stack.isEmpty()) {
            State step = stack.pop();
            System.out.println(step);
            step.grid.printGrid();
            Coordinate movedCoordinate = getMovedCoordinate(step, state);
            int moveCost = movedCoordinate != null ? movedCoordinate.getCost() : 0;
            int heuristic = heuristicValue(step, moveCost);
            System.out.println("Heuristic value: " + heuristic);
            System.out.println("Depth: " + (depth - stack.size()));
        }
    }
}
