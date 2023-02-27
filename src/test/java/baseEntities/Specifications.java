package baseEntities;

import core.ReadProperties;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.apache.http.HttpStatus;

public class Specifications {
    protected final static String baseURL = ReadProperties.getInstance().getApiURL();

    public static RequestSpecification reqSpec() {
        return new RequestSpecBuilder()
                .setBaseUri(baseURL)
                .setContentType(ContentType.JSON)
                .log(LogDetail.ALL)
                .build();
    }

    public static ResponseSpecification respSpecOk() {
        return new ResponseSpecBuilder()
                .log(LogDetail.ALL)
                .expectStatusCode(HttpStatus.SC_OK)
                .build();
    }

    public static ResponseSpecification respSpec(int statusCode) {
        return new ResponseSpecBuilder()
                .expectStatusCode(statusCode)
                .build();
    }
}
