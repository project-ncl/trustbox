package org.jboss.pnc.trustbox.keycloak;

import jakarta.ws.rs.FormParam;
import lombok.Builder;

/**
 * DTO for the keycloak request to the Keycloak server for OIDC token
 */
@Builder
public class KeycloakTokenRequest {

    /**
     * Grant type of the request
     */
    @FormParam("grant_type")
    public String grantType;

    /**
     * Client id to ask for the token
     */
    @FormParam("client_id")
    public String clientId;

    /**
     * Secret of the client
     */
    @FormParam("client_secret")
    public String clientSecret;

}
