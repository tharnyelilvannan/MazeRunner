package main.java.ca.mcmaster.se2aa4.mazerunner;

import main.java.ca.mcmaster.se2aa4.mazerunner.Maze;
import java.util.ArrayList;

public class Explorer {

    public Explorer() {

    } // end of Explorer constructor method

    // returns canonical path
    public String explore(ArrayList<ArrayList<Integer>> maze, ArrayList<Integer> entryPoints) {
        String path = "";

        // does only the straight path 
        for (int i = 0; i < maze.size(); i++) {
            if (maze.get(entryPoints.get(0)).get(i) == 0) {
                path = path + "F";
            }
        }

        return path;

    } // end of explore method

    public String factorizePath(String path) {
        return "";
    } // end of factorize path method

    public ArrayList<Integer> identifyEntryPoint(ArrayList<ArrayList<Integer>> maze) {

        ArrayList entryPoints = new ArrayList<Integer>();
        
        for (int i = 0; i < maze.size(); i++) {
            if (maze.get(i).get(0) == 0) {
                entryPoints.add(i);
            }
        }

        return entryPoints;

    } // end of identifyEntryPoint method

} // end of Explorer class