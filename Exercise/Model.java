import java.util.Iterator;

public class Model extends Algo {
   Iterator itr;
   
   public void play( ActionEvent e ) {
      if ( e.getSource() == m.upButton ) {
         SelectionController.upButtonActionPerformed();
      }
      else if ( e.getSource() == m.downButton ) {
         SelectionController.downButtonActionPerformed();
      }
      else if ( e.getSource() == m.leftButton ) {
         SelectionController.leftButtonActionPerformed();
      }
      else if ( e.getSource() == m.rightButton ) {
         SelectionController.rightButtonActionPerformed();
      }
      
      Iterator itr = movementPattern.iterator();
      
      while ( itr.hasNext() ) {
         if ( itr.next() == goUp() ) {
            m.setY( m.getY() + 1);
         }
         else if ( itr.next() == goLeft() ) {
            m.setX( m.getX() - 1);
         }
         else if ( itr.next() == goDown() ) {
            m.setY( m.getY() - 1);
         }
         else if ( itr.next() == goRight() ) {
            m.setX( m.getX() + 1);
         }
      }
   }
   
}