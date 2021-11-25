import java.util.Scanner;

/* Simple Test Class for IntBag methods.
 * @author Ahmet Faruk Ulutaþ
 * @version 17/02/2020
 */
public class Test {
   public static void main( String[] args)
   {
      // initiliazation of scanner.
      Scanner scan = new Scanner( System.in);
      
      // constants
      
      // variables
      int options, readValue, addedIndex, testValue;
      IntBag bag;
      boolean check;
      String index;
      
      // program code
      
      // initiliazation of bag, check, readValue, addedIndex, testValue and index.
      bag = new IntBag(0);
      check = true;
      readValue = 0;
      addedIndex = 0;
      testValue = 0;
      index = "";
      
      System.out.println("1. Create a new empty collection with a specified maximum capacity (any previous values are lost!)");
      System.out.println("2. Read a set of positive values into the collection.");
      System.out.println("3. Print the collection of values.");
      System.out.println("4. Add a value to the collection of values at a specified location.");
      System.out.println("5. Remove the value at a specified location from the collection of values.");
      System.out.println("6. Read a single test value.");
      System.out.println("7. Compute the set of locations of the test value within the collection.");
      System.out.println("8. Print the set of locations.");
      System.out.println("9. Quit the program.");  
      System.out.print(" Enter the appropriate number in the menu: ");
      
      options = scan.nextInt();
      
      // while method to use menu options
      while( options != 9)
      {
         if ( options == 1)
         {
            int capacity;
            System.out.println("Capacity: ");
            capacity = scan.nextInt();
            bag = new IntBag(capacity);
            System.out.println("New capacity: " + capacity + " has been created");
         }
         else if (options == 2)
         {
            System.out.println("Enter the value you want to read.");
            readValue = scan.nextInt();
            while (readValue >= 0)
            {
               bag.add(readValue);
               readValue = scan.nextInt();
            }
            System.out.println("Values have been added.");
         }
         else if ( options == 3)
         {
            System.out.println("Collection: " + bag);
         }
         else if ( options == 4)
         {
            System.out.println("Index: ");
            addedIndex = scan.nextInt();
            System.out.println("Value: ");
            readValue = scan.nextInt();
            check = bag.add( addedIndex, readValue);
            if (check)
               System.out.println("The number in the specified index has been added.");
            else
               System.out.println("Ineligible index");
         }
         else if (options == 5)
         {
            int indToDel;
            System.out.println("Enter the index of value to remove");
            indToDel = scan.nextInt();
            check = bag.remove(indToDel);
            if (check)
               System.out.println("The value at the given index is removed from the collection");
            else
               System.out.println("Ineligible index!");
         }
         else if (options == 6)
         {
            System.out.println("Enter the test value.");
            testValue = scan.nextInt();
         }
         else if (options == 7)
         {
            index = bag.findAll(testValue);
         }
         else if (options == 8)
         {
            System.out.println("Test value's index was found. " + index);
         }
         else
         {
            System.out.println("Ineligible option");
         }
         
         System.out.println("1. Create a new empty collection with a specified maximum capacity.");
         System.out.println("2. Read a set of positive values into the collection.");
         System.out.println("3. Print the collection of values.");
         System.out.println("4. Add a value to the collection of values at a specified location.");
         System.out.println("5. Remove the value at a specified location from the collection of values.");
         System.out.println("6. Read a single test value.");
         System.out.println("7. Compute the set of locations of the test value within the collection.");
         System.out.println("8. Print the set of locations.");
         System.out.println("9. Quit the program.");  
         System.out.print(" Enter the appropriate number in the menu: ");
         
         options = scan.nextInt();
      } 
   }
   
}