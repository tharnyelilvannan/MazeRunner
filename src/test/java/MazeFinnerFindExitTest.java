package test.java;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import main.java.ca.mcmaster.se2aa4.mazerunner.Exit;
public class MazeFinnerFindExitTest {
    Exit exit;

    @BeforeEach
    void initializeExit() {
        exit = new Exit();
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