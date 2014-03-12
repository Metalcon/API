package api.newsfeed;

import java.util.List;

import org.json.simple.JSONObject;
import org.neo4j.graphdb.Node;


public interface SocialGraph {

    /**
     * create a new user
     * 
     * @param userId
     *            user identifier
     * @param displayName
     *            user display name
     * @param profilePicturePath
     *            path to the profile picture of the user
     */
    void createUser(final String userId, final String displayName,
            final String profilePicturePath);

    /**
     * create a new status update for a user
     * 
     * @param timestamp
     *            time stamp of the status update
     * @param user
     *            user
     * @param content
     *            status update content object
     */
    void createStatusUpdate(long timestamp, Node user,
            StatusUpdate content);

    /**
     * create a new friendship from a user to another
     * 
     * @param following
     *            user following
     * @param followed
     *            user being followed
     */
    void createFriendship(Node following, Node followed);

    /**
     * read some status updates for/from a user
     * 
     * @param poster
     *            owner of the stream targeted
     * @param user
     *            reading user
     * @param numItems
     *            number of items to be read
     * @param ownUpdates
     *            single stream flag
     * @return list containing numItems status update Activities<br>
     *         (Activitystrea.ms)
     */
    List<JSONObject> readStatusUpdates(Node poster, Node user,
            int numItems, boolean ownUpdates);

    /**
     * delete a user removing it from all replica layers of following users
     * 
     * @param user
     *            user that shall be deleted
     */
    void deleteUser(final Node user);

    /**
     * remove a follow edge from one user to another
     * 
     * @param following
     *            user following, requesting the deletion
     * @param followed
     *            user followed
     * @return true - if the follow edge has been removed<br>
     *         false - if there is no follow edge between the users
     */
    boolean removeFriendship(Node following, Node followed);

    /**
     * delete a status update from a user
     * 
     * @param user
     *            user requesting
     * @param statusUpdate
     *            status update
     * @return true - if the status update has been removed<br>
     *         false - if the status update is not owned by the user requesting
     */
    boolean deleteStatusUpdate(Node user, Node statusUpdate);
    
}
