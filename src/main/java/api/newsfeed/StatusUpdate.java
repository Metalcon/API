package api.newsfeed;

import java.util.Map;


public interface StatusUpdate {

    /**
     * get status update identifier
     * 
     * @return status update identifier
     */
    String getId(); 
    
    /**
     * set status update identifier
     * 
     * @param id
     *            status update identifier
     */
    void setId(final String id);

    /**
     * get status update type
     * 
     * @return status update type identifier
     */
    String getType();

    /**
     * get status update publishing time stamp
     * 
     * @return status update publishing time stamp
     */
    long getTimestamp();

    /**
     * set status update publishing time stamp for JSON parsing
     * 
     * @param timestamp
     *            status update publishing time stamp
     */
    void setTimestamp(final long timestamp);

    /**
     * set status update creator for JSON parsing
     * 
     * @param creator
     *            status update creator
     */
    void setCreator(final User creator);

    /**
     * parse the status update to an Object JSON map
     * 
     * @return Object JSON map representing this status update<br>
     *         (Activitystrea.ms)
     */
    Map<String, Object> toObjectJSON();
}