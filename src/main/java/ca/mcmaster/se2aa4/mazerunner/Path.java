package main.java.ca.mcmaster.se2aa4.mazerunner;

public class Path {

    private String path = "";

    public void setPath(String path) {

        this.path = path;

    } // end of setPath method

    public String getPath() {

        return path;

    } // end of getPath method

    public void factorizePath() {
        
        String factorizedPath = "";
        String lastCharacter = Character.toString(this.path.charAt(0));
        int count = 0;

        // factorizes each character
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
        }

        // adds last character
        factorizedPath = factorizedPath + " " +  count + lastCharacter;
        
        this.setPath(factorizedPath);

    } // end of factorizePath method

} // end of Path class