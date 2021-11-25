import java.util.Iterator; 

/**
 * A simple Iterator interface
 * @author Ahmet Faruk Ulutaþ
 * @date 09/03/2020
 */
public abstract class IntIterator implements Iterator {
   public abstract int nextInt();
   public abstract Integer next();
   public abstract boolean hasNext();
   
}