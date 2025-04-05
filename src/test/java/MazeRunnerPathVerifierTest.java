package test.java;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import main.java.ca.mcmaster.se2aa4.mazerunner.PathVerifier;
import main.java.ca.mcmaster.se2aa4.mazerunner.Maze;
import main.java.ca.mcmaster.se2aa4.mazerunner.Path;
import main.java.ca.mcmaster.se2aa4.mazerunner.RightHandRuleExplorer;
import main.java.ca.mcmaster.se2aa4.mazerunner.Explorer;

public class MazeRunnerPathVerifierTest {

    Maze maze;
    PathVerifier verifier;
    Path path;
    RightHandRuleExplorer explorer;

    @BeforeEach
    void initializePathVerifier() {
        maze = new Maze();
        verifier = new PathVerifier();
        path = new Path();
        explorer = new RightHandRuleExplorer(maze);
    }

    @Test
    void pathVerifierGeneralTest() {
        maze.setMaze("./examples/small.maz.txt");
        path.setPath("FFFFFFFFFFFFFFFFLFFFFFLFLFLF");
        boolean result = verifier.verifyPath(maze, path);
        assertEquals(result, false);
    }

    @Test
    void pathVerifierGeneralTest2() {
        maze.setMaze("./examples/small.maz.txt");
        path.setPath("FRFLLFFRFFRFFLLFFFFRFFRFFFFLLFFRFFFFRFFRFFLLFFLFFLFFFFRFFRFFLLFFFFRFFRFFLLFFRFFRFFFFRFFLFFRFFLFF");
        boolean result = verifier.verifyPath(maze, path);
        assertEquals(result, true);
    }

    @Test
    void pathVerifierExtraLeftTest() {
        maze.setMaze("./examples/small.maz.txt");
        path.setPath("FRFLLLLLLFFRFFRFFLLLLLLFFFFRFFRFFFFLLLLLLFFRFFFFRFFRFFLLLLLLFFLFFLLLLLFFFFRFFRFFLLLLLLFFFFRFFRFFLLFFRFFRFFFFRFFLFFRFFLLLLLFF");
        boolean result = verifier.verifyPath(maze, path);
        assertEquals(result, true);
    }

    @Test
    void pathVerifierExtraRightTest() {
        maze.setMaze("./examples/small.maz.txt");
        path.setPath("FRFLLFFRRRRRFFRRRRRFFLLFFFFRRRRRFFRRRRRFFFFLLFFRRRRRFFFFRFFRFFLLFFLFFLFFFFRFFRFFLLFFFFRRRRRFFRFFLLFFRRRRRFFRRRRRFFFFRRRRRRRRRFFLFFRFFLFF");
        boolean result = verifier.verifyPath(maze, path);
        assertEquals(result, true);
    }

    @Test
    void pathVerifierExtraLeftAndRightTest() {
        maze.setMaze("./examples/small.maz.txt");
        path.setPath("LRLRLRLRRRLLFRFLRLLRLFFRFFRFFLLRLFFFFRFFRLRFFFFLLLRFFRFFFFRFFRLRFFLLFLRFLFFLFFLRFFLRRFFRLRFFLLFFFFRFFRFFLLFFRFLRFRFFFFRFFLFRLFRFFLFF");
        boolean result = verifier.verifyPath(maze, path);
        assertEquals(result, true);
    }

    @Test
    void pathVerifierOffByOneTest() {
        maze.setMaze("./examples/small.maz.txt");
        // removed first "F"
        path.setPath("RFLLFFRFFRFFLLFFFFRFFRFFFFLLFFRFFFFRFFRFFLLFFLFFLFFFFRFFRFFLLFFFFRFFRFFLLFFRFFRFFFFRFFLFFRFFLFF");
        boolean result = verifier.verifyPath(maze, path);
        assertEquals(result, false);
    }
}
