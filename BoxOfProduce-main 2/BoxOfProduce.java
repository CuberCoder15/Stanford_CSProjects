import java.util.*;
import java.io.*;
import java.io.FileWriter;

/**
 *  Your Community Supported Agriculture (CSA) farm delivers a box of fresh fruits
 *  and vegetables to your house once a week. For this programming project, define the
 *  class BoxOfProduce that contains exactly three bundles of fruits or vegetables. 
 *  You can represent the fruits or vegetables as three instance variables of type String
 *  or an array of String objects or any other appropriate alternative. Add
 *  appropriate constructor, accessor, and mutator methods as defined below. 
 *  Also write a toString() method that returns as a String the complete contents of the box.
 *  
 *  Your BoxOfProduce should contain THREE items randomly selected from a list of FIVE options:
 *  
 *  For example:
 *  
 *  Broccoli
 *  Tomato
 *  Kiwi
 *  Kale
 *  Tomatillo
 *  
 *  This list should be stored in a text file that is read in by your program. 
 *  You can assume that the list contains exactly five types of fruits or vegetables,
 *  each unique.
 *  
 *  Your BoxOfProduce object should randomly select (each equally likely) three items, 
 *  WITHOUT duplicates, that will go in the box.
 *  This should be handled in the constructor. You may decide to call a private helper
 *  method in your constructor; for example, this private method header might look something like this: 
 *  
 *          private void randomizeBoxProduce()
 *  
 *  Next, the main method should display the contents of the box and allow
 *  the user to substitute any one of the five possible fruits or vegetables for any of the
 *  fruits or vegetables selected for the box. It is okay to allow duplicates at this point. 
 *  Perhaps the customer wants a double order of Kale  and a single order of Broccoli. 
 *  After the user is done with substitutions, output the final contents of the box to be delivered. 
 *  
 *  You should also write a toString() method that returns a String representation of your 
 *  BoxOfProduce object.
 *  Feel free to create any additional private helper methods.
 *  
 *  
 *  
 *  Sample run:
 *  
 *  There are five items this week:
 *  Broccoli
 *  Tomato
 *  Kiwi
 *  Kale
 *  Tomatillo
 *  
 *  Your box contains:
 *  Kiwi
 *  Kale
 *  Tomato
 *  
 *  Would you like to make a substitution(y/n)? 
 *  y
 *  
 *  What item would you like to substitute? 
 *  Tomato
 *  
 *  What would you like to replace it with?
 *  Kiwi
 *  
 *  Here is your new order:
 *  Kiwi
 *  Kale
 *  Kiwi
 *  
 *  
 */

public class BoxOfProduce
{
    // TODO: your code here
    // instance variables
    
    

    /**
     * Constructor for objects of class BoxOfProduce. Reads from a file.
     * The file should contain only five items, each one unique. 
     *
     * 
     * For example:
     * Broccoli
     * Tomato
     * Kiwi
     * Kale
     * Tomatillo
     * 
     *  example instantiation: 
     *  BoxOfProduce box = new BoxOfProduce("produce.txt");
     *  
     *  The constructor should also randomly select three of the five
     *  items, with no duplicates. Each choice should be randomly chosen
     *  with equal likelihood. These three random produce items should be 
     *  stored as instance variable(s) of your choice.
     *  
     *  Thus, after instantiation, your object will ecapsulate all five 
     *  possible produce items, as well as the three randomly chosen items. 
     *  
     */
    public BoxOfProduce(String produceFile)
    {
        // TODO: your code here
        // IMPORTANT: make sure you close your file after reading from it
        // e.g. scanner.close();
       
    }
    
    
    /**
     * Returns a String representation of this object.
     * It should return a String that contains the three items selected
     * (randomly or otherwise) for the box.
     * Something similar to:
     *   Kale, Broccoli, Tomato
     */
    public String toString(){
        // TODO: your code here
        return ""; // delete this line of code
    }
    
    /*
     * Optional helper method to randomly select the three items for the box.
     * (to be invoked in the constructor)
     */
    private void randomizeBoxProduce(){
     // TODO: optional
        
    }
    
    // getter methods for the three items in the box (order is not important)
    // DO NOT change the headers of these methods. codePost expects these methods
    // to exist during the testing phase.
    public String getFirstChoice(){
         // TODO: your code here
         return ""; // delete this line of code
    }
    
    public String getSecondChoice(){
        // TODO: your code here
        return ""; // delete this line of code
    }
    
    public String getThirdChoice(){
        // TODO: your code here
        return ""; // delete this line of code
    }
    
    /**
     * Setter method that substitutes produce item, oldItem,
     * with produceItem, newItem. If oldItem does not currently exist 
     * in the box, this method returns false, because the replacement
     * was unsuccessful; otherwise, return true. 
     */
     
    public boolean replace(String oldItem, String newItem){
        // TODO: your code here
        return true; // delete this line of code
    }
    
        
        
    public static void main(String[] args){
        // optional main method
        // For this assignment, you should write a class called BoxOfProduceMain.java
        // that contains your main method.
        // That being said, any class you write in Java can have a main method used for
        // testing or otherwise. 
    }
}

    
