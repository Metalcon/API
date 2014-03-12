package api.newsfeed;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.neo4j.graphdb.Node;

/**
 * user class representing a user node
 * 
 * @author Sebastian Schlicht
 * 
 */
public interface User {

    /**
     * parse the user to an Actor (Object) JSON map
     * 
     * @return Actor (Object) JSON map representing this user<br>
     *         (Activitystrea.ms)
     */
    public Map<String, Object> toActorJSON();

}