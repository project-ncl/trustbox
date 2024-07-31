package org.jboss.pnc.trustbox;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.jboss.pnc.api.dto.ComponentVersion;
import org.jboss.pnc.trustbox.constants.BuildInformationConstants;

import java.time.ZonedDateTime;

/**
 * Main REST entry point for this application
 */
@Path("/")
public class Public {

    @ConfigProperty(name = "quarkus.application.name")
    String name;

    /**
     * Get version of this application
     * 
     * @return version DTO
     */
    @GET
    @Path("/version")
    public ComponentVersion getVersion() {
        return ComponentVersion.builder()
                .name(name)
                .version(BuildInformationConstants.VERSION)
                .commit(BuildInformationConstants.COMMIT_HASH)
                .builtOn(ZonedDateTime.parse(BuildInformationConstants.BUILD_TIME))
                .build();
    }
}
