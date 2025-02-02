package main.java.ca.mcmaster.se2aa4.mazerunner;
import java.util.ArrayList;

class Exit extends MazeLocation {

    public ArrayList<Integer> getPoint() {
        return point;
    }

    public void setPoint(ArrayList<Integer> point) {
        this.point = point;
    }

    public void findExit(Maze maze) {
        ArrayList<Integer> exitPoint = new ArrayList<>();
        this.setPoint(exitPoint);
    }
}