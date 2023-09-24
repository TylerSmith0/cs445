package cs445.a1;

public class Groceries implements GroceriesInterface{

  Set<GroceryItem> myGroceries;

  public Groceries(){
    myGroceries = new Set();
  }


  public void addItem(GroceryItem item){
    if (!myGroceries.add(item)){
      GroceryItem inSet = myGroceries.remove(item);
      item.setQuantity(item.getQuantity() + inSet.getQuantity());
      myGroceries.add(item);
      inSet = null; //Garbage collector
    }
  }


  public void removeItem(GroceryItem item){
    GroceryItem inSet = myGroceries.remove(item);
    if (inSet != null && inSet.getQuantity() > item.getQuantity()){
      inSet.setQuantity(inSet.getQuantity() - item.getQuantity());
      myGroceries.add(inSet);
      System.out.println("Re-added " + inSet.getDescription() + " to the Groceries set with a quantity of " + inSet.getQuantity());
    }
    else if (inSet == null){
      // Nothing is done
    }
    else{
      inSet = null;
    }
  }


  public int modifyQuantity(GroceryItem item) throws IllegalArgumentException{
    int oldQuantity;
    GroceryItem inSet = myGroceries.remove(item);
    if (inSet == null){
      throw new IllegalArgumentException("Item not in Grocery Set.");
    }
    else{
      oldQuantity = inSet.getQuantity();
      myGroceries.add(item);
      inSet = null;
    }
    return oldQuantity;
  }


  public void printAll(){
    Object[] groceriesObjectArray = myGroceries.toArray();
    if (groceriesObjectArray != null){
      System.out.println("Groceries:");
      for (int i = 0; i < groceriesObjectArray.length; i++){
        System.out.println(((GroceryItem)groceriesObjectArray[i]).getQuantity() + " " + ((GroceryItem)groceriesObjectArray[i]).getDescription());
      }
      System.out.println();
    }
  }


}
