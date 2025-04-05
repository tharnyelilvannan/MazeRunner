package main.java.ca.mcmaster.se2aa4.mazerunner;

import java.util.ArrayList;
import java.util.List;

abstract public class Explorer extends Observer {
    
    Entry entry;
    Exit exit;
    Maze maze;
    Path path;
    List<Integer> entryPoint;
    List<Integer> exitPoint;
    String canonPath = "";

    Explorer(Maze maze) {
        this.maze = maze;
        this.subject = maze;
        subject.attach(this);
    }

    public void update() throws Exception {
        this.explore(this.maze);
    }

    public void explore(Maze maze) throws Exception {
        entry = new Entry(maze);
        exit = new Exit(maze);

        entry.findEntry();
        exit.findExit();

        entryPoint = entry.getPoint();
        exitPoint = exit.getPoint();

        path = new Path();
    
        canonPath = findPath();

        path.setPath(canonPath);

    }

    abstract String findPath();

    public Path getPath() {
        return this.path;
    }

} // end of Explorer class