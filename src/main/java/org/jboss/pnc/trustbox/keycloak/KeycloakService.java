package org.jboss.pnc.trustbox.keycloak;

import jakarta.ws.rs.BeanParam;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import org.jboss.pnc.trustbox.OidcTokenResponse;

@Path("/")
@RegisterRestClient
public interface KeycloakService {

    @POST
    @Path("/protocol/openid-connect/token")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    public OidcTokenResponse getToken(@BeanParam KeycloakTokenRequest keycloakRequest);
}
