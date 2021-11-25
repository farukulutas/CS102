import java.util.Iterator;

/* Simple IntBag Class!
 * @author Ahmet Faruk Ulutaþ
 * @version 17/02/2020
 */
public class IntBag
{
  //properties
  int[] bag;
  int valid;
  int maxEls;
  
  //constructors
  public IntBag()
  {
    maxEls = 100;
    bag = new int[maxEls];
    valid = 0;
  }
  public IntBag(int desiredEls)
  {
    maxEls = desiredEls;
    bag = new int[maxEls];
    valid = 0;
  }
  //methods
  public boolean add(int valueToAdd)
  {
    if (valid < maxEls)
    {
      bag[valid] = valueToAdd;
      valid++;
      return true;
    }
    return false;
  }
  public boolean add(int ind, int value)
  {
    if (valid <= maxEls)
    { 
      if (ind >= 0 && ind < valid)
      {
        for ( int j = valid; j > ind; j--) { 
          bag[j] = bag[j - 1]; 
        }
        bag[ind] = value;
        valid++;
        return true;
      }
    }
    return false;
  }
  public boolean remove(int i)
  {
    if (i >=0 && i < valid)
    {
      for (int j = valid - 2 ; j >= i ; j--)
      {
        bag[j] = bag[j+1];
      }
      valid--;
      return true;
    }
    return false;
  }
  public boolean ifContain(int val)
  {
    for (int i = 0 ; i < valid ; i++)
    {
      if (bag[i] == val)
      {
        return true;
      }
    }
    return false;
  }
  public String toString()
  {
    String strbag;
    strbag = "";
    if (valid > 0)
    {
      for (int i = 0 ; i < valid ; i++)
      {
        strbag = strbag + bag[i];
        strbag = strbag + " ";
      }
      return strbag;
    }
    return "No values in the collection";
  }
  public int size()
  {
    return valid;
  }
  public int get(int index)
  {
    if (index < valid)
    {
      return bag[index];
    }
    return 0;
  }
  public String findAll(int val)
  {
    String index;
    index = "";
    for (int i = 0 ; i < valid ; i++)
    {
      if (bag[i] == val)
      {
        index += i;
        index += " ";
      }
    }
    return index;
  }
  public Iterator iterator()
  {
    return new IntBagIterator(this);
  }
  //inner class
  
  public class IntBagIterator implements Iterator {
    
    private IntBag aBag;
    private int index;
    
    public IntBagIterator(IntBag aBag) {
      this.aBag = aBag;
      this.index = 0;
    }
    
    // methods
    
    public boolean hasNext() {
      if (aBag.size() - 1 > index) {
        return true;
      }
      else {
        return false;
      }
    }
    
    public Integer next() {
      if (hasNext()) {
        int a = aBag.get(index);
        Integer integerA = new Integer(a);
        index += 1;
        return integerA;
      }
      else {
        return null;
      }
    }
  }
}