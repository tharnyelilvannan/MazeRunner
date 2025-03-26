package test.java;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.TestMethodOrder;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import main.java.ca.mcmaster.se2aa4.mazerunner.Exit;

public class MazeRunnerFindExitTest {
    Exit exit;

    @BeforeEach
    void initializeExit() {
        exit = Exit.get();
        ArrayList<Integer> point = new ArrayList();
        point.add(6);
        point.add(5);
        exit.setPoint(point);
    }

    @Test
    @Order(1)
    void exitGeneralXCoordinate() {
        assertEquals(exit.getPoint().get(0), 6);
    }

    @Test
    @Order(2)
    void exitGeneralYCoordinate() {
        assertEquals(exit.getPoint().get(1), 5);
    }

}