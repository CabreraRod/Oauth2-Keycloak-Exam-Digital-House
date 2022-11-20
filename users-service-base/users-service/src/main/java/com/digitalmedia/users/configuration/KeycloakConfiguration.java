package com.digitalmedia.users.configuration;
import org.keycloak.admin.client.Keycloak;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KeycloakConfiguration {

    private String serverUrl;
    private String realm;
    private String clientId;
    private String clientSecret;

    public Keycloak buildCliente(){
        return KeycloakBuilder
    }

}
