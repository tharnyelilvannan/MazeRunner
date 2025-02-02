package main.java.ca.mcmaster.se2aa4.mazerunner;

import java.util.ArrayList;

class Entry extends MazeLocation {

    public ArrayList<Integer> getPoint() {
        return point;
    }

    public void setPoint(ArrayList<Integer> point) {
        this.point = point;
    }

    public void findEntry(Maze maze) {
        ArrayList<Integer> entryPoint = new ArrayList<>();
        this.setPoint(entryPoint);
    }
}