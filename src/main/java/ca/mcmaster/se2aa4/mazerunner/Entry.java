package main.java.ca.mcmaster.se2aa4.mazerunner;

import java.util.ArrayList;

public class Entry extends MazeLocation {

    public ArrayList<Integer> getPoint() {
        return point;
    }

    public void setPoint(ArrayList<Integer> point) {
        this.point = point;
    }

    public void findEntry(Maze maze) throws Exception {
        ArrayList<Integer> entryPoint = new ArrayList<>();

        for (int i = 0; i < maze.getMaze().get(0).size() - 1 ; i++) {
            if (maze.getMaze().get(i).get(0) instanceof Pass) {
                entryPoint.add(i);
            }
        }

        if (entryPoint.size() > 1) {
            throw new Exception("Invalid maze. Multiple entry points.");
        }

        // point has coordinates (i, 0)
        entryPoint.add(0);

        this.setPoint(entryPoint);
    }
}