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
        Direction direction = Direction.EAST;

        ArrayList<Integer> entry = new ArrayList<>(entryPoint.getPoint());
        ArrayList<Integer> exit = new ArrayList<>(exitPoint.getPoint());

        if (entry.size() > 1 || exit.size() > 1) {
            // if more than one entrance or exit
            throw new Exception("Invalid maze.");
        }
        
        int row = entry.get(0);
        int col = 0;
        int exitRow = exit.get(0);
        int exitCol = maze.getMaze().get(0).size() - 1;

        ArrayList<Integer> currentPosition = new ArrayList<>();
        currentPosition.add(row);
        currentPosition.add(col);
        System.out.println(exitRow);
        System.out.println(exitCol);

        while (currentPosition.get(0) != exitRow || currentPosition.get(1) != exitCol) {
            System.out.println(direction);
            System.out.println(currentPosition);
            try {
                if (direction == Direction.EAST) {

                    if (maze.getMaze().get(currentPosition.get(0)).get(currentPosition.get(1) + 1) instanceof Pass) {
                        currentPosition.set(1, currentPosition.get(1) + 1);
                        canonPath = canonPath + "F";
                    }
                    else if (maze.getMaze().get(currentPosition.get(0) + 1).get(currentPosition.get(1)) instanceof Pass) {
                        currentPosition.set(0, currentPosition.get(0) + 1);
                        canonPath = canonPath + "RF";
                        direction = Direction.SOUTH;
                    }
                    else if (maze.getMaze().get(currentPosition.get(0) - 1).get(currentPosition.get(1)) instanceof Pass) {
                        currentPosition.set(0, currentPosition.get(0) - 1);
                        canonPath = canonPath + "LF";
                        direction = Direction.NORTH;
                    }
                    else if (maze.getMaze().get(currentPosition.get(0)).get(currentPosition.get(1) - 1) instanceof Pass) {
                        currentPosition.set(1, currentPosition.get(1) - 1);
                        canonPath = canonPath + "RRF";
                        direction = Direction.WEST;
                    }

                }
                else if (direction == Direction.SOUTH) {

                    if (maze.getMaze().get(currentPosition.get(0) + 1).get(currentPosition.get(1)) instanceof Pass) {
                        currentPosition.set(0, currentPosition.get(0) + 1);
                        canonPath = canonPath + "F";
                    }
                    else if (maze.getMaze().get(currentPosition.get(0)).get(currentPosition.get(1) + 1) instanceof Pass) {
                        currentPosition.set(1, currentPosition.get(1) + 1);
                        canonPath = canonPath + "LF";
                        direction = Direction.EAST;
                    }
                    else if (maze.getMaze().get(currentPosition.get(0)).get(currentPosition.get(1) - 1) instanceof Pass) {
                        currentPosition.set(1, currentPosition.get(1) - 1);
                        canonPath = canonPath + "RF";
                        direction = Direction.WEST;
                    }
                    else if (maze.getMaze().get(currentPosition.get(0) - 1).get(currentPosition.get(1)) instanceof Pass) {
                        currentPosition.set(0, currentPosition.get(0) - 1);
                        canonPath = canonPath + "RRF";
                        direction = Direction.NORTH;
                    }

                }
                else if (direction == Direction.WEST) {

                    if (maze.getMaze().get(currentPosition.get(0)).get(currentPosition.get(1) - 1) instanceof Pass) {
                        currentPosition.set(1, currentPosition.get(1) - 1);
                        canonPath = canonPath + "F";
                    }
                    else if (maze.getMaze().get(currentPosition.get(0) - 1).get(currentPosition.get(1)) instanceof Pass) {
                        currentPosition.set(0, currentPosition.get(0) - 1);
                        canonPath = canonPath + "LF";
                        direction = Direction.SOUTH;
                    }
                    else if (maze.getMaze().get(currentPosition.get(0) + 1).get(currentPosition.get(1)) instanceof Pass) {
                        currentPosition.set(0, currentPosition.get(0) + 1);
                        canonPath = canonPath + "RF";
                        direction = Direction.NORTH;
                    }
                    else if (maze.getMaze().get(currentPosition.get(0)).get(currentPosition.get(1) + 1) instanceof Pass) {
                        currentPosition.set(0, currentPosition.get(1) + 1);
                        canonPath = canonPath + "RRF";
                        direction = Direction.EAST;
                    }

                }
                else if (direction == Direction.NORTH) {

                    if (maze.getMaze().get(currentPosition.get(0) - 1).get(currentPosition.get(1)) instanceof Pass) {
                        currentPosition.set(0, currentPosition.get(0) - 1);
                        canonPath = canonPath + "F";
                    }
                    else if (maze.getMaze().get(currentPosition.get(0)).get(currentPosition.get(1) - 1) instanceof Pass) {
                        currentPosition.set(1, currentPosition.get(1) - 1);
                        canonPath = canonPath + "LF";
                        direction = Direction.WEST;
                    }
                    else if (maze.getMaze().get(currentPosition.get(0)).get(currentPosition.get(1) + 1) instanceof Pass) {
                        currentPosition.set(1, currentPosition.get(1) + 1);
                        canonPath = canonPath + "RF";
                        direction = Direction.EAST;
                    }
                    else if (maze.getMaze().get(currentPosition.get(0) + 1).get(currentPosition.get(1)) instanceof Pass) {
                        currentPosition.set(0, currentPosition.get(0) + 1);
                        canonPath = canonPath + "RRF";
                        direction = Direction.SOUTH;
                    }

                }
            } catch (Exception e) {
                direction = Direction.EAST;
            }

        }
        
        canonPath = canonPath + "F";
        System.out.println(canonPath);
        path.setPath(canonPath);

    } // end of explore method

    public void verifyPath(Maze maze, Entry entryPoint, Exit exit, String path) {

    }

} // end of Explorer class