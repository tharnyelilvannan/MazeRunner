package main.java.ca.mcmaster.se2aa4.mazerunner;

import java.util.ArrayList;
import java.util.List;

interface MazeLocation {

    abstract public List<Integer> getPoint();

    abstract public void setPoint(List<Integer> point);

} // end of MazeLocation class