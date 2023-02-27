package tests.api;

import adapters.ProjectAdapter;
import baseEntities.BaseApiTest;
import endpoints.Endpoints;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.restassured.http.ContentType;
import models.CreatePlayer;
import models.PlayerID;
import org.testng.annotations.Test;

import static baseEntities.Specifications.*;
import static io.restassured.RestAssured.given;

public class NegativeAPITests extends BaseApiTest {

    @Severity(SeverityLevel.NORMAL)
    @Test(description = "Создать игрока")
    public void createPlayerNegativeTest() {
        logger.info("Sending a GET request to create a player");
        given()
                .spec(reqSpec())
                .pathParam("editor", USER_ROLE)
                .queryParams(GetMapForNewPlayer(15, MALE, "eiurguihi", "ieuryiurygfuirnk", ADMIN_ROLE, "klfjkhghgn"))
                .when()
                .get(Endpoints.CREATE_PLAYER)
                .then()
                .spec(respSpec(403));
        logger.info("Getting a response/checking the received data");
    }

    @Severity(SeverityLevel.NORMAL)
    @Test(description = "Удалить игрока")
    public void deletePlayerNegativeTest() {
        logger.info("Sending a DELETE request to delete a player");
        PlayerID playerID = new PlayerID(ProjectAdapter.getAllPlayersId().get(0));
        given()
                .spec(reqSpec())
                .pathParam("editor", USER_ROLE)
                .body(playerID)
                .when()
                .delete(Endpoints.DELETE_PLAYER)
                .then()
                .spec(respSpec(403));
        logger.info("Getting a response/checking the received data");
    }

    @Severity(SeverityLevel.NORMAL)
    @Test(description = "Получить игрока по ИД")
    public void getPlayerByIdNegativeTest() {
        logger.info("Sending a POST request to get a player by ID");
        given()
                .spec(reqSpec())
                .body(USER_ROLE)
                .when()
                .post(Endpoints.GET_PLAYER_BY_ID)
                .then()
                .spec(respSpec(400));
        logger.info("Getting a response/checking the received data");
    }

    @Severity(SeverityLevel.NORMAL)
    @Test(description = "Получить всех игроков")
    public void getAllPlayersNegativeTest() {
        logger.info("Sending a GET request to get all the players");
        given()
                .spec(reqSpec())
                .when()
                .patch(Endpoints.GET_ALL_PLAYERS)
                .then()
                .spec(respSpec(405));
        logger.info("Getting a response/checking the received data");
    }

    @Severity(SeverityLevel.NORMAL)
    @Test(description = "Обновить игрока")
    public void UpdatePlayerNegativeTest() {
        logger.info("Sending a PATCH request to update the player");
        CreatePlayer createPlayer = new CreatePlayer(29, MALE, "ghghghghgh", "LFfbbuhggfhy7", ADMIN_ROLE, "Zohhan");
        PlayerID playerID = new PlayerID(ProjectAdapter.getAllPlayersId().get(1));
        given()
                .spec(reqSpec())
                .pathParam("editor", USER_ROLE)
                .pathParam("id", playerID.getPlayerId())
                .body(createPlayer)
                .when()
                .patch(Endpoints.UPDATE_PLAYER)
                .then()
                .spec(respSpec(403));
        logger.info("Getting a response/checking the received data");
    }
}
