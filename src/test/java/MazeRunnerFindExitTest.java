package test.java;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import main.java.ca.mcmaster.se2aa4.mazerunner.Exit;
import main.java.ca.mcmaster.se2aa4.mazerunner.Maze;

public class MazeRunnerFindExitTest {
    Exit exit;
    Maze maze;

    @BeforeEach
    void initializeExit() {
        maze = new Maze();
        exit = new Exit(maze);
        ArrayList<Integer> point = new ArrayList();
        point.add(6);
        point.add(5);
        exit.setPoint(point);
    }

    @Test
    void exitGeneralXCoordinate() {
        assertEquals(exit.getPoint().get(0), 6);
    }

    @Test
    void exitGeneralYCoordinate() {
        assertEquals(exit.getPoint().get(1), 5);
    }

}