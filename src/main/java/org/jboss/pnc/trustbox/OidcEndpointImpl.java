package org.jboss.pnc.trustbox;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.jboss.pnc.api.trustbox.TrustboxEndpoint;
import org.jboss.pnc.api.trustbox.TrustboxTokenRequest;
import org.jboss.pnc.api.trustbox.TrustboxTokenResponse;
import org.jboss.pnc.trustbox.keycloak.KeycloakClient;

@ApplicationScoped
public class OidcEndpointImpl implements TrustboxEndpoint {

    @Inject
    KeycloakClient keycloakClient;

    public TrustboxTokenResponse getOidcToken(TrustboxTokenRequest oidcTokenRequest) {
        return keycloakClient.getToken(
                oidcTokenRequest.getAuthServerUrl(),
                oidcTokenRequest.getClientId(),
                oidcTokenRequest.getClientSecret());
    }
}
