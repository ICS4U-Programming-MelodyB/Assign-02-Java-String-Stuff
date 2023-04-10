import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
/**
* This program finds the max run of lines in a file.
*
* @author  Melody Berhane
* @version 1.0
* @since   2023-04-09
*/

public final class StringStuff {
    /**
    * For style checker.
    *
    * @exception IllegalStateException Utility class.
    * @see IllegalStateException
    */
    private StringStuff() {
        throw new IllegalStateException("Utility class");
    }

    /**
    * Print messages.
    *
    * @param args Unused
    */
    public static void main(String[] args) {

        // Declare lists.
        final ArrayList<String> fileList = new ArrayList<String>();

        try {
            // Choose a file to get input from.
            final File input1 = new File("input1.txt");
            final Scanner scanFile = new Scanner(input1);

            // Choose (or create) a file to print output to.
            final FileWriter output = new FileWriter("output1.txt");

            // Loop to read each line of input file.
            while (scanFile.hasNextLine()) {
                // Add the next line.
                fileList.add(scanFile.nextLine());
            }

            // Create an array with all elements in the student list.
            final String[] lineArr = new String[fileList.size()];
            for (int location = 0; location < lineArr.length; location++) {
                lineArr[location] = fileList.get(location);
            }

            // Call functions and write to file.
            for (String line : lineArr) {
                final int run = findMaxRun(line);
                output.write(run + "\n");
            }

            // Close writer.
            output.close();

        } catch (IOException err) {
            // For when no input file is found.
            System.err.println("Error: " + err.getMessage());
        }
    }

    /**
    * This function finds the max run for each line.
    *
    * @param line taken from file
    * @return maxRun
    */
    public static int findMaxRun(String line) {
        // Declare variables.
        int currentRun = 1;
        int maxRun = 0;

        // Checks if the line only holds one character.
        // (maxRun is already set to 0 for 0-length lines.)
        if (line.length() == 1) {
            maxRun = 1;
        }

        // Create and array of all characters in the line.
        char[] lineArr = new char[line.length()];
        lineArr = line.toCharArray();

        // Iterate through array and check if current character is equivalent
        // to the next one in the array.
        // For loop will not be executed if the line holds less than two
        // characters.
        for (int counter = 0; counter < lineArr.length - 1; counter++) {
            if (lineArr[counter] == lineArr[counter + 1]) {
                currentRun++;
            } else {
                currentRun = 1;
            }
            if (currentRun > maxRun) {
                maxRun = currentRun;
            }
        }
        return maxRun;
    }
}
