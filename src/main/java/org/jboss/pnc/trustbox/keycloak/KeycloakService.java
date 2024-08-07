package org.jboss.pnc.trustbox.keycloak;

import jakarta.ws.rs.BeanParam;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import org.jboss.pnc.api.trustbox.TrustboxTokenResponse;

/**
 * REST endpoint to get the OIDC token
 */
@Path("/")
@RegisterRestClient
public interface KeycloakService {

    /**
     * token endpoint, given the relevant keycloak information
     */
    @POST
    @Path("/protocol/openid-connect/token")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    public TrustboxTokenResponse getToken(@BeanParam KeycloakTokenRequest keycloakRequest);
}
