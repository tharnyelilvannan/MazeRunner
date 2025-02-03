package main.java.ca.mcmaster.se2aa4.mazerunner;
import java.util.ArrayList;

public class Exit extends MazeLocation {

    public ArrayList<Integer> getPoint() {
        return point;
    }

    public void setPoint(ArrayList<Integer> point) {
        this.point = point;
    }

    public void findExit(Maze maze) {
        ArrayList<Integer> exitPoint = new ArrayList<>();

        // get all valid exits for the maze
        for (int i = 0; i < maze.getMaze().get(0).size(); i++) {
            if (maze.getMaze().get(i).get(maze.getMaze().get(0).size() - 1) instanceof Pass) {
                exitPoint.add(i);
            }
        }

        this.setPoint(exitPoint);
    }
}