package main.java.ca.mcmaster.se2aa4.mazerunner;
import java.util.ArrayList;
import java.util.List;

public class Exit implements MazeLocation {

    List<Integer> point = new ArrayList<>();
    Maze maze;

    public Exit(Maze maze) {
        this.maze = maze;
    }

    public List<Integer> getPoint() {

        return point;

    } // end of getPoint method

    public void setPoint(List<Integer> point) {

        this.point = point;

    } // end of setPoint method

    public void findExit() throws Exception {

        ArrayList<Integer> exitPoint = new ArrayList<>();

        // get all exits for the maze
        for (int i = 0; i < this.maze.getMaze().size() - 1; i++) {
            if (this.maze.getMaze().get(i).get(this.maze.getMaze().get(0).size() - 1).getCanPass()) {
                exitPoint.add(i);
            }
        } // end of for loop

        // if more than one or no exit points
        if (exitPoint.size() != 1) {
            throw new Exception("Invalid maze. Multiple or no exit points.");
        }

        exitPoint.add(this.maze.getMaze().get(0).size() - 1);
        this.setPoint(exitPoint);

    } // end of findExit method

} // end of Exit class