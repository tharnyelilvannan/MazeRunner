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
        String lastCharacter = Character.toString(this.path.charAt(0));
        int count = 0;

        for (int i = 0; i < this.path.length(); i++) {
            if (Character.toString(this.path.charAt(i)).equals("F")) {
                if (lastCharacter.equals("F")) {
                    count++;
                }
                else if (lastCharacter.equals("L")) {
                    factorizedPath = factorizedPath + " " + count + lastCharacter;
                    count = 1;
                    lastCharacter = "F";
                }
                else if (lastCharacter.equals("R")) {
                    factorizedPath = factorizedPath + " " + count + lastCharacter;
                    count = 1;
                    lastCharacter = "F";
                }
            }
            else if (Character.toString(this.path.charAt(i)).equals("R")) {
                if (lastCharacter.equals("R")) {
                    count++;
                }
                else if (lastCharacter.equals("F")) {
                    factorizedPath = factorizedPath + " " + count + lastCharacter;
                    count = 1;
                    lastCharacter = "R";
                }
                else if (lastCharacter.equals("L")) {
                    factorizedPath = factorizedPath + " " + count + lastCharacter;
                    count = 1;
                    lastCharacter = "R";
                }
            }
            else if (Character.toString(this.path.charAt(i)).equals("L")) {
                if (lastCharacter.equals("L")) {
                    count++;
                }
                else if (lastCharacter.equals("F")) {
                    factorizedPath = factorizedPath + " " + count + lastCharacter;
                    count = 1;
                    lastCharacter = "L";
                }
                else if (lastCharacter.equals("R")) {
                    factorizedPath = factorizedPath + " " + count + lastCharacter;
                    count = 1;
                    lastCharacter = "L";
                }
            }
            System.out.println(lastCharacter);
        }

        factorizedPath = factorizedPath + " " +  count + lastCharacter;
        
        this.setPath(factorizedPath);

    }

    public void validatePath(String path) {
        
    }
}