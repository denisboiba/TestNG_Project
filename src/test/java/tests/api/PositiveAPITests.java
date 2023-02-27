package tests.api;

import adapters.ProjectAdapter;
import baseEntities.BaseApiTest;
import endpoints.Endpoints;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import models.CreatePlayer;
import models.PlayerID;
import org.testng.annotations.Test;

import static baseEntities.Specifications.*;
import static io.restassured.RestAssured.given;

public class PositiveAPITests extends BaseApiTest {

    @Severity(SeverityLevel.CRITICAL)
    @Test(description = "Create player")
    public void createPlayerTest() {
        logger.info("Sending a GET request to create a player");
        given()
                .spec(reqSpec())
                .pathParam("editor", ADMIN_ROLE)
                .queryParams(GetMapForNewPlayer(30, MALE, "TTgbggiihi", "TTYHnbgry5656", USER_ROLE, "TYhghnjhjhgn"))
                .when()
                .get(Endpoints.CREATE_PLAYER)
                .then()
                .spec(respSpecOk());
        logger.info("Getting a response/checking the received data");
    }

    @Severity(SeverityLevel.CRITICAL)
    @Test(description = "Удалить игрока")
    public void deletePlayerTest() {
        logger.info("Sending a DELETE request to delete a player");
        PlayerID playerID = new PlayerID(ProjectAdapter.getAllPlayersId().get(1));
        given()
                .spec(reqSpec())
                .pathParam("editor", ADMIN_ROLE)
                .body(playerID)
                .when()
                .delete(Endpoints.DELETE_PLAYER)
                .then()
                .spec(respSpec(204));
        logger.info("Getting a response/checking the received data");
    }

    @Severity(SeverityLevel.CRITICAL)
    @Test(description = "Получить игрока по ИД")
    public void getPlayerByIdTest() {
        logger.info("Sending a POST request to get a player by ID");
        PlayerID playerID = new PlayerID(ProjectAdapter.getAllPlayersId().get(1));
        given()
                .spec(reqSpec())
                .body(playerID)
                .when()
                .post(Endpoints.GET_PLAYER_BY_ID)
                .then()
                .spec(respSpecOk());
        logger.info("Getting a response/checking the received data");
    }

    @Severity(SeverityLevel.CRITICAL)
    @Test(description = "Получить всех игроков")
    public void getAllPlayersTest() {
        logger.info("Sending a GET request to get all the players");
        given()
                .spec(reqSpec())
                .when()
                .get(Endpoints.GET_ALL_PLAYERS)
                .then()
                .spec(respSpecOk());
        logger.info("Getting a response/checking the received data");
    }

    @Severity(SeverityLevel.CRITICAL)
    @Test(description = "Обновить игрока")
    public void UpdatePlayerTest() {
        logger.info("Sending a PATCH request to update the player");
        CreatePlayer createPlayer = new CreatePlayer(29, MALE, "ghghghghgh", "LFfbbuhggfhy7", USER_ROLE, "Zohhan");
        PlayerID playerID = new PlayerID(ProjectAdapter.getAllPlayersId().get(1));
        given()
                .spec(reqSpec())
                .pathParam("editor", ADMIN_ROLE)
                .pathParam("id", playerID.getPlayerId())
                .body(createPlayer)
                .when()
                .patch(Endpoints.UPDATE_PLAYER)
                .then()
                .spec(respSpecOk());
        logger.info("Getting a response/checking the received data");
    }
}