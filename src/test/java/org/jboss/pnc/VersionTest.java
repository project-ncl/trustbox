package org.jboss.pnc;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

@QuarkusTest
class VersionTest {
    @Test
    void testHelloEndpoint() {
        given().when().get("/version").then().statusCode(200);
    }

}