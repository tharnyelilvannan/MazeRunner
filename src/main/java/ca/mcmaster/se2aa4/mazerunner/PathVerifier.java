package main.java.ca.mcmaster.se2aa4.mazerunner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PathVerifier {

    private static final Logger logger = LogManager.getLogger();

    public Boolean verifyPath(Maze maze, Path path) {

        try {
            
            Entry entryPoint = new Entry(maze);
            Exit exitPoint = new Exit(maze);

            entryPoint.findEntry();
            exitPoint.findExit();

            String pathToVerify = path.getPath();
            int currentRow = entryPoint.getPoint().get(0);
            int currentCol = entryPoint.getPoint().get(1);

            int exitRow = exitPoint.getPoint().get(0);
            int exitCol = exitPoint.getPoint().get(1);
            Direction direction = Direction.EAST;

            // follows each instruction in path
            // if there is one invalid forward move, entire path is wrong
            for (int i = 0; i < (pathToVerify.length() - 1); i++) {

                if (Character.toString(pathToVerify.charAt(i)).equals("F")) {

                    // moves forward
                    if (direction == Direction.EAST) {
                        if (maze.getMaze().get(currentRow).get(currentCol + 1).getCanPass()) {
                            currentCol++;
                        }
                        else {
                            System.out.println("This is not a correct path");
                            return false;
                        }
                    }
                    else if (direction == Direction.WEST) {
                        if (maze.getMaze().get(currentRow).get(currentCol - 1).getCanPass()) {
                            currentCol--;
                        }
                        else {
                            System.out.println("This is not a correct path");
                            return false;
                        }
                    }
                    else if (direction == Direction.NORTH) {
                        if (maze.getMaze().get(currentRow - 1).get(currentCol).getCanPass()) {
                            currentRow--;
                        }
                        else {
                            System.out.println("This is not a correct path");
                            return false;
                        }
                    }
                    else if (direction == Direction.SOUTH) {
                        if (maze.getMaze().get(currentRow + 1).get(currentCol).getCanPass()) {
                            currentRow++;
                        }
                        else {
                            System.out.println("This is not a correct path");
                            return false;
                        }
                    }

                }
                else if (Character.toString(pathToVerify.charAt(i)).equals("R")) {

                    // turns right
                    direction = Compass.turnRight(direction);

                }
                else if (Character.toString(pathToVerify.charAt(i)).equals("L")) {

                    // turns left
                    direction = Compass.turnLeft(direction);

                }

            } // end of for loop

            // if not at exit point
            if (currentRow != exitRow || currentCol != exitCol) {

                System.out.println("This is not a correct path");
                return false;

            }

            // if at exit point
            System.out.println("This is a correct path");
            return true;
        } catch (Exception e) {
            logger.error(e.getMessage());
            return false;
        }

    } // end of verifyPath method

} // end of Path Verifier class