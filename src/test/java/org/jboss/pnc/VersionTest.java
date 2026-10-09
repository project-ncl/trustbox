package org.jboss.pnc;

import static io.restassured.RestAssured.given;

import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
class VersionTest {
    @Test
    void testHelloEndpoint() {
        given().when().get("/version").then().statusCode(200);
    }

}