package main.java.ca.mcmaster.se2aa4.mazerunner;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.io.FileReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Maze extends Subject {

    private ArrayList<ArrayList<MazeComposition>> maze = new ArrayList<>();
    private static final Logger logger = LogManager.getLogger();


    public void setMaze(String file) {

        this.maze.clear();

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

                } // end of for loop

                k++;

            } // end of while loop
            
            logger.info("** Maze successfully read **");

        } catch (Exception e) {

            logger.error(e.getMessage());

        }
        notifyExplorer();
                
    } // end of Maze method

    public ArrayList<ArrayList<MazeComposition>> getMaze() {

        return this.maze;

    } // end of getMaze method
    
} // end of Maze class