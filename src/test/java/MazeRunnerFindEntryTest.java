package test.java;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.Order;

import java.util.ArrayList;

import main.java.ca.mcmaster.se2aa4.mazerunner.Entry;
import main.java.ca.mcmaster.se2aa4.mazerunner.Maze;

public class MazeRunnerFindEntryTest {

    Entry entry;
    Maze maze;

    @BeforeEach
    void initializeEntry() {
        maze = new Maze();
        entry = new Entry(maze);
        ArrayList<Integer> point = new ArrayList();
        point.add(3);
        point.add(0);
        entry.setPoint(point);
    }

    @Test
    @Order(1)
    void entryGeneralXCoordinate() {
        assertEquals(entry.getPoint().get(0), 3);
    }

    @Test
    @Order(2)
    void entryGeneralYCoordinate() {
        assertEquals(entry.getPoint().get(1), 0);
    }
}
