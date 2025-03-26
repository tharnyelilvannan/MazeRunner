package main.java.ca.mcmaster.se2aa4.mazerunner;

public class PathVerifier {

    public Boolean verifyPath() {
        Maze maze = Maze.get();
        Entry entryPoint = Entry.get();
        Exit exitPoint = Exit.get();
        Path path = Path.get();

        String pathToVerify = path.getPath();
        int currentRow = entryPoint.getPoint().get(0);
        int currentCol = entryPoint.getPoint().get(1);

        int exitRow = exitPoint.getPoint().get(0);
        int exitCol = exitPoint.getPoint().get(1);
        Direction direction = Direction.EAST;

        Compass compass = new Compass();

        // follows each instruction in path
        for (int i = 0; i < (pathToVerify.length() - 1); i++) {

            if (Character.toString(pathToVerify.charAt(i)).equals("F")) {

                // moves forward
                if (direction == Direction.EAST) {
                    if (maze.getMaze().get(currentRow).get(currentCol + 1).getCanPass()) {
                        currentCol++;
                    }
                }
                else if (direction == Direction.WEST) {
                    if (maze.getMaze().get(currentRow).get(currentCol - 1).getCanPass()) {
                        currentCol--;
                    }
                }
                else if (direction == Direction.NORTH) {
                    if (maze.getMaze().get(currentRow - 1).get(currentCol).getCanPass()) {
                        currentRow--;
                    }
                }
                else if (direction == Direction.SOUTH) {
                    if (maze.getMaze().get(currentRow + 1).get(currentCol).getCanPass()) {
                        currentRow++;
                    }
                }

            }
            else if (Character.toString(pathToVerify.charAt(i)).equals("R")) {

                // turns right
                direction = compass.turnRight(direction);

            }
            else if (Character.toString(pathToVerify.charAt(i)).equals("L")) {

                // turns left
                direction = compass.turnLeft(direction);

            }

        } // end of for loop

        // if not at exit point
        if (currentRow != exitRow || currentCol != exitCol) {

            System.out.println("This is not a correct path");
            return false;

        }

        // if at exit point
        System.out.println("This is a correct path");
        return true;

    } // end of verifyPath method

} // end of Path Verifier class