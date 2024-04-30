package org.jboss.pnc.trustbox;

import lombok.Builder;
import lombok.extern.jackson.Jacksonized;

@Jacksonized
@Builder
public class OidcTokenRequest {

    /**
     * Should be the same format as what quarkus wants it: aka https://{server}/auth/realms/{realm}
     */
    String authServerUrl;

    /**
     * Client id to authenticate
     */
    String clientId;

    /**
     * Client secret
     */
    String clientSecret;
}
