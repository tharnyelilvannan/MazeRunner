package main.java.ca.mcmaster.se2aa4.mazerunner;

import main.java.ca.mcmaster.se2aa4.mazerunner.Maze;
import main.java.ca.mcmaster.se2aa4.mazerunner.Entry;
import main.java.ca.mcmaster.se2aa4.mazerunner.Exit;
import main.java.ca.mcmaster.se2aa4.mazerunner.Path;

import java.util.ArrayList;

public class Explorer {

    // returns canonical path
    public void explore(Maze maze, Entry entryPoint, Exit exitPoint, Path path) throws Exception
    {
        String canonPath = "";

        ArrayList<Integer> entry = new ArrayList<>(entryPoint.getPoint());
        ArrayList<Integer> exit = new ArrayList<>(exitPoint.getPoint());

        if (entry.size() > 1 || exit.size() > 1) {
            // if more than one entrance or exit
            throw new Exception("Invalid maze.");
        }

        int row = entry.get(0);
        int col = 0;
        System.out.println(row);
        ArrayList<Integer> currentPosition = new ArrayList<>();
        currentPosition.add(row);
        currentPosition.add(col);

        while (!(currentPosition.get(0) == exit.get(0)) && !(currentPosition.get(1) == (maze.getMaze().size() - 1))) {

        }
    
        path.setPath(canonPath);

    } // end of explore method

    public void verifyPath(Maze maze, Entry entryPoint, Exit exit, String path) {

    }

} // end of Explorer class