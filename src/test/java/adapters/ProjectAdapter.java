package adapters;

import baseEntities.BaseAdapter;
import endpoints.Endpoints;
import models.ServerResponse;

import java.util.List;
import java.util.stream.Collectors;

import static baseEntities.Specifications.reqSpec;
import static io.restassured.RestAssured.given;


public class ProjectAdapter extends BaseAdapter {

    public static List<Integer> getAllPlayersId() {
        List<ServerResponse> playersList = given()
                .spec(reqSpec())
                .when()
                .get(Endpoints.GET_ALL_PLAYERS)
                .then()
                .extract().body().jsonPath().getList("players", ServerResponse.class);
        List<Integer> allIdList = playersList.stream().map(ServerResponse::getId).collect(Collectors.toList());
        return allIdList;
    }
}
