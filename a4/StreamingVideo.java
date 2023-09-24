package cs445.a4;

import java.util.NoSuchElementException;

/**
 * This abstract data type represents the backend for a streaming video service.
 * It stores the videos (TV episodes and films), TV series, and users in the
 * system, as well as the ratings that users assign to videos.
 @author Dr. William C. Garrison
 @author Tyler N. Smith
 @author My main man Rav
 @version 2.0
 */
public interface StreamingVideo {

    /**
     * The abstract methods below are declared as void methods with no
     * parameters. You need to expand each declaration to specify a return type
     * and parameters, as necessary. You also need to include a detailed comment
     * for each abstract method describing its effect, its return value, any
     * corner cases that the client may need to consider, any exceptions the
     * method may throw (including a description of the circumstances under
     * which this will happen), and so on. You should include enough details
     * that a client could use this data structure without ever being surprised
     * or not knowing what will happen, even though they haven't read the
     * implementation.
     */

    /**
     * Adds a new Video or subtype of Video to the system.
     *
     * <p> If newVideo is not null, the system does not already contain newVideo,
     * and the system has available capacity (if applicable), then addVideo
     * modifies the set so that it contains newVideo and returns true. All other
     * entries remain unmodified. Duplicates are determined using the .equals()
     * method.
     *
     * <p> If the system already contains the video, determined by the .equals()
     * method, then addVideo will not add a duplicate value into the system. The
     * method will instead return false without modifying the set at all.
     *
     * <p> If newVideo is not null, the system does not already contain newVideo,
     * but the system's capacity is full, then addVideo will throw a
     * SystemFullException without modifying the system. If the system does not
     * have a capacity limit (i.e. it resizes itself automatically) then the
     * method will never throw a SystemFullException.
     *
     * <p> If newVideo is null, then addVideo will throw a NullPointerException
     * without modifying the system.
     *
     * <p> If the user tries to pass an argument that is not a Video or a subtype
     * of Video, then addVideo will throw an IllegalArgumentException without
     * modifying the system.
     *
     * @param newVideo The Video or subtype of Video to be added as a new video
     * to the system.
     * @return true if the addition is successful, false if the video is already
     * in the system.
     * @throws SystemFullException If the system's capacity is full and it does
     * not resize automatically to create room for a new video.
     * @throws NullPointerException If newVideo is null.
     * @throws IllegalArgumentException If newVideo is not of type Video or a
     * subtype of Video.
     */
    public boolean addVideo(Video newVideo) throws SystemFullException,
                              NullPointerException, IllegalArgumentException;

    /**
     * Removes an existing video from the system, if possible.
     *
     * <p> If the system contains at least one video, remove modifies the system so
     * that it no longer contains theVideo. All other entries remain unmodified.
     * Identifying this entry is accomplished using the .equals() method. The
     * removed entry will be returned.
     *
     * <p> If theVideo has the same name as another video, the .equals() method
     * should be able to choose which of the two or more videos is being called,
     * and thus will only remove and return the correct video to be removed, leaving the others
     * untouched.
     *
     * <p> If the system does not contain theVideo, or the system is empty,
     * remove will throw a NoSuchElementException without modifying the system.
     *
     * <p> If theVideo is not of type Video or a subtype of Video, then remove
     * will throw an IllegalArgumentException without modifying the system.
     *
     * <p> If theVideo is a null value, then remove will throw a NullPointerException
     * without modifying the system.
     *
     * @param theVideo The Video or subtype of Video to be removed.
     * @return The removed Video if removal was successful.
     * @throws NoSuchElementException If theVideo is not in the system or the
     * system is empty.
     * @throws NullPointerException If theVideo is null.
     * @throws IllegalArgumentException If theVideo is not of type Video or a
     * subtype of Video.
     */
    public Video removeVideo(Video theVideo) throws NullPointerException,
                              NoSuchElementException, IllegalArgumentException;

    /**
     * Adds an existing television episode to an existing television series. This
     * method does not check if the episode should be a part of the series or not,
     * for that is for the user to decide.
     *
     * <p> If newEpisode is a TvEpisode in the system already, theSeries is
     * an existing TvSeries in the system, and newEpisode is not already a part
     * of theSeries, addToSeries will add newEpisode to theSeries without
     * modifying any other elements and returns true.
     *
     * <p> If newEpisode is not already in the system, then addToSeries will
     * first call the add() method and add newEpisode to the system. Then, it
     * will add newEpisode to theSeries if theSeries is a valid TvSeries already
     * in the system and return true.
     *
     * <p> If newEpisode is a null value, then addToSeries will throw a
     * NullPointerException without modifying the rest of the system.
     *
     * <p> If newEpisode is already a part of theSeries, then addToSeries will
     * throw an EpisodePartOfSeriesException without modifying the set.
     *
     * <p> If newEpisode is not of type TvEpisode, or theSeries is not of type
     * TvSeries, addToSeries will throw an IllegalArgumentException without
     * modifying the rest of the system.
     *
     * <p> If theSeries is not an existing series in the system already, then
     * addToSeries will throw a NoSuchElementException without modifying the
     * rest of the system.
     *
     * @param newEpisode The TvEpisode to be added.
     * @param theSeries The TvSeries to be added to.
     * @return true if newEpisode was successfully added to theSeries.
     * @throws NullPointerException If newEpisode is null.
     * @throws EpisodePartOfSeriesException If newEpisode is already a part of
     * theSeries.
     * @throws IllegalArgumentException If newEpisode is not of type TvEpisode or
     * theSeries is not of type TvSeries.
     * @throws NoSuchElementException If theSeries is not an existing TvSeries
     * in the system.
     *
     */
    public boolean addToSeries(TvEpisode newEpisode, TvSeries theSeries) throws
    NullPointerException, EpisodePartOfSeriesException, IllegalArgumentException,
                                                          NoSuchElementException;

    /**
     * Removes a television episode from a television series.
     *
     * <p> If both theEpisode and theSeries are a part of the system, both are
     * not null, and theEpisode is a part of theSeries, then removeFromSeries
     * will remove theEpisode from both the series and the system and return
     * theEpisode.
     *
     * <p> If both theEpisode and theSeries are a part of the system, but
     * theEpisode is not a part of theSeries, removeFromSeries will return a null
     * value. This will signal to the user that an error occured, since null
     * values cannot be added to a TvSeries.
     *
     * <p> If either theEpisode is not of type TvEpisode, or theSeries is not of
     * type TvSeries, removeFromSeries will throw an IllegalArgumentException
     * without modifying the rest of the system.
     *
     * <p> If either theEpisode or theSeries is null, removeFromSeries will
     * throw a NullPointerException without modifying the rest of the system.
     *
     * <p> If theEpisode or theSeries are not a part of the system already,
     * removeFromSeries will throw a NoSuchElementException without modifying the
     * rest of the system.
     *
     * @param theEpisode The TvEpisode to be removed.
     * @param theSeries the TvSeries to be removed from.
     * @return theEpisode if successfully removed from theSeries, null
     * if theEpisode was not a part of theSeries.
     * @throws IllegalArgumentException If theEpisode is not of type TvEpisode
     * or theSeries is not of type TvSeries.
     * @throws NullPointerException If either theEpisode or theSeries are null.
     * @throws NoSuchElementException If either theEpisode or theSeries are not
     * a part of the system already.
     *
     */
    public TvEpisode removeFromSeries(TvEpisode theEpisode, TvSeries theSeries)
      throws IllegalArgumentException, NullPointerException, NoSuchElementException;

    /**
     * Sets a user's rating for a video, as a number of stars from 1 to 5.
     *
     * <p> If theUser and theVideo both are in the system and are not null, and
     * theRating is an integer value from 1 - 5, rateVideo will assign theRating
     * to theVideo on theUser's profile and return true.
     *
     * <p> If a rating already exists, the clearRating method will be called to
     * remove the rating from the video, and then the new rating will be set in
     * place of the old rating. The same parameters must apply as above, and the
     * method will return true.
     *
     * <p> If theUser or theVideo do not exist in the system, then rateVideo will
     * throw a NoSuchElementException without modifying the rest of the system.
     *
     * <p> If theUser or theVideo are null, then rateVideo will throw a
     * NullPointerException without modifying the rest of the system.
     *
     * <p> If theRating falls either below 1 or above 5, rateVideo will throw a
     * RatingOutOfBoundsException without modifying the rest of the system.
     *
     * <p> If theUser is not of type User, theVideo is not of type Video or a
     * subtype of Video, or theRating is not an integer, then rateVideo will
     * throw an IllegalArgumentsException without modifying the rest of the
     * system.
     *
     * @param theUser The User account to assign the video rating to.
     * @param theVideo The Video that is to be rated.
     * @param theRating The integer rating that is to be assigned to a Video.
     * @return true if the rating was successfully completed.
     * @throws NoSuchElementException If theUser or theVideo do not exist in the
     * system.
     * @throws NullPointerException If theUser or theVideo are null.
     * @throws RatingOutOfBoundsException If theRating is below 1 or above 5.
     * @throws IllegalArgumentException If theUser is not of type User, theVideo
     * is not of type Video or a subtype of Video, and theRating is not an int.
     */
    boolean rateVideo(User theUser, Video theVideo, int theRating) throws NoSuchElementException,
            NullPointerException, RatingOutOfBoundsException, IllegalArgumentException;

    /**
     * Clears a user's rating on a video. If this user has rated this video and
     * the rating has not already been cleared, then the rating is cleared and
     * the state will appear as if the rating was never made. If there is no
     * such rating on record (either because this user has not rated this video,
     * or because the rating has already been cleared), then this method will
     * throw an IllegalArgumentException. If the user or video is not in the
     * system, then this method will throw NoSuchElementException.
     *
     * @param theUser user whose rating should be cleared
     * @param theVideo video from which the user's rating should be cleared
     * @throws IllegalArgumentException if the user does not currently have a
     * rating on record for the video
     * @throws NoSuchElementException if either the user or the video is not in
     * the system
     * @throws NullPointerException if either the user or the video is null
     */
    public void clearRating(User theUser, Video theVideo)
    throws IllegalArgumentException,
           NullPointerException,
           NoSuchElementException;

    /**
     * Predicts the rating a user will assign to a video that they have not yet
     * rated, as a number of stars from 1 to 5.
     *
     * <p> If theUser and theVideo both are in the system and are not null, then
     * predictRating will return an integer value that guesses what the client
     * would rate the video at, from 1 to 5 stars.
     *
     * <p> If a rating already exists for theVideo from the User, then the method
     * will simply return the rating that the User applied to the Video.
     *
     * <p> If theUser or theVideo are null, then predictRating will throw a
     * NullPointerException without modifying the rest of the system.
     *
     * <p> If theUser or theVideo are not a part of the system, then predictRating
     * will throw a NoSuchElementException without modifying the rest of the system.
     *
     * <p> If theUser is not of type User, or theVideo is not of type Video or a
     * subtype of Video, then predictRating will throw an IllegalArgumentException
     * without modifying the rest of the system.
     *
     * @param theUser The User account in which the video's predicted rating will
     * be returned.
     * @param theVideo The Video in which the rating will be predicted.
     * @return An integer value between 1 and 5 that is a prediction of what the
     * client would rate the given Video at.
     * @throws NullPointerException If theUser or theVideo are null.
     * @throws NoSuchElementException If theUser or theVideo are not a part of
     * the system.
     * @throws IllegalArgumentException If theUser is not of type User, or theVideo
     * is not of type Video or a subtype of Video.
     *
     */
    int predictRating(User theUser, Video theVideo) throws NullPointerException,
                              NoSuchElementException, IllegalArgumentException;

    /**
     * Suggests a video for a user that they are predicted to like without removing
     * it from the system.
     *
     * <p> If theUser is not null and is already a part of the system, then
     * suggestVideo will return a Video or a subtype of Video that the program
     * believes the client would enjoy.
     *
     * <p> If theUser is not a part of the system, then suggestVideo will throw
     * a NoSuchElementException without modifying the rest of the system.
     *
     * <p> If theUser is null, then suggestVideo will throw a NullPointerException
     * without modifying the rest of the system.
     *
     * <p> If theUser is not of type User, then suggestVideo will throw an
     * IllegalArgumentException without modifying the rest of the system.
     *
     * @param theUser The User to which a Video will be suggested.
     * @return A Video that the User would probably like.
     * @throws NoSuchElementException If theUser does not already exist in the system.
     * @throws NullPointerException If theUser is null.
     * @throws IllegalArgumentException If theUser is not of type User.
     *
     */
    Video suggestVideo(User theUser) throws NoSuchElementException,
                                  NullPointerException, IllegalArgumentException;


}
