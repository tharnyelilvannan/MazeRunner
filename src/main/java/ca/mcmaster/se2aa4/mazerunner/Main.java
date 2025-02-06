package ca.mcmaster.se2aa4.mazerunner;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

import main.java.ca.mcmaster.se2aa4.mazerunner.Maze;
import main.java.ca.mcmaster.se2aa4.mazerunner.Entry;
import main.java.ca.mcmaster.se2aa4.mazerunner.Exit;
import main.java.ca.mcmaster.se2aa4.mazerunner.Path;
import main.java.ca.mcmaster.se2aa4.mazerunner.PathVerifier;
import main.java.ca.mcmaster.se2aa4.mazerunner.Explorer;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Options;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {

    private static final Logger logger = LogManager.getLogger();

    public static void main(String[] args) {

        Options options = new Options();
        options.addOption("i", true, "MAZE_FILE");
        options.addOption("p", true, "VERIFY");
        options.addOption("help", false, "HELP");
        CommandLineParser parser = new DefaultParser();

        try {

            CommandLine cmd = parser.parse(options, args);

            if (cmd.hasOption("help")) {

                System.out.println("USAGE: java -jar target/mazerunner -i [file path]");
                System.out.println("USAGE: java -jar target/mazerunner -i [file path] -p [maze path to verify]");
                System.out.println("i takes a maze as input and outputs a path.");
                System.out.println("p verifies a path");

            }
            else if (cmd.hasOption("i") && (cmd.hasOption("p"))) {

                logger.info("** Starting Maze Runner **");
                logger.info("**** Reading the maze from file " + args[1] + " ****");

                Maze maze = new Maze(args[1]);
                Entry entry = new Entry();
                entry.findEntry(maze);
                ArrayList<Integer> entryPoint = new ArrayList<>(entry.getPoint());
                Exit exit = new Exit();
                exit.findExit(maze);
                ArrayList<Integer> exitPoint = new ArrayList<>(exit.getPoint());
                PathVerifier pathVerifier = new PathVerifier();
                Path path = new Path();
                logger.info("**** Verifying path ****");
                path.setPath(args[3]);
                pathVerifier.verifyPath(maze, entry, exit, path);
                logger.info("** End of MazeRunner **");

            }
            else if (cmd.hasOption("i")) {

                logger.info("** Starting Maze Runner **");
                logger.info("**** Reading the maze from file " + args[1] + " ****");

                BufferedReader reader = new BufferedReader(new FileReader(args[1]));
                String line;

                while ((line = reader.readLine()) != null) {

                    for (int idx = 0; idx < line.length(); idx++) {

                        if (line.charAt(idx) == '#') {
                            System.out.print("WALL ");
                        } else if (line.charAt(idx) == ' ') {
                            System.out.print("PASS ");
                        }

                    }

                    System.out.print(System.lineSeparator());

                }

                Maze maze = new Maze(args[1]);
                Entry entry = new Entry();
                entry.findEntry(maze);
                ArrayList<Integer> entryPoint = new ArrayList<>(entry.getPoint());
                Exit exit = new Exit();
                exit.findExit(maze);
                ArrayList<Integer> exitPoint = new ArrayList<>(exit.getPoint());
                Explorer explorer = new Explorer();
                logger.info("**** Computing path ****");
                Path path = new Path();
                explorer.explore(maze, entry, exit, path);
                path.factorizePath();
                System.out.println("Path: " + path.getPath());
                logger.info("** End of MazeRunner **");

            }

        } catch (Exception e) {

            logger.error("/!\\ An error has occured /!\\");
            System.err.println(e.getMessage());

        }

    } // end of main method

} // end of Main class