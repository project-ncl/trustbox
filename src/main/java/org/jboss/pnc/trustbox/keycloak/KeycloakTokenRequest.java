package org.jboss.pnc.trustbox.keycloak;

import jakarta.ws.rs.FormParam;
import lombok.Builder;

@Builder
public class KeycloakTokenRequest {

    @FormParam("grant_type")
    public String grantType;

    @FormParam("client_id")
    public String clientId;

    @FormParam("client_secret")
    public String clientSecret;

}
