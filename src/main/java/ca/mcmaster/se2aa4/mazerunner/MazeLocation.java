package main.java.ca.mcmaster.se2aa4.mazerunner;

import java.util.ArrayList;

abstract class MazeLocation {

    // coordinates of the location
    protected ArrayList<Integer> point;

    abstract public ArrayList<Integer> getPoint();

    abstract public void setPoint(ArrayList<Integer> point);

} // end of MazeLocation class