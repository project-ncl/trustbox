package org.jboss.pnc.trustbox.keycloak;

import io.quarkus.rest.client.reactive.QuarkusRestClientBuilder;
import jakarta.enterprise.context.ApplicationScoped;
import org.jboss.pnc.api.trustbox.TrustboxTokenResponse;

import java.net.URI;

@ApplicationScoped
public class KeycloakClient {

    public TrustboxTokenResponse getToken(String keycloakUrl, String clientId, String clientSecret) {
        KeycloakService keycloakService = QuarkusRestClientBuilder.newBuilder()
                .baseUri(URI.create(keycloakUrl))
                .build(KeycloakService.class);
        return keycloakService.getToken(new KeycloakTokenRequest("client_credentials", clientId, clientSecret));
    }
}
