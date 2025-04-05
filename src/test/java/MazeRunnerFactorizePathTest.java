package test.java;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;

import main.java.ca.mcmaster.se2aa4.mazerunner.Path;

public class MazeRunnerFactorizePathTest {
    Path path;

    @BeforeEach
    void initializePath() {
        path = new Path();
    }

    @Test
    void factorizePathNothing() {
        path.factorizePath();
        assertEquals(path.getPath(), ""); 
    }

    @Test
    void factorizePathGeneralTest() {
        path.setPath("FFFFFFFFRRRRLLLLLL");
        path.factorizePath();
        assertEquals(path.getPath(), " 8F 4R 6L");
    }

    @Test
    void factorizePathBoundaryTest() {
        path.setPath("F");
        path.factorizePath();
        assertEquals(path.getPath(), " 1F");
    }

    @Test
    void factorizePathBoundaryEmptyTest() {
        path.setPath("");
        path.factorizePath();
        assertEquals(path.getPath(), "");
    }

    @Test
    void factorizePathOnlyForwardTest() {
        path.setPath("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF");
        path.factorizePath();
        assertEquals(path.getPath(), " 35F");
    }

    @Test
    void factorizePathOnlyRightTest() {
        path.setPath("RRRRRRRRRRRRRRRRRRRRRRRRRRRRRRR");
        path.factorizePath();
        assertEquals(path.getPath(), " 31R");
    }

    @Test
    void factorizePathOnlyLeftTest() {
        path.setPath("LLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLL");
        path.factorizePath();
        assertEquals(path.getPath(), " 35L");
    }

    @Test
    void factorizePathNoFactorizeTest() {
        path.setPath("FFFLLLRLFLRFL");
        assertEquals(path.getPath(), "FFFLLLRLFLRFL");
    }

    @Test
    void factorizePathFactorizeTwice() {
        path.setPath("FFFRRLLFFFF");
        path.factorizePath();
        path.factorizePath();
        assertEquals(path.getPath(), " 3F 2R 2L 4F");
    }

    @Test
    void factorizePathOneOfEach() {
        path.setPath("LFR");
        path.factorizePath();
        assertEquals(path.getPath(), " 1L 1F 1R");
    }

}
