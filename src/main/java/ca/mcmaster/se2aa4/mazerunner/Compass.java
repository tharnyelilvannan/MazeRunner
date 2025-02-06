package main.java.ca.mcmaster.se2aa4.mazerunner;

public class Compass {
    public Direction turnRight(Direction direction) {
        if (direction == Direction.EAST) {
            direction = Direction.SOUTH;
        }
        else if (direction == Direction.SOUTH) {
            direction = Direction.WEST;
        }
        else if (direction == Direction.WEST) {
            direction = Direction.NORTH;
        }
        else if (direction == Direction.NORTH) {
            direction = Direction.EAST;
        }

        return direction;
    }

    public Direction turnLeft(Direction direction) {
        if (direction == Direction.EAST) {
            direction = Direction.NORTH;
        }
        else if (direction == Direction.SOUTH) {
            direction = Direction.EAST;
        }
        else if (direction == Direction.WEST) {
            direction = Direction.SOUTH;
        }
        else if (direction == Direction.NORTH) {
            direction = Direction.WEST;
        }

        return direction;
    }
}
