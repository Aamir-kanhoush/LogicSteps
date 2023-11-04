package Game;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class State {
    public Grid grid;

    public State(Grid grid) {
        this.grid = grid;
    }

    @Override
    public boolean equals(Object object){
        if (this==object)
            return true;
        if (object == null || getClass() != object.getClass())
            return false;
        State state=(State) object;
        List<Coordinate> thisPositionsSorted = new ArrayList<>(this.grid.positions);
        List<Coordinate> objectPositionsSorted = new ArrayList<>(state.grid.positions);
        Collections.sort(thisPositionsSorted);
        Collections.sort(objectPositionsSorted);
        return Arrays.deepEquals(this.grid.grid, state.grid.grid)
                && thisPositionsSorted.equals(objectPositionsSorted);
    }

    @Override
    public String toString() {
        StringBuilder string= new StringBuilder();
        for (int i=0;i<grid.positions.size();i++) {
            int x=grid.positions.get(i).getX()+1;
            int y=grid.positions.get(i).getY()+1;
            string.append("(").append(x).append(",").append(y).append(")");
        }
        return string.toString();
    }
    @Override
    public int hashCode() {
        return toString().hashCode();
    }

    //public static ArrayList<State> getNextState(Grid grid){
    //        ArrayList<State>nextState=new ArrayList<>();
    //        for (int i=0;i <grid.positions.size();i++){
    //        Move.moveLocation(i,2,grid);
    //        }
    //    }

}