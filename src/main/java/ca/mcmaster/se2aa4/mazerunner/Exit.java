package main.java.ca.mcmaster.se2aa4.mazerunner;
import java.util.ArrayList;

public class Exit extends MazeLocation {

    public ArrayList<Integer> getPoint() {

        return point;

    } // end of getPoint method

    public void setPoint(ArrayList<Integer> point) {

        this.point = point;

    } // end of setPoint method

    public void findExit(Maze maze) throws Exception {

        ArrayList<Integer> exitPoint = new ArrayList<>();

        // get all exits for the maze
        for (int i = 0; i < maze.getMaze().get(0).size() - 1; i++) {
            if (maze.getMaze().get(i).get(maze.getMaze().get(0).size() - 1).getCanPass()) {
                exitPoint.add(i);
            }
        } // end of for loop

        // if more than one or no exit points
        if (exitPoint.size() != 1) {
            throw new Exception("Invalid maze. Multiple or no exit points.");
        }

        exitPoint.add(maze.getMaze().get(0).size() - 1);
        this.setPoint(exitPoint);

    } // end of findExit method

} // end of Exit class