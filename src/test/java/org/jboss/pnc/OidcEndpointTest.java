package org.jboss.pnc;

import io.quarkus.test.InjectMock;
import io.quarkus.test.junit.QuarkusTest;
import org.jboss.pnc.trustbox.OidcTokenRequest;
import org.jboss.pnc.trustbox.OidcTokenResponse;
import org.jboss.pnc.trustbox.keycloak.KeycloakClient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static io.restassured.RestAssured.given;

@QuarkusTest
public class OidcEndpointTest {

    @InjectMock
    KeycloakClient keycloakClient;

    @BeforeEach
    public void setup() {
        OidcTokenResponse response = new OidcTokenResponse();
        response.accessToken = "access-token";
        Mockito.when(keycloakClient.getToken("grant", "clientId", "clientSecret")).thenReturn(response);
    }

    @Test
    public void testEndpoint() {
        OidcTokenRequest request = new OidcTokenRequest();
        given().when().post("/oidc/token").then().statusCode(200);
    }
}
