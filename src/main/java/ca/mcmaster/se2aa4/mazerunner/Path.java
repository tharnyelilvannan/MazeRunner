package main.java.ca.mcmaster.se2aa4.mazerunner;

public class Path {
    private String path = "";

    public void setPath(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }

    public void factorizePath() {
        String factorizedPath = "";
        String lastCharacter = "";
        int count = 0;

        for (int i = 0; i < this.path.length(); i++) {
            if (Character.toString(this.path.charAt(i)).equals("F")) {

            }
        }
    }

    public void validatePath(String path) {
        
    }
}