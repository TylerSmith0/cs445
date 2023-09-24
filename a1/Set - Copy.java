/* Created by Tyler Smith
 * on May 29th, 2019.
 * CS 0445 Assignment 1
 * tns17
 * Due June 4th, 2019
 */
package cs445.a1;

public class Set<E> implements SetInterface<E> {

// ************ Variables in the Whole Set ****************//

  private E[] contents;
  private int size;
  private int capacity;

// ********** Constructors *****************//

  public Set(){
    size = 0;
    capacity = 5;
    contents = (E[]) new Object[capacity];
  }

  public Set(int userCapacity){
    if (userCapacity >= 0){
      size = 0;
      capacity = userCapacity;
      contents = (E[]) new Object[capacity];
    }
    else{
    }
  }

  public Set(E[] elems){
    contents = elems;
    capacity = elems.length;
    size = capacity;
  }


// *********** SetInterface Methods ****************//

  public int getSize(){
    return size;
  }

  public boolean isEmpty(){
    boolean result = false;
    if (size == 0){
      result = true;
    }
    return result;
  }

  public boolean add(E newEntry) throws NullPointerException{
    boolean result = false;
    boolean containsNewEntry = false;
    for (int i = 0; i < size; i++){
      if (contents[i].equals(newEntry)){
        containsNewEntry = true;
        break;
      }
    }
    if (newEntry == null){
      throw new NullPointerException();
    }
    else if (containsNewEntry == true){
    }
    else if (capacity == size){
      capacity = capacity*2;
      E[] resizedContents = (E[]) new Object[capacity];
      for (int i = 0; i < size; i++){
        resizedContents[i] = contents[i];
      }
      resizedContents[size] = newEntry;
      contents = resizedContents;
      size++;
      result = true;
    }
    else{
      contents[size] = newEntry;
      size++;
      result = true;
    }
    return result;
  }

  public E remove(E entry) throws NullPointerException{
    E result = null;
    if (entry == null){
      throw new NullPointerException();
    }

    for (int i = 0; i < size; i++){
      if (entry.equals(contents[i])){
        result = contents[i];
        contents[i] = contents[size-1];
        contents[size-1] = null;
        size--;
        break;
      }
    }

    return result;
  }

  public E remove(){
    E result = null;
    if (size > 0){
      result = contents[size-1];
      contents[size-1] = null;
      size--;
    }
    return result;
  }


  public void clear(){
    if (size > 0){
      for (int i = 0; i < size; i++){
        contents[i] = null;
      }
      size = 0;
    }
  }



  public boolean contains(E entry) throws NullPointerException{
    boolean result = false;
    if (entry == null){
      throw new NullPointerException();
    }
    else{
      for (int i = 0; i < size; i++){
        if (contents[i].equals(entry)){
          result = true;
          break;
        }
      }
    }
    return result;
  }


  public Object[] toArray(){
    Object[] result = null;
    if (size <= 0){
    }
    else{
      result = new Object[size];
      for (int i = 0; i < size; i++){
        result[i] = contents[i];
      }
    }
    return result;
  }

}
