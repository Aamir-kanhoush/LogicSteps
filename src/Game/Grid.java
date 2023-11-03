package Game;

import java.util.ArrayList;
import java.io.*;
import java.util.Scanner;

public class Grid {
    public int rows, columns;
    public int[][] grid;
    public ArrayList<Coordinate> positions;


    public void loadLevel(String filepath) {
        try {
            Scanner scanner = new Scanner(new File(filepath));

            rows = scanner.nextInt();
            columns = scanner.nextInt();

            grid = new int[rows][columns];

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    grid[i][j] = scanner.nextInt();
                }
            }


            positions = new ArrayList<>();
            while (scanner.hasNext()) {
                int x = scanner.nextInt();
                int y = scanner.nextInt();
                positions.add(new Coordinate(x, y));
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error loading the level from the file: " + filepath);
        }
    }


    public void printGrid() {
        System.out.println();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void printLocations() {
        System.out.println("Locations:");
        for (int i = 0; i < positions.size(); i++) {
            Coordinate location = positions.get(i);
            System.out.println("Location #" + i + ":\nX: " + location.getX() + ", Y: " + location.getY());
        }
    }

}