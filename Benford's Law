import java.util.*;
import java.io.*;

/**
 * 
 * Analysis of library book data:
 * [33.4, 17.6, 11.1, 8.8, 7.0, 6.1, 5.5, 5.5, 4.9]
 * Analysis of sunspot data:
 * [29.1, 12.4, 10.3, 10.6, 10.2, 8.6, 6.5, 6.6, 5.8]
 * 
 * @author Mihir Rai
 * @version September 30, 2022
 */
public class Benford
{
    public static void main(String[] args){
       
        System.out.println("According to Benford's Law, one might expect the following frequency of first digits");
        System.out.println("************************************************************************************");
        final double[] freq = {0.0, 30.1, 17.6, 12.5, 9.7, 7.9, 6.7, 5.8, 5.1, 4.6};
        
        for (int i = 1; i <=9; i++)
            System.out.println("Percentage of numbers starting with " + i + ": " + freq[i] + "%");
        System.out.println();
        System.out.println("Analysis of sunspot data:");
        System.out.println(Arrays.toString(firstDigitFrequencies("sunspots.txt",21)));
        System.out.println();
        System.out.println("Analysis of library book data:");
        System.out.println(Arrays.toString(firstDigitFrequencies("librarybooks.txt",0)));
        
    }
        
    /** 
     * @param filename the name of the text file to open for input
     * @param indexOfFirstDigit the starting index of the data(number) in each line of the file
     * @return an array of doubles, representing the frequencies of first digits in a text file, as a percentage, rounded to the nearest tenth.
     */
    
    public static double[] firstDigitFrequencies(String filename, int indexOfFirstDigit){
        File file = new File(filename);        
        
        // keeps count of the number of leading digits
        // for example, tally[1] stores the number of digits beginning with 1,
        // tally[2] stores the number of digits beginning with 2, etc...
        // Note: tally[0] is not used for anything, as we are ignoring numbers that start with a 0.
        // You may use the array, tally, below, or decide to approach this problem
        // antoher way.
        int[] tally = new int[10];
        
        try 
        {
            Scanner scanner = new Scanner(file);
           
            while (scanner.hasNextLine())
            {
                String line = scanner.nextLine();
                
                //for (int i = 0; i <= 9; i++) {
                    //if (line.indexOf(String.valueOf(i)) == indexOfFirstDigit)
                        //tally[i] = tally[i] + 1;
                //}
                char[] ch = new char[line.length()];
                
                for (int i = 0; i < line.length(); i++)
                    ch[i] = line.charAt(i);

                for (int i = 1; i <= 9; i++) {
                    char j = (char)(i+48);
                    //System.out.println(ch[indexOfFirstDigit] + " " + i + " " + j);
                    if (ch[indexOfFirstDigit] == j) {
                        //System.out.println("updating tally");
                        tally[i] = tally[i] + 1;
                    }
                }
                
            }
            scanner.close();
        } 
        catch (FileNotFoundException e) 
        {
            e.printStackTrace();
        }
        // TODO: your code here
        // return an array of doubles, representing the frequencies of first digits in a text file, as a percentage, 
        // rounded to the nearest tenth. For example,  29.14% becomes 29.1 and 29.15% becomes 29.2 after rounding.
        // NOTE: If you do not round correctly, you will likely fail some of the test cases.
   
        double[] frequencies = new double[9];
        double totalEntries = 0.0;
        for (int i = 1; i <= 9; i++)
            totalEntries = totalEntries + tally[i];

        //System.out.println("total entries: " + totalEntries);

        for (int i = 0; i <= 8; i++) {
            double normPercent = ((double) tally[i+1])/totalEntries;
            //System.out.println(normPercent);
            //double newbie = (int) ((normPercent+0.05)*10.0);
            //System.out.println(newbie);
            frequencies[i] = normPercent;
            //System.out.println(frequencies[i]);
        }     
        return frequencies;
    }
}
