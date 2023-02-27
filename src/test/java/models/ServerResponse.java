package models;

import com.google.gson.annotations.Expose;
import lombok.Data;


@Data

public class ServerResponse {
    protected static ServerResponse instance;
    @Expose
    private Integer age;
    @Expose
    private String gender;
    @Expose
    private Integer id;
    @Expose
    private String login;
    @Expose
    private String password;
    @Expose
    private String role;
    @Expose
    private String screenName;

//    public ServerResponse(Integer age, String gender, Integer id, String login, String password, String role, String screenName) {
//        this.age = age;
//        this.gender = gender;
//        this.id = id;
//        this.login = login;
//        this.password = password;
//        this.role = role;
//        this.screenName = screenName;
//    }

    public static ServerResponse getResponse() {
        if (instance == null) {
            instance = new ServerResponse();
        }
        return instance;
    }
}