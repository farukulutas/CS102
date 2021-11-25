package ds;

import junit.framework.TestCase;

/** This class is used to create a list in data structures using nodes which
  * include data and a reference to the next node.
  * @author Ahmet Faruk Ulutaþ
  * @version 11/05/2020
  **/
public class List extends TestCase {
   // properties
   private Node head;
   
   // constructors
   public List() {
      this.head = null;
   }
   
   // methods
   
   /* This method add specified string item to head of node
    * item String item
    */
   public void addToHead( String item){
      Node nodeToAdd;
      
      nodeToAdd = new Node( item, null);
      if ( head == null) {
         head = nodeToAdd;
      }
      else {
         nodeToAdd.next = head;
         head = nodeToAdd;
      }
   }
   
   /* This method add specified string item to tail of node
    * item String item
    */
   public void addToTail( String item) {
      if ( head == null) {
         Node temp;
         
         temp = new Node( item, null);
         head = temp;
      }
      else {
         Node currNode, tail;
         
         currNode = tail();
         tail = new Node( item, null);
         currNode.next = tail;
      }
   }
   
   /* This method remove head of node and return null or data
    * return null or temp.data Null or data of temp
    */
   public String removeFromHead() {
      Node temp = head;
      if ( temp == null) {
         return null;
      }
      
      head = head.next;
      return temp.data;
   }
   
   /* This method checks whether the node is empty or not
    * return true or false
    */
   public boolean isEmpty() {
      if ( head == null) {
         return true;
      }
      
      return false;
   }
   
   
   /* This method get the specified index data by scrolling through the list
    * @param index Index
    * @return currentNode.data or null Specified index's data or null
    */
   public String getData ( int index){
      Node currentNode;
      int counter;
      
      currentNode = head;
      counter = 0;
      
      while ( currentNode != null) {
         if( counter == index) {
            return currentNode.data;
         }
         else {
            currentNode = currentNode.next;
         }
         
         counter += 1;
      }
      
      return null;
   }
   
   /* This method print the list by scrolling through the list
    */
   public void print() {
      Node currNode;
      
      currNode = head;
      System.out.print( "List: ");
      while ( currNode != null) { 
         System.out.print( currNode.data + " ");
         currNode = currNode.next; 
      } 
   }
   
   /* This method print the list by scrolling through the list if list is empty print msg
    */
   public void printReverse() {
      Node temp;
      
      temp = head;
      if (head != null) {
         printReverseHelper( temp);
      } 
      else {
         System.out.println("List is Empty");
      }
   }
   
   /* This method is a recursive method for printing datas reversely
    * @return Nothing for stop to method
    */
   private void printReverseHelper(Node n){
      if ( n == null) {
         return;
      }
      
      printReverseHelper( n.next);
      System.out.print( n.data + " ");
   }
   
   /* This method true if target is in the list, else false
    * @param target Target data
    * @return true or false
    */
   public boolean contains(String target) {
      Node currNode;
      boolean contains;
      
      currNode = head; 
      contains = false; 
      while ( currNode != null && !contains) { 
         if ( ( currNode.data).equals( target)){
            contains = true;
         }
         
         currNode = currNode.next; 
      }
      
      return contains;
   }
   
   /* This method true if values strictly ascending, else false
    * @return true or false
    */
   public boolean isOrdered() {
      Node currNode;
      boolean ordered;
      
      currNode = head;
      ordered = true;
      
      if ( head == null) {
         return true;
      }
      
      if ( head.next == null){
         return true;
      }  
      
      while ( currNode != null && currNode.next != null && ordered) { 
         if ( ( currNode.data).compareTo( ( currNode.next).data) > 0 ){
            ordered = false;
         }
         
         currNode = currNode.next;
      }
      
      return ordered;
   }
   
   /* This method go to the next node on the list
    * @return n.next or null
    */
   private Node next( Node n) {
      if ( n.next != null) {
         return n.next;
      }
      else {
         return null;
      }
   }
   
   /* This method wraps around and finds the previous one
    * @return null or currNode 
    */
   private Node previous(Node n) {
      Node currNode;
      
      currNode = head;
      if ( isEmpty()) {
         return null;
      }
      
      while ( currNode.next != null) {
         if ( ( ( currNode.next).data).equals( n.data)) {
            return currNode;
         }
         
         currNode = currNode.next;
      }
      
      return null;
   }
   
   /* This method returns tail of list
    * @return currNode tail of list
    */ 
   private Node tail() {
      Node currNode;
      
      currNode = head;
      while (currNode.next != null) {
         currNode = currNode.next;
      }
      
      return currNode;
   }
   
   /* This method display toString representation of list
    * @return list String representation
    */
   public String toString() {
      String list;
      Node currNode;
      
      list = "";
      currNode = head;
      while (currNode != null) {
         list = list + currNode.data + " ";
         currNode = currNode.next;
      }
      
      return list;
   }
   
   /* This method asserts true if it contains and print msg
    */
   public void testContains() {
      List list;
      
      list = this;
      assertTrue( "Does not contain the String", list.contains("f") );
   }
   
   /* This method test is empty or not by using assert equals
    */
   public void testIsEmpty() {
      List list;
      
      list = this;
      assertEquals( "List is not empty", 0, this.toString().length() );
   }
   
   private class Node {
      // properties
      String data; 
      Node next;
      
      // constructors
      public Node( String data, Node next) {
         this.data = data; 
         this.next = next; 
      } 
   }
   
}