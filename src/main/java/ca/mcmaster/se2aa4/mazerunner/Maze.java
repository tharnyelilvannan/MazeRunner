package main.java.ca.mcmaster.se2aa4.mazerunner;

import java.io.BufferedReader;
import org.apache.logging.log4j.Logger;
import java.io.FileReader;
import java.util.ArrayList;

public class Maze {

    private Explorer explorer = new Explorer();
    private ArrayList<ArrayList<Integer>>  maze = new ArrayList<>();

    public Maze(Logger logger, BufferedReader reader) {

        String line;

        try {
            while ((line = reader.readLine()) != null) {
                for (int i = 0; i < line.length(); i++) {
                    maze.add(new ArrayList<Integer>());
                    if (line.charAt(i) == '#') {
                        maze.get(i).add(1);
                    } else if (line.charAt(i) == ' ') {
                        maze.get(i).add(0);
                    }
                }
            }
            System.out.println(maze);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
                
    } // end of Maze constructor method

    public ArrayList<ArrayList<Integer>> getMaze() {
        return maze;
    } // end of getMaze method

    public String calculatePath() {
        return "";
    }
    
} // end of Maze class