package main.java.ca.mcmaster.se2aa4.mazerunner;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.io.FileReader;
import java.util.ArrayList;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Maze {

    private ArrayList<ArrayList<MazeComposition>> maze = new ArrayList<>();
    private static final Logger logger = LogManager.getLogger();

    public Maze(String file) {

        String line;
        int k = 0;

        try {

            BufferedReader reader = new BufferedReader(new FileReader(file));

            while ((line = reader.readLine()) != null) {

                maze.add(new ArrayList<>());

                for (int i = 0; i < line.length(); i++) {

                    if (line.charAt(i) == '#') {
                        MazeComposition mazePart = new Wall();
                        maze.get(k).add(mazePart);
                    } else if (line.charAt(i) == ' ') {
                        MazeComposition mazePart = new Pass();
                        maze.get(k).add(mazePart);
                    }

                }

                k++;

            }
            
            logger.info("** Maze successfully read **");

        } catch (Exception e) {

            logger.error(e.getMessage());

        }
                
    } // end of Maze constructor method

    public ArrayList<ArrayList<MazeComposition>> getMaze() {

        return maze;

    } // end of getMaze method

    public String calculatePath() {

        return "";
        
    }
    
} // end of Maze class,9pioi