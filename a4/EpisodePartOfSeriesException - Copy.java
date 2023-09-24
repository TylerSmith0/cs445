package cs445.a4;

/**
  * An exception that is thrown when a system operation cannot be completed
  * because the system contains a TvSeries that already has a TvEpisode in it
  * that is trying to be duplicated.
  */
public class EpisodePartOfSeriesException extends Exception{
  public EpisodePartOfSeriesException(){ super(); }
  public EpisodePartOfSeriesException(String e){ super(e); }
}
