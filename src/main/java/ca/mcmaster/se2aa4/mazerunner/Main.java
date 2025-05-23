package ca.mcmaster.se2aa4.mazerunner;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

import main.java.ca.mcmaster.se2aa4.mazerunner.Maze;
import main.java.ca.mcmaster.se2aa4.mazerunner.Entry;
import main.java.ca.mcmaster.se2aa4.mazerunner.Exit;
import main.java.ca.mcmaster.se2aa4.mazerunner.Path;
import main.java.ca.mcmaster.se2aa4.mazerunner.PathVerifier;
import main.java.ca.mcmaster.se2aa4.mazerunner.RightHandRuleExplorer;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Options;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// Author: Tharny Elilvannan
// Maze Runner
// Assignment 3 SFWRENG 2AA4

public class Main {

    private static final Logger logger = LogManager.getLogger();

    public static void main(String[] args) {

        // add command line options
        Options options = new Options();
        options.addOption("i", true, "MAZE_FILE");
        options.addOption("p", true, "VERIFY");
        options.addOption("help", false, "HELP");

        CommandLineParser parser = new DefaultParser();

        try {

            CommandLine cmd = parser.parse(options, args);

            if (cmd.hasOption("help")) {

                // help flag
                System.out.println("Maze Runner, SFWRENG 2AA4 Assignment 3, Winter 2025");
                System.out.println("USAGE: java -jar target/mazerunner -i [file path]");
                System.out.println("USAGE: java -jar target/mazerunner -i [file path] -p [maze path to verify]");
                System.out.println("i takes a maze as input and outputs a path.");
                System.out.println("p verifies a path");

            }
            else if (cmd.hasOption("i") && (cmd.hasOption("p"))) {

                // verify path given

                logger.info("** Starting Maze Runner **");
                logger.info("**** Reading the maze from file " + args[1] + " ****");
                Maze maze = new Maze();
                maze.setMaze(args[1]);

                PathVerifier pathVerifier = new PathVerifier();
                Path path = new Path();
                path.setPath(args[3]);

                logger.info("**** Verifying path ****");

                pathVerifier.verifyPath(maze, path);

                logger.info("** End of MazeRunner **");

            }
            else if (cmd.hasOption("i")) {

                // explores the maze and outputs path

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

                Maze maze = new Maze();
                RightHandRuleExplorer explorer = new RightHandRuleExplorer(maze);

                maze.setMaze(args[1]);

                logger.info("**** Computing path ****");

                explorer.getPath().factorizePath();
                Path path = explorer.getPath();
                System.out.println("Path: " + path.getPath());

                logger.info("** End of MazeRunner **");

            }

        } catch (Exception e) {

            logger.error("/!\\ An error has occured /!\\");
            System.err.println(e.getMessage());

        }

    } // end of main method

} // end of Main class