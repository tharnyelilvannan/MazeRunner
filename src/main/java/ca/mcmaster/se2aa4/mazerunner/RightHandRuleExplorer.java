package main.java.ca.mcmaster.se2aa4.mazerunner;

import main.java.ca.mcmaster.se2aa4.mazerunner.Maze;
import main.java.ca.mcmaster.se2aa4.mazerunner.Entry;
import main.java.ca.mcmaster.se2aa4.mazerunner.Exit;
import main.java.ca.mcmaster.se2aa4.mazerunner.Path;
import main.java.ca.mcmaster.se2aa4.mazerunner.Explorer;

import java.util.ArrayList;

public class RightHandRuleExplorer extends Explorer {

    // sets canonical path
    public String explore(Maze maze, Entry entryPoint, Exit exitPoint)
    {
        String canonPath = "";

        Compass compass = new Compass();

        ArrayList<Integer> entry = new ArrayList<>(entryPoint.getPoint());
        ArrayList<Integer> exit = new ArrayList<>(exitPoint.getPoint());
       
        int entryRow = entry.get(0);
        int entryCol = entry.get(1);
        int exitRow = exit.get(0);
        int exitCol = exit.get(1);

        // sets current position as entry point
        int currentRow = entryRow;
        int currentCol = entryCol;
        Direction direction = Direction.EAST;

        // sets location for the "fork in the road"
        int forkRow = entryRow;
        int forkCol = entryCol;
        Direction forkDirection = Direction.EAST;

        Boolean north;
        Boolean east;
        Boolean south;
        Boolean west;

        // explore until end of maze
        while (currentRow != exitRow || currentCol != exitCol) {

            try {
                if (currentRow != 0 && currentRow != maze.getMaze().size()) {
                    north = maze.getMaze().get(currentRow - 1).get(currentCol).getCanPass();
                    east = maze.getMaze().get(currentRow).get(currentCol + 1).getCanPass();
                    south = maze.getMaze().get(currentRow + 1).get(currentCol).getCanPass();
                    west = maze.getMaze().get(currentRow).get(currentCol - 1).getCanPass();

                    if (!north && !south && east) {
                        // go east
                        currentCol++;

                        if (direction == Direction.EAST) {
                            canonPath = canonPath + "F";
                        }
                        else if (direction ==  Direction.NORTH) {
                            direction = compass.turnRight(direction);
                            canonPath = canonPath + "RF";
                        }
                        else if (direction == Direction.SOUTH) {
                            direction = compass.turnLeft(direction);
                            canonPath = canonPath + "LF";
                        }
                        else if (direction == Direction.WEST) {
                            direction = compass.turnLeft(direction);
                            direction = compass.turnLeft(direction);
                            canonPath = canonPath + "LLF";
                        }
                    }
                    else if (!south && !east && north) {
                        // go north
                        currentRow--;

                        if (direction == Direction.NORTH) {
                            canonPath = canonPath + "F";
                        }
                        else if (direction == Direction.SOUTH) {
                            direction = compass.turnRight(direction);
                            direction = compass.turnRight(direction);
                            canonPath = canonPath + "RRF";

                        }
                        else if (direction == Direction.EAST) {
                            direction = compass.turnLeft(direction);
                            canonPath = canonPath + "LF";
                        }
                        else if (direction == Direction.WEST) {
                            direction = compass.turnRight(direction);
                            canonPath = canonPath + "RF";
                        }
                    }
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }


        } // end of while loop

        return canonPath;

    } // end of explore method

} // end of RightHandRuleExplorer class