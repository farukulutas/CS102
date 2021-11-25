import cs1.SimpleURLReader;

/**
 * This program will read the contents of the url and print its contents and the number of lines it contains,
 * on the console. 
 * @auhtor Ahmet Faruk Ulutaþ
 * @date 01/03/2020
 */
public class Lab02
{
   // properties
   
   // constructors
   
   // methods
   public static void main(String[] args) {
      
      // constants
      
      // variables
      String url = "http://www.cs.bilkent.edu.tr/~david/housman.txt";
      SimpleURLReader reader;
      
      // initiliaze new reader
      reader = new SimpleURLReader( url);
      
      // Print content and lines.
      System.out.println( "Content: " );
      System.out.print( reader.getPageContents() );
      System.out.println( "Number of lines: " + reader.getLineCount() );  
   }
   
}