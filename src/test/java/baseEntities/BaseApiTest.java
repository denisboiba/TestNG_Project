package baseEntities;

import com.fasterxml.jackson.databind.ObjectMapper;
import models.CreatePlayer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Map;


public class BaseApiTest {

    protected final Logger logger = LogManager.getLogger(this);
    public final static String USER_ROLE = "user";
    public final static String ADMIN_ROLE = "admin";
    public final static String SUPERVISOR_ROLE = "supervisor";
    public final static String MALE = "male";


    public Map<String, Object> GetMapForNewPlayer(Integer age, String gender, String login, String password, String role, String screenName) {
        ObjectMapper objectMapper = new ObjectMapper();
        CreatePlayer newPlayer = new CreatePlayer(age, gender, login, password, role, screenName);
        Map<String, Object> map = objectMapper.convertValue(newPlayer, Map.class);
        return map;
    }
}
    
