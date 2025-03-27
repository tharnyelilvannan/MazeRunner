package main.java.ca.mcmaster.se2aa4.mazerunner;

import java.util.ArrayList;

public class RightHandRuleExplorer extends Explorer {

    public RightHandRuleExplorer(Maze maze) {
        super(maze);
    }

    // sets canonical path
    public String findPath()
    {
        Compass compass = new Compass();
       
        int entryRow = entryPoint.get(0);
        int entryCol = entryPoint.get(1);
        int exitRow = exitPoint.get(0);
        int exitCol = exitPoint.get(1);

        // sets current position as entry point
        int currentRow = entryRow;
        int currentCol = entryCol;
        Direction rightHandWall = Direction.SOUTH;

        // make first move, almost always move forward eastward
        canonPath = canonPath + "F";
        currentCol++;

        // declare direction
        Boolean north;
        Boolean east;
        Boolean south;
        Boolean west;

        // explore until end of maze
        // algorithm partially inspired by: https://cs.stanford.edu/people/eroberts/courses/cs106b/handouts/16-RecursiveBacktracking.pdf
        while (currentRow != exitRow || currentCol != exitCol) {

            try {

                if (currentRow != 0 && currentRow != maze.getMaze().size() && currentCol != 0 && currentCol != maze.getMaze().get(0).size()) {

                    // get the values of each path ahead
                    north = maze.getMaze().get(currentRow - 1).get(currentCol).getCanPass();
                    east = maze.getMaze().get(currentRow).get(currentCol + 1).getCanPass();
                    south = maze.getMaze().get(currentRow + 1).get(currentCol).getCanPass();
                    west = maze.getMaze().get(currentRow).get(currentCol - 1).getCanPass();

                    // follow right hand rule
                    if (rightHandWall == Direction.SOUTH && !south && east) {
                        currentCol++;
                        canonPath = canonPath + "F";
                    }
                    else if (rightHandWall == Direction.NORTH && !north && west) {
                        currentCol--;
                        canonPath = canonPath + "F";
                    }
                    else if (rightHandWall == Direction.EAST && !east && north) {
                        currentRow--;
                        canonPath = canonPath + "F";
                    }
                    else if (rightHandWall == Direction.WEST && !west && south) {
                        currentRow++;
                        canonPath = canonPath + "F";
                    }
                    else if (rightHandWall == Direction.SOUTH && !south && !east) {
                        canonPath = canonPath + "L";
                        rightHandWall = Direction.EAST;
                    }
                    else if (rightHandWall == Direction.NORTH && !north && !west) {
                        canonPath = canonPath + "L";
                        rightHandWall = Direction.WEST;
                    }
                    else if (rightHandWall == Direction.EAST && !east && !north) {
                        canonPath = canonPath + "L";
                        rightHandWall = Direction.NORTH;
                    }
                    else if (rightHandWall == Direction.WEST && !west && !south) {
                        canonPath = canonPath + "L";
                        rightHandWall = Direction.SOUTH;
                    }
                    else if (rightHandWall == Direction.SOUTH && south) {
                        canonPath = canonPath + "RF";
                        rightHandWall = Direction.WEST;
                        currentRow++;
                    }
                    else if (rightHandWall == Direction.NORTH && north) {
                        canonPath = canonPath + "RF";
                        rightHandWall = Direction.EAST;
                        currentRow--;
                    }
                    else if (rightHandWall == Direction.EAST && east) {
                        canonPath = canonPath + "RF";
                        rightHandWall = Direction.SOUTH;
                        currentCol++;
                    }
                    else if (rightHandWall == Direction.WEST && west) {
                        canonPath = canonPath + "RF";
                        rightHandWall = Direction.NORTH;
                        currentCol--;
                    }
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        } // end of while loop

        return canonPath;

    } // end of explore method

} // end of RightHandRuleExplorer class