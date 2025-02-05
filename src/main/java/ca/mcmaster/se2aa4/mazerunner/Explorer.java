package main.java.ca.mcmaster.se2aa4.mazerunner;

import main.java.ca.mcmaster.se2aa4.mazerunner.Maze;
import main.java.ca.mcmaster.se2aa4.mazerunner.Entry;
import main.java.ca.mcmaster.se2aa4.mazerunner.Exit;
import main.java.ca.mcmaster.se2aa4.mazerunner.Path;

import java.util.ArrayList;

public class Explorer {

    // sets canonical path
    public void explore(Maze maze, Entry entryPoint, Exit exitPoint, Path path) throws Exception
    {
        String canonPath = "";

        ArrayList<Integer> entry = new ArrayList<>(entryPoint.getPoint());
        ArrayList<Integer> exit = new ArrayList<>(exitPoint.getPoint());
       
        int entryRow = entry.get(0);
        int entryCol = entry.get(1);
        int exitRow = exit.get(0);
        int exitCol = exit.get(1);

        ArrayList<Integer> currentPosition = new ArrayList<>();
        currentPosition.add(entryRow);
        currentPosition.add(entryCol);

        path.setPath(canonPath);

    } // end of explore method

} // end of Explorer class