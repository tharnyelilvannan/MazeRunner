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
                north = maze.getMaze().get(currentRow - 1).get(currentCol).getCanPass();
                east = maze.getMaze().get(currentRow).get(currentCol + 1).getCanPass();
                south = maze.getMaze().get(currentRow + 1).get(currentCol).getCanPass();
                west = maze.getMaze().get(currentRow).get(currentCol - 1).getCanPass();
            } catch (Exception e) {

            }


        } // end of while loop

        return canonPath;

    } // end of explore method

} // end of RightHandRuleExplorer class