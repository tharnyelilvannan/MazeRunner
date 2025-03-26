package main.java.ca.mcmaster.se2aa4.mazerunner;

import java.util.ArrayList;

public class Entry extends MazeLocation {

    private static Entry instance = null;

    private Entry() {
    }

    public static Entry get() {
        if (instance == null) {
            instance = new Entry();
        }
        return instance;
    }

    public ArrayList<Integer> getPoint() {

        return point;

    } // end of getPoint method

    public void setPoint(ArrayList<Integer> point) {

        this.point = point;

    } // end of setPoint method

    public void findEntry() throws Exception {
        Maze maze = Maze.get();

        ArrayList<Integer> entryPoint = new ArrayList<>();
        int mazeSize = maze.getMaze().size() - 1;

        for (int i = 0; i < mazeSize; i++) {
            if (maze.getMaze().get(i).get(0).getCanPass()) {
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