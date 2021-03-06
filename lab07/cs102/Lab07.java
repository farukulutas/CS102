import ds.*;

/** This class is used to test the list class.
  * It creates an instance of the class and checks all the methods.
  * @author Ahmet Faruk Uluta?
  * @version 11/05/2020
  **/
public class Lab07 {
   public static void main(String[] args) { 
      // variables
      List list, list2;
      int index;
      String element, arrayOfStrings[];
      List a, b;
      
      // program code
      
      // initilase variables
      list = new List();
      list2 = new List();
      index = 1;
      element = "c";
      arrayOfStrings = new String[2];
      a = new List();
      b = new List();
      
      // adding new datas to list and print it
      list.addToHead( "k");
      list.addToHead( "u");
      list.addToHead( "r");
      list.addToHead( "a");
      list.addToHead( "f");
      System.out.println( "List after adding to head: " + list);
      
      // adding new data to tail and print it
      list.addToTail( "u");
      System.out.println( "List after adding to tail: " + list);
      
      // print removed data from head of list and print it
      System.out.println( "Item removed from head: " + list.removeFromHead() );
      System.out.println( "List after removing from head: " + list);
      
      // print selected index and data in it
      System.out.println( "Data at index " + index + " is " + list.getData(index));  
      
      // print list
      list.print();
      System.out.println();
      
      // print reverse order of list
      System.out.print("List in reverse is: ");
      list.printReverse();
      System.out.println();
      
      // check whether elements in list or not and print msg
      if (list.contains( element) ) {
         System.out.println( element + " is in list.");
      } 
      else {
         System.out.println( element + " is not in list.");
      }
      
      // print msg if list is ordered or not
      if ( list.isOrdered() ) {
         System.out.println("List is in order.");
      }
      else {
         System.out.println("List is not in order.");
      }
      
      // adding datas to array and create list from it
      arrayOfStrings[0] = "faruk";
      arrayOfStrings[1] = "u";
      System.out.println( createFrom( arrayOfStrings));
      
      // create list from string per word for per index and print it
      String str = "hello";
      System.out.println( createFrom( str));
      
      // adding datas to tail of a
      a.addToTail("A");
      a.addToTail("D");
      a.addToTail("C");
      
      // adding datas to tail of b
      b.addToTail("K");
      b.addToTail("B");
      b.addToTail("A");
      b.addToTail("C");
      b.addToTail("R");
      
      // print b and a and merge print 
      System.out.println(a);
      System.out.println(b);
      System.out.println(merger(a, b));
      
      // add datas to tail of list and print it
      list.addToTail("a");
      list.addToTail("b");
      list.addToTail("c");
      list.addToTail("d");
      list.addToTail("e");
      System.out.println(list);
      
      // remove datas from head of list and print it
      list.removeFromHead();
      list.removeFromHead();
      list.removeFromHead();
      list.removeFromHead();
      System.out.println(list);
      
      // adding data to list and print it
      list.addToTail("Ali");
      System.out.println(list);
      
      // adding data to list and print it
      list.addToTail("Veli");
      System.out.println(list);
      
      // remove datas from head of list and print it
      list.removeFromHead();
      list.removeFromHead();
      System.out.println(list);
      
      //JUnit Testing
      list2.testContains();
      list2.testIsEmpty();
   }
   
   /* This method create list from an given string aray list as a paramater, return list
    * @param string arraylist
    * @return list Newly created list
    */
   public static List createFrom(String[] string) {
      List list;
      
      list = new List();
      for ( int i = 0; i < string.length; i++) {
         list.addToTail( string[ i]);
      }
      
      return list;
   }
   
   /* This method create list from an given string aray list as a paramater per words for per data, return list
    * @param string arraylist
    * @return list Newly created list
    */
   public static List createFrom(String string) {
      List list;
      
      list = new List();
      for ( int i = 0; i < string.length(); i++) {
         list.addToTail(string.substring( i,i+1) );
      }
      
      return list;
   }
   
   /* This method merge two list and delete occured chars more than ones
    * @param a List a
    * @param b List b
    * @return list Newly created list
    */
   public static List merger(List a, List b) {
      List list;
      
      list = new List();
      for ( int i = 0 ; a.getData( i) != null ; i++) {
         if ( !b.contains( a.getData( i) ) ) {
            list.addToTail( a.getData( i));
         }
      }
      
      for ( int j = 0 ; b.getData( j) != null ; j++) {
         if ( !a.contains( b.getData( j) ) ) {
            list.addToTail( b.getData( j) );
         }
      }
      
      return list;
   }
   
}