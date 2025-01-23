package main.java.ca.mcmaster.se2aa4.mazerunner;

import java.io.BufferedReader;
import java.util.ArrayList;
import org.apache.logging.log4j.Logger;
import java.io.FileReader;
import java.util.ArrayList;

public class Maze {

    private Explorer explorer = new Explorer();
    private ArrayList<ArrayList<Integer>> maze = new ArrayList<>();

    @SuppressWarnings({"UseSpecificCatch", "Convert2Diamond"})
    public Maze(Logger logger, BufferedReader reader) {

        String line;
        int k = 0;

        try {

            while ((line = reader.readLine()) != null) {

                maze.add(new ArrayList<>());

                for (int i = 0; i < line.length(); i++) {

                    if (line.charAt(i) == '#') {
                        maze.get(k).add(1);
                    } else if (line.charAt(i) == ' ') {
                        maze.get(k).add(0);
                    }

                }

                k++;

            }
            
            for (int i = 0; i < maze.size(); i++) {
                System.out.println(maze.get(i));
            }

        } catch (Exception e) {

            logger.error(e.getMessage());

        }

        explorer.identifyEntryPoint(maze);
                
    } // end of Maze constructor method

    public ArrayList<ArrayList<Integer>> getMaze() {

        return maze;

    } // end of getMaze method

    public String calculatePath() {

        return "";
        
    }
    
} // end of Maze class