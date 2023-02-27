package models;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CreatePlayer {

    private Integer age;
    private String gender;
    private String login;
    private String password;
    private String role;
    private String screenName;

    public CreatePlayer(Integer age, String gender, String login, String password, String role, String screenName) {
        this.age = age;
        this.gender = gender;
        this.login = login;
        this.password = password;
        this.role = role;
        this.screenName = screenName;
    }
}