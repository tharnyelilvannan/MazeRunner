package main.java.ca.mcmaster.se2aa4.mazerunner;
import java.util.ArrayList;

public class Exit extends MazeLocation {

    public ArrayList<Integer> getPoint() {
        return point;
    }

    public void setPoint(ArrayList<Integer> point) {
        this.point = point;
    }

    public void findExit(Maze maze) throws Exception {
        ArrayList<Integer> exitPoint = new ArrayList<>();

        // get all exits for the maze
        for (int i = 0; i < maze.getMaze().get(0).size() - 1; i++) {
            if (maze.getMaze().get(i).get(maze.getMaze().get(0).size() - 1) instanceof Pass) {
                exitPoint.add(i);
            }
        }

        if (exitPoint.size() > 1) {
            throw new Exception("Invalid maze. Multiple exit points.");
        }

        exitPoint.add(maze.getMaze().get(0).size() - 1);
        this.setPoint(exitPoint);
    }
}