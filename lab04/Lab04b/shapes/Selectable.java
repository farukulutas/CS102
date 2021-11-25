package shapes;

/**
 * A simple Square class!
 * @author Ahmet Faruk Ulutaþ
 * @date 09/03/2020
 */
public interface Selectable {
   public boolean getSelected();
   public void setSelected( boolean set);
   public Shape contains( int x, int y);
   
}