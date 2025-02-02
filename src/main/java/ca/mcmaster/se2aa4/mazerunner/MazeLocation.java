package main.java.ca.mcmaster.se2aa4.mazerunner;

import java.util.ArrayList;

abstract class MazeLocation {
    protected ArrayList<Integer> point;

    abstract public ArrayList<Integer> getPoint();
    abstract public void setPoint(ArrayList<Integer> point);
}