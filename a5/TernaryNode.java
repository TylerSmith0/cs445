// Ternary Node class
package cs445.a5;
public class TernaryNode<T>{
  private T data;
  @SuppressWarnings("unchecked")
  private TernaryNode<T>[] children = (TernaryNode<T>[]) new TernaryNode<?>[3];

  public TernaryNode(){
    this(null); //
  }// end TernaryNode()



  public TernaryNode(T dataPortion){
    this(dataPortion, null, null, null);
  }// end TernaryNode(T)



  public TernaryNode(T dataPortion, TernaryNode<T> leftChild, TernaryNode<T> middleChild, TernaryNode<T> rightChild){
    data = dataPortion;
    children[0] = leftChild;
    children[1] = middleChild;
    children[2] = rightChild;
  }// end TernaryNode(T, Node, Node, Node)



  public T getData(){
    return data;
  }// end getData()



  public void setData(T newData){
    data = newData;
  }// end setData



  public TernaryNode<T> getLeftChild(){
    return children[0];
  }// end getLeftChild()



  public TernaryNode<T> getMiddleChild(){
    return children[1];
  }// end getMiddleChild()



  public TernaryNode<T> getRightChild(){
    return children[2];
  }// end getRightChild()



  public void setLeftChild(TernaryNode<T> newLeftChild){
    children[0] = newLeftChild;
  }// end setLeftChild(TerNode)



  public void setMiddleChild(TernaryNode<T> newMiddleChild){
    children[1] = newMiddleChild;
  }// end setMiddleChild(TerNode)



  public void setRightChild(TernaryNode<T> newRightChild){
    children[2] = newRightChild;
  }// end setRightChild(TerNode)



  public boolean hasLeftChild(){
    return children[0] != null;
  }// end hasLeftChild



  public boolean hasMiddleChild(){
    return children[1] != null;
  }// end hasMiddleChild()



  public boolean hasRightChild(){
    return children[2] != null;
  }// end hasRightChild()



  public boolean isLeaf(){
    return children[0] == null && children[1] == null && children[2] == null;
  }// end isLeaf()



  public int getNumberOfNodes(){
    int leftNumber = 0;
    int middleNumber = 0;
    int rightNumber = 0;

    if (children[0] != null){
      leftNumber = children[0].getNumberOfNodes();
    }

    if (children[1] != null){
      middleNumber = children[1].getNumberOfNodes();
    }

    if (children[2] != null){
      rightNumber = children[2].getNumberOfNodes();
    }

    return 1 + leftNumber + middleNumber + rightNumber;
  }// end getNumberOfNodes()



  public int getHeight(){
    return getHeight(this);
  }



  private int getHeight(TernaryNode<T> node){
    int height = 0;
    if (node != null){
      height = 1 + Math.max(Math.max(getHeight(node.children[0]), getHeight(node.children[1])), getHeight(node.children[2]));
    }
    return height;
  }// end getHeight(TerNode)



  public TernaryNode<T> copy(){
    TernaryNode<T> newRoot = new TernaryNode<T>(data);

    if (children[0] != null){
      newRoot.setLeftChild(children[0].copy());
    }

    if (children[1] != null){
      newRoot.setMiddleChild(children[1].copy());
    }

    if (children[2] != null){
      newRoot.setRightChild(children[2].copy());
    }

    return newRoot;
  }


}
