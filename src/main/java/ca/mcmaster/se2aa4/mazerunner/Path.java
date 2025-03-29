package main.java.ca.mcmaster.se2aa4.mazerunner;

import org.apache.commons.lang3.StringUtils;

public class Path {

    private String path = "";
    private boolean mustFactorize;

    public void setPath(String path) {

        this.path = path;
        this.mustFactorize = true;

    } // end of setPath method

    public String getPath() {

        return this.path;

    } // end of getPath method

    public void factorizePath() {
        
        String factorizedPath = "";
        int count = 0;

        if (!StringUtils.isEmpty(this.path) && mustFactorize) {
            String lastCharacter = Character.toString(this.path.charAt(0));
            
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
            this.mustFactorize = false;

        }
        else if (mustFactorize) {
            this.setPath("");
            this.mustFactorize = false;
        } // end of if/else statement

    } // end of factorizePath method

} // end of Path class