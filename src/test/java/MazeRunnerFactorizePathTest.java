package test.java;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.TestMethodOrder;
import static org.junit.jupiter.api.Assertions.*;

import main.java.ca.mcmaster.se2aa4.mazerunner.Path;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class MazeRunnerFactorizePathTest {
    Path path;

    @BeforeEach
    void initializePath() {
        path = new Path();
    }

    @Test
    @Order(1)
    void factorizePathNothing() {
        path.factorizePath();
        assertEquals(path.getPath(), ""); 
    }

    @Test
    @Order(2)
    void factorizePathGeneralTest() {
        path.setPath("FFFFFFFFRRRRLLLLLL");
        path.factorizePath();
        assertEquals(path.getPath(), " 8F 4R 6L");
    }

    @Test
    @Order(3)
    void factorizePathBoundaryTest() {
        path.setPath("F");
        path.factorizePath();
        assertEquals(path.getPath(), " 1F");
    }

    @Test
    @Order(4)
    void factorizePathBoundaryEmptyTest() {
        path.setPath("");
        path.factorizePath();
        assertEquals(path.getPath(), "");
    }

    @Test
    @Order(5)
    void factorizePathOnlyForwardTest() {
        path.setPath("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF");
        path.factorizePath();
        assertEquals(path.getPath(), " 35F");
    }

    @Test
    @Order(6)
    void factorizePathOnlyRightTest() {
        path.setPath("RRRRRRRRRRRRRRRRRRRRRRRRRRRRRRR");
        path.factorizePath();
        assertEquals(path.getPath(), " 31R");
    }

    @Test
    @Order(7)
    void factorizePathOnlyLeftTest() {
        path.setPath("LLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLL");
        path.factorizePath();
        assertEquals(path.getPath(), " 35L");
    }

    @Test
    @Order(8)
    void factorizePathNoFactorizeTest() {
        path.setPath("FFFLLLRLFLRFL");
        assertEquals(path.getPath(), "FFFLLLRLFLRFL");
    }

    @Test
    @Order(9)
    void factorizePathFactorizeTwice() {
        path.setPath("FFFRRLLFFFF");
        path.factorizePath();
        path.factorizePath();
        assertEquals(path.getPath(), " 3F 2R 2L 4F");
    }

    @Test
    @Order(10)
    void factorizePathOneOfEach() {
        path.setPath("LFR");
        path.factorizePath();
        assertEquals(path.getPath(), " 1L 1F 1R");
    }

}
