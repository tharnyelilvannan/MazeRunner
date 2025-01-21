package main.java.ca.mcmaster.se2aa4.mazerunner;

import org.apache.logging.log4j.Logger;

public class Maze {

    Explorer explorer = new Explorer();
    int[][] maze;

    public Maze(String file, Logger logger) {
                
    } // end of Maze constructor method

    public int[][] getMaze() {
        return maze;
    } // end of getMaze method

    public String calculatePath() {
        return "";
    }
    
} // end of Maze class