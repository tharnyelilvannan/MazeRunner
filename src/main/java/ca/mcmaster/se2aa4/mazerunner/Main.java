package ca.mcmaster.se2aa4.mazerunner;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

import main.java.ca.mcmaster.se2aa4.mazerunner.Maze;
import main.java.ca.mcmaster.se2aa4.mazerunner.Entry;
import main.java.ca.mcmaster.se2aa4.mazerunner.Exit;
import main.java.ca.mcmaster.se2aa4.mazerunner.Path;
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
        CommandLineParser parser = new DefaultParser();

        logger.info("** Starting Maze Runner **");

        try {

            CommandLine cmd = parser.parse(options, args);

            if (cmd.hasOption("i")) {

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
                Path path = new Path();
                explorer.explore(maze, entry, exit, path);
                System.out.println(path.getPath());
            }
            else if (cmd.hasOption("p")) {

            }

        } catch (Exception e) {

            logger.error("/!\\ An error has occured /!\\");

        }

        logger.info("**** Computing path ****");
        logger.info("PATH NOT COMPUTED");
        logger.info("** End of MazeRunner **");

    } // end of main method

} // end of Main class