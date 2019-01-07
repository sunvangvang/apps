package com.aibyd.apps.core.data;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "aibyd.security.oauth2")
public class CustomOAuth2Properties {

    private OAuth2ClientProperties[] clients = {};

    /**
     * @return the clients
     */
    public OAuth2ClientProperties[] getClients() {
        return clients;
    }

    /**
     * @param clients the clients to set
     */
    public void setClients(OAuth2ClientProperties[] clients) {
        this.clients = clients;
    }

}