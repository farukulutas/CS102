import java.util.*;

/**
 * This program does several recursive methods.
 * @author Ahmet Faruk Ulutaþ
 * @version 27/04/2020
 */ 
public class Lab06
{
   /*
    * This method takes str as an parameter and return how many e character in str.
    * @param str String
    * @return count Number of e's in str
    */
   public static int eCounter( String str) {
      int count;
      
      count = 0;
      
      if ( str.length() == 0 ) {
         return count;
      }
      
      if ( str.substring(0,1).equalsIgnoreCase("e") ) {
         count++;
      }
      
      str = str.substring( 1);
      count = count + eCounter( str);
      
      return count;
   }
   
   /*
    * This method takes decimal value as an parameter and print binary equivalent of it.
    * @param decimal Decimal value
    */
   public static void toBinary( int decimal) {
      String binary;
      
      binary = "";
      
      if ( decimal > 0 ) {
         toBinary( decimal / 2);
         System.out.print( decimal % 2 + binary);
      }
   }
   
   /*
    * This method takes list of strings as an parameter and return if the strings are in lexicographic order
    * @param list ArrayList of Strings
    * @return true If it is in lexicographic order else false
    */
   public static boolean isLexicographic( ArrayList<String> list) {
      ArrayList<String> tempList;
      
      tempList = new ArrayList( list);
      
      if ( tempList.size() == 0 || tempList.size() == 1 ) {
         return true;
      }
      else if ( tempList.get( 0).compareTo( tempList.get( 1) ) > 0 ) {
         return false;
      }
      else {
         tempList.remove( 0);
         isLexicographic( tempList);
      }
      
      return true;
   }
   
   /*
    * This method prints all n-digit even numbers in which each digit of the number, from its most-significant to 
    * least-significant digits
    * @param n Digit of numbers
    */
   public static void orderedNumbers( int n, int num) {
      int number;
      
      number = num;
      
      if ( number % 2 == 0 && conditionChecker( number) ) {
         System.out.print( number + " ");
         orderedNumbers( n, number + 2);
      } 
      else if ( (int) Math.pow( 10, n) > number ) {
         orderedNumbers( n, number + 2);
      }
   }
   
   /*
    * This method checks the condition whether number parameter is ordered from its most-significant to 
    * least-significant digits
    * @param num Number
    * @return true If condition is true else false
    */
   public static boolean conditionChecker( int num) {
      if ( ( ( num % 10)  > ( ( num / 10) % 10)) && ( num >= 10)) {
         return conditionChecker( num / 10);
      }
      else if ( num < 10) {
         return true;
      }
      else {
         return false;
      }
   }
   
   public static void main( String[] args)
   {
      // variables
      String str;
      int decimal, n, num;
      ArrayList<String> list;
      
      // program code
      
      // initilase the variables
      str = "e's for eCounter";
      decimal = 7;
      list = new ArrayList();
      n = 3;
      num = (int) Math.pow( 10, n - 1);
      
      // adding new words to arrayList
      list.add( "ali");
      list.add( "ata");
      list.add( "bak");
      
      // count number of e's by using the recursive method
      System.out.println( eCounter( str) );
      
      // print binary version of decimal value by using recursive method
      toBinary( decimal);
      
      // check whether the strings in the list are in lexicographic order or not by using recursive method
      System.out.println( "\n" + isLexicographic( list) );
      
      // print n-digits number which are even and digits are ordered from lower to high by using recursive method
      orderedNumbers( n, num);
   }
   
}