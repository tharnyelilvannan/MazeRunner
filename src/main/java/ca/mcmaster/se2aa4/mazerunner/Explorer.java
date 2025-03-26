package main.java.ca.mcmaster.se2aa4.mazerunner;

import java.util.ArrayList;
import java.util.List;

abstract class Explorer {
    Entry entry;
    Exit exit;
    Maze maze;
    Path path;
    List<Integer> entryPoint;
    List<Integer> exitPoint;
    String canonPath = "";

    public void explore() throws Exception {
        entry = Entry.get();
        exit = Exit.get();
        path = Path.get();

        entry.findEntry();
        exit.findExit();

        entryPoint = entry.getPoint();
        exitPoint = exit.getPoint();
        Maze maze = Maze.get();

        canonPath = findPath();

        path.setPath(canonPath);

    }

    abstract String findPath();

} // end of Explorer class