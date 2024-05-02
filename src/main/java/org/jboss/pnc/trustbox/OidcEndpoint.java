package org.jboss.pnc.trustbox;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.jboss.pnc.trustbox.keycloak.KeycloakClient;

@Path("/oidc")
public class OidcEndpoint {

    @Inject
    KeycloakClient keycloakClient;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("token")
    public OidcTokenResponse getOidcToken(OidcTokenRequest oidcTokenRequest) {
        return keycloakClient
                .getToken(oidcTokenRequest.authServerUrl, oidcTokenRequest.clientId, oidcTokenRequest.clientSecret);
    }
}
