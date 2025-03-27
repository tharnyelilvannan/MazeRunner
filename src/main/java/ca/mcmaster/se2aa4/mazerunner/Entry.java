package main.java.ca.mcmaster.se2aa4.mazerunner;

import java.util.ArrayList;
import java.util.List;

public class Entry implements MazeLocation {

    List<Integer> point = new ArrayList<>();
    Maze maze;

    public Entry(Maze maze) {
        this.maze = maze;
    }

    public List<Integer> getPoint() {

        return point;

    } // end of getPoint method

    public void setPoint(List<Integer> point) {

        this.point = point;

    } // end of setPoint method

    public void findEntry() throws Exception {

        ArrayList<Integer> entryPoint = new ArrayList<>();
        int mazeSize = this.maze.getMaze().size() - 1;

        for (int i = 0; i < mazeSize; i++) {
            if (this.maze.getMaze().get(i).get(0).getCanPass()) {
                entryPoint.add(i);
            }
        }

        // if more than one entry point or none
        if (entryPoint.size() != 1) {
            throw new Exception("Invalid maze. Multiple or no entry points.");
        }

        // point has coordinates (i, 0)
        entryPoint.add(0);

        this.setPoint(entryPoint);

    } // end of findEntry method

} // end of Entry class