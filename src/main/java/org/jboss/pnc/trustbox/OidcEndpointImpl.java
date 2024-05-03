package org.jboss.pnc.trustbox;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.jboss.pnc.api.trustbox.OidcEndpoint;
import org.jboss.pnc.api.trustbox.OidcTokenRequest;
import org.jboss.pnc.api.trustbox.OidcTokenResponse;
import org.jboss.pnc.trustbox.keycloak.KeycloakClient;

@ApplicationScoped
public class OidcEndpointImpl implements OidcEndpoint {

    @Inject
    KeycloakClient keycloakClient;

    public OidcTokenResponse getOidcToken(OidcTokenRequest oidcTokenRequest) {
        return keycloakClient.getToken(
                oidcTokenRequest.getAuthServerUrl(),
                oidcTokenRequest.getClientId(),
                oidcTokenRequest.getClientSecret());
    }
}
