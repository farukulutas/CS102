package shapes;

import java.util.Scanner;
/**
 * A simple Square class!
 * @author Ahmet Faruk Uluta?
 * @date 08/03/2020
 */
public class ShapeTester
{
   public static void main( String[] args) {
      Scanner scan = new Scanner( System.in);
      
      // constants
      
      // variables
      boolean isEnd, isCreated;
      int options, shapeSelection, radius, width, height, side, x, y;
      ShapeContainer shapeContain;
      
      // program code
      
      // initiliase variables
      isEnd = false;
      isCreated = false;
      shapeContain = null;
      
      // menu method
      do {
         System.out.println( " Welcome to the Shape Tester! \n"
                               + " 1 - create an empty set of shapes (ShapeContainer) \n"
                               + " 2 - add a shape \n"
                               + " 3 - compute & print out the total surface area of the entire set of shapes \n"
                               + " 4 - print out information about all of the shapes \n"
                               + " 5 - find the first Shape that contains a given x, y \n"
                               + " 6 - removes all selected shapes from the set of shapes \n"
                               + " 7 - Quit \n" );
         
         options = scan.nextInt();
         
         // if container is created pass this statement or warn the user
         if ( options != 1 && isCreated ) {
            System.out.println( "To be able to use other options, you should create a set initially." );  
         }
         
         // add a shape with specific options
         else {
            if ( options == 1 ) {
               shapeContain = new ShapeContainer();
               System.out.println(" New shape container have been created! \n" );
            }
            
            else if ( options == 2 ) {
               System.out.println( "Please, select a shape; \n"
                                     + "1 - Circle \n"
                                     + "2 - Rectangle \n"
                                     + "3 - Square \n" );
               
               shapeSelection = scan.nextInt();
               
               // add circle
               if ( shapeSelection == 1 ) {
                  System.out.println( "Please, enter the radius and the "
                                        + "positions x and y." );
                  radius = scan.nextInt();
                  x = scan.nextInt();
                  y = scan.nextInt();
                  
                  Circle circle = new Circle( radius, x, y);
                  shapeContain.add( circle);
               }
               
               // add rectangle
               else if ( shapeSelection == 2 ) {
                  System.out.println( "Please, enter the width and height." );
                  width = scan.nextInt();
                  height = scan.nextInt();
                  x = scan.nextInt();
                  y = scan.nextInt();
                  
                  Rectangle rectangle = new Rectangle( width, height, x, y);
                  
                  shapeContain.add( rectangle);
               }
               
               // add square
               else if ( shapeSelection == 3 ) {
                  System.out.println( "Please, enter one side." );
                  side = scan.nextInt();
                  x = scan.nextInt();
                  y = scan.nextInt();
                  
                  Square square = new Square( side, x, y);
                  shapeContain.add( square);
               }
               
               else {
                  System.out.println(" Invalid options has entered. Please, try again. ");  
               }
            }
            
            // total surface area
            else if ( options == 3 ) {
               System.out.println("The total surface area is: " + shapeContain.getArea() + '\n');
            }
            
            // print all shapess infos by using the shapeContain
            else if ( options == 4 ) {
               System.out.println( shapeContain);  
            }
            
            // find first contains
            else if ( options == 5 ) {
               System.out.println("Please enter x and y respectively.");
               x = scan.nextInt();
               y = scan.nextInt();
               
               shapeContain.findFirstContains( x, y);  
            }
            
            // remove all shapes in the container
            else if ( options == 6 ) {
               shapeContain.removeAllSelected();
            }
            
            // end of the menu
            else if ( options == 7 ) {
               isEnd = true;
            }
            
            // invalid options entered warn the user
            else {
               System.out.println( " Invalid options has entered. Please, try again. ");
            }
         }
      } while ( !isEnd );
      
      // print good bye msg
      System.out.println( "Good Bye! " );
   }
   
}