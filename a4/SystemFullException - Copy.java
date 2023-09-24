package cs445.a4;

/**
  * An exception that is thrown when a system operation cannot be completed
  * because the system does not have the available capacity. Should never be
  * thrown in implementations that resize on their own.
  */
public class SystemFullException extends Exception{
  public SystemFullException(){ super(); }
  public SystemFullException(String e){ super(e); }
}
