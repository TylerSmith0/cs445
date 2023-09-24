package cs445.a4;

/**
  * An exception that is thrown when a rating is applied to a Video and User that
  * falls outside of the given range.
  */

public class RatingOutOfBoundsException extends Exception{
  public RatingOutOfBoundsException(){ super(); }
  public RatingOutOfBoundsException( String e ){ super(e); }
}
