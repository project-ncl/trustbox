package org.jboss.pnc;

import io.quarkus.test.InjectMock;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import org.jboss.pnc.api.trustbox.OidcTokenRequest;
import org.jboss.pnc.api.trustbox.OidcTokenResponse;
import org.jboss.pnc.trustbox.keycloak.KeycloakClient;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static io.restassured.RestAssured.given;

@QuarkusTest
public class OidcEndpointImplTest {

    @InjectMock
    KeycloakClient keycloakClient;

    @BeforeEach
    public void setup() {
        OidcTokenResponse response = OidcTokenResponse.builder().accessToken("access-token").build();
        Mockito.when(keycloakClient.getToken("keycloakUrl", "clientId", "clientSecret")).thenReturn(response);
    }

    @Test
    public void testEndpoint() {
        OidcTokenRequest request = OidcTokenRequest.builder()
                .authServerUrl("keycloakUrl")
                .clientId("clientId")
                .clientSecret("clientSecret")
                .build();
        OidcTokenResponse response = given().when()
                .body(request)
                .contentType(ContentType.JSON)
                .post("/oidc/token")
                .then()
                .contentType(ContentType.JSON)
                .assertThat()
                .extract()
                .body()
                .as(OidcTokenResponse.class);
        Assertions.assertEquals(response.getAccessToken(), "access-token");
    }
}
