package org.jboss.pnc.trustbox.keycloak;

import io.quarkus.rest.client.reactive.QuarkusRestClientBuilder;
import jakarta.enterprise.context.ApplicationScoped;
import org.jboss.pnc.api.trustbox.TrustboxTokenResponse;

import java.net.URI;

/**
 * Class that will fetch the OIDC token given relevant information
 */
@ApplicationScoped
public class KeycloakClient {

    /**
     * Get the OIDC token given the parameters
     * 
     * @param keycloakUrl keycloak instance to get the token
     * @param clientId client id to use
     * @param clientSecret secret
     * @return OIDC token
     */
    public TrustboxTokenResponse getToken(String keycloakUrl, String clientId, String clientSecret) {
        KeycloakService keycloakService = QuarkusRestClientBuilder.newBuilder()
                .baseUri(URI.create(keycloakUrl))
                .build(KeycloakService.class);
        return keycloakService.getToken(new KeycloakTokenRequest("client_credentials", clientId, clientSecret));
    }
}
