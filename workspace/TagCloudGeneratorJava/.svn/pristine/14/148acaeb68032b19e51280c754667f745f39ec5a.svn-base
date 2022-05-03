import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class TagCloudGeneratorJava {

    /**
     * String for the list of possible separators (except for ").
     */
    private static final String SEPARATORSTRING = ". ,:;'{][}|/><?!`~1234567890"
            + "@#$%^&*()-_=+\" ";

    /**
     * Returns a negative integer, zero, or a positive integer as the first
     * argument is less than, equal to, or greater than the second.
     *
     */
    private static class IntegerLT implements Comparator<String> {

        Map<String, Integer> compareMap;

        IntegerLT(Map<String, Integer> compareMap) {
            this.compareMap = compareMap;
        }

        @Override
        public int compare(String str1, String str2) {
            int firstInt = this.compareMap.get(str1);
            int secondInt = this.compareMap.get(str2);
            if (secondInt > firstInt) {
                return 1;
            } else if (firstInt > secondInt) {
                return -1;
            } else {
                return str2.compareTo(str1);
            }
        }
    }

    /**
     * Returns a negative integer, zero, or a positive integer as the first
     * argument is less than, equal to, or greater than the second. Used to
     * compare each word alphabetically.
     *
     */
    public static class StringLT implements Comparator<String> {

        @Override
        public int compare(String o1, String o2) {
            if (o1.compareTo(o2) == o1.compareToIgnoreCase(o2)) {
                return o1.compareTo(o2);
            } else {
                return o1.compareToIgnoreCase(o2);
            }
        }

    }

    public static TreeMap<String, Integer> readFile(BufferedReader input,
            int nWords) throws IOException {
        assert input.ready() : "The input must be open";

        Map<String, Integer> wordMap = new HashMap<>();

        String toBeAdded = "";
        //use a try here because there may be an issue reading the line
        try {
            String line = input.readLine();

            //if the line is null that means that file has reached its end.
            while (line != null) {
                line = line.toLowerCase();
                //iterate through each character
                for (int i = 0; i < line.length(); i++) {

                    //if the character is not a separator add it to String toBeAdded
                    if (!SEPARATORSTRING
                            .contains(Character.toString(line.charAt(i)))) {

                        toBeAdded += Character.toString(line.charAt(i));
                    } else if (SEPARATORSTRING
                            .contains(Character.toString(line.charAt(i)))) {

                        //if wordMap has the word increment its corresponding value
                        if (toBeAdded != "" && wordMap.containsKey(toBeAdded)) {
                            int value = wordMap.get(toBeAdded);
                            value++;
                            wordMap.put(toBeAdded, value);
                            //if the wordMap doesn't have it add it with value 1
                        } else if (toBeAdded != ""
                                && !wordMap.containsKey(toBeAdded)) {
                            wordMap.put(toBeAdded, 1);
                        }
                        //reset toBeAdded to add more words
                        toBeAdded = "";
                    }
                }
                line = input.readLine();
            }

            //If a word proceeds with the end of file then we need to check
            if (toBeAdded != "" && wordMap.containsKey(toBeAdded)) {
                int value = wordMap.get(toBeAdded);
                value++;
                wordMap.put(toBeAdded, value);
            } else if (toBeAdded != "" && !wordMap.containsKey(toBeAdded)) {
                wordMap.put(toBeAdded, 1);
            }

        } catch (IOException a) {
            System.err.print("Error opening reading from the file");
        }
        //Create a new comparator and treeMap that takes the comparator
        IntegerLT c = new IntegerLT(wordMap);
        TreeMap<String, Integer> allWordsSorted = new TreeMap<>(c);

        Set<Map.Entry<String, Integer>> pairSet = wordMap.entrySet();

        for (Map.Entry<String, Integer> entry : pairSet) {
            allWordsSorted.put(entry.getKey(), entry.getValue());
        }

        TreeMap<String, Integer> result = new TreeMap<>(c);
        Set<Map.Entry<String, Integer>> pairSetTwo = allWordsSorted.entrySet();

        int i = 0;
        while (i < nWords && pairSetTwo.size() > 0) {

            Map.Entry<String, Integer> entry = allWordsSorted.firstEntry();
            result.put(entry.getKey(), entry.getValue());
            pairSetTwo.remove(entry);
            i++;
        }

        return result;

    }

    public static PriorityQueue<String> alphaSort(
            TreeMap<String, Integer> countSorted, int nWords) {

        StringLT c = new StringLT();

        PriorityQueue<String> alphaSorted = new PriorityQueue<>(nWords, c);

        Set<Map.Entry<String, Integer>> pairSet = countSorted.entrySet();

        for (Map.Entry<String, Integer> entry : pairSet) {
            alphaSorted.add(entry.getKey());
        }

        return alphaSorted;
    }

    /**
     * Return a font size that corresponds to the given count of a word.
     *
     * @param oldValue,
     *            the given count of a word in the text
     * @param largest
     *            the most counts within the sorting machine
     * @param smallest
     *            the least count within the sorting machine
     * @return returns bit of html code that has a font size that corresponds
     *
     *         the count of the word in the text.
     */
    private static String fontSize(int oldValue, int largest, int smallest) {

        int answer = (((oldValue - smallest) * (48 - 11))
                / (largest - smallest)) + 11;

        return "f" + answer;
    }

    /**
     * Outputs the header for the index HTML file.
     *
     * @param output
     *            The output file stream
     * @param nWords
     *            the number of words the user chose to have outputed
     * @param fileName
     *            The name of the file the user desired
     * @requires out.is_open
     * @ensures output file has the header for the index HTML file
     */
    public static void outputHeader(PrintWriter output, String fileName,
            int nWords) {
        /*
         * Outputs the beginning code of the index HTML file to the output file
         * stream
         */
        output.println("<html>");
        output.println("   <head>");
        output.println("      <title>Top " + nWords + " words in " + fileName
                + "</title>");
        output.println(
                "      <link href=\"http://web.cse.ohio-state.edu/software/2231"
                        + "/web-sw2/assignments/projects/tag-cloud-generator/data/"
                        + "tagcloud.css\" rel=\"stylesheet\" type=\"text/css\">");
        output.println("      <link href=\"tagcloud.css\" rel=\"stylesheet\" "
                + "type=\"text/css\">");
        output.println("   </head>");
        output.println("   <body>");
        output.println(
                "      <h2>Top " + nWords + " words in " + fileName + "</h2>");
        output.println("      <hr>");
        output.println("      <div class=\"cdiv\">");
        output.println("         <p class=\"cbox\">");

    }

    /**
     * Outputs the footer for the index HTML file.
     *
     * @param out
     *            The output file stream
     * @requires out.is_open
     * @ensures output file has the closing braces for the index HTML file
     */
    public static void outputFooter(PrintWriter output) {
        /*
         * Outputs the closing code of the index HTML file to the output file
         * stream
         */
        output.println("         </p>");
        output.println("      </div>");
        output.println("   </body>");
        output.print("</html>");
    }

    /**
     * Outputs the words and corresponding counts to the table in the index HTML
     * file.
     *
     * @param counts
     *            The map of the words and their corresponding occurrences in
     *            the input file.
     * @param out
     *            The output file stream
     * @requires out.is_open
     * @ensures output file has the code to output the table of words and counts
     *          in the HTML file.
     */
    public static void outputCounts(PrintWriter output,
            TreeMap<String, Integer> wordCount,
            PriorityQueue<String> alphaSorted) {

        int largest = wordCount.firstEntry().getValue();
        int smallest = wordCount.lastEntry().getValue();

        /*
         * This queue has all the words within in the map
         */

        while (alphaSorted.size() > 0) {
            /*
             * The poll method is used to get the key with the highest amount of
             * values. Then it outputs into the input file the character with
             * the correct font size.
             */
            String key = alphaSorted.poll();
            int value = wordCount.get(key);
            String fontSize = fontSize(value, largest, smallest);
            output.println("            <span style=\"cursor:default\" class=\""
                    + fontSize + "\" title=\"count: " + value + "\">" + key
                    + "</span>");
        }

//        for (String key : alphaSorted) {
//
//            int value = wordCount.get(key);
//
//            String fontSize = fontSize(value, largest, smallest);
//            output.println("            <span style=\"cursor:default\" class=\""
//                    + fontSize + "\" title=\"count: " + value + "\">" + key
//                    + "</span>");
//        }
    }

    public static void main(String[] args) throws IOException {

        System.out.print("Enter location and name of input file: ");
        Scanner input = new Scanner(System.in);
        String inputFile = input.nextLine();

        System.out.println();
        System.out.print("Enter name of output file: ");
        String outputFile = input.nextLine();

        System.out.println();
        System.out.print("How many words would you like: ");
        int nWords = Integer.parseInt(input.nextLine());

        input.close();

        BufferedReader inputStream;
        try {
            inputStream = new BufferedReader(new FileReader(inputFile));

        } catch (IOException e) {
            System.err.println("Error opening file");
            return;
        }

        TreeMap<String, Integer> wordCount = readFile(inputStream, nWords);
        //System.out.println(wordCount.toString());

        inputStream.close();

        PriorityQueue<String> alphaSorted = alphaSort(wordCount, nWords);
        //System.out.println(alphaSorted.toString());

        PrintWriter output = null;

        try {
            output = new PrintWriter(
                    new BufferedWriter(new FileWriter(outputFile)));
        } catch (IOException e) {
            System.err.println("Error opening the printWriter");
        }

        outputHeader(output, inputFile, nWords);
        outputCounts(output, wordCount, alphaSorted);
        outputFooter(output);

        output.close();

    }
}
