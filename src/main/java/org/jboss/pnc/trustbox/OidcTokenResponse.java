package org.jboss.pnc.trustbox;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.extern.jackson.Jacksonized;

@Jacksonized
@Builder
public class OidcTokenResponse {
    @JsonProperty("access_token")
    public String accessToken;
}
