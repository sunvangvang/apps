package com.aibyd.apps.core.data;

public class OAuth2ClientProperties {

    private String clientId;

    private String clientSecret;

    private Integer accessTokenValiditySeconds = 7200;

    /**
     * @return the clientId
     */
    public String getClientId() {
        return clientId;
    }

    /**
     * @param clientId the clientId to set
     */
    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    /**
     * @return the clientSecret
     */
    public String getClientSecret() {
        return clientSecret;
    }

    /**
     * @param clientSecret the clientSecret to set
     */
    public void setClientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
    }

    /**
     * @return the accessTokenValiditySeconds
     */
    public Integer getAccessTokenValiditySeconds() {
        return accessTokenValiditySeconds;
    }

    /**
     * @param accessTokenValiditySeconds the accessTokenValiditySeconds to set
     */
    public void setAccessTokenValiditySeconds(Integer accessTokenValiditySeconds) {
        this.accessTokenValiditySeconds = accessTokenValiditySeconds;
    }

}