package com.attson.knife4jserver.config;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;
import org.springframework.context.annotation.Configuration;

@ConfigurationProperties(prefix = "knife4j.server")
@Configuration
public class ServerConfig {
    @NestedConfigurationProperty
    private Login login;

    public void setLogin(Login login) {
        this.login = login;
    }

    public Login getLogin() {
        return login;
    }
    public static class Login {

        @NestedConfigurationProperty
        private Feishu feishu = null;

        public Feishu getFeishu() {
            return feishu;
        }

        public void setFeishu(Feishu feishu) {
            this.feishu = feishu;
        }

        public static class Feishu {
            private String appId;

            private String appSecret;

            private String redirectUri;

            public String getAppId() {
                return appId;
            }

            public void setAppId(String appId) {
                this.appId = appId;
            }

            public String getAppSecret() {
                return appSecret;
            }

            public void setAppSecret(String appSecret) {
                this.appSecret = appSecret;
            }

            public String getRedirectUri() {
                return redirectUri;
            }

            public void setRedirectUri(String redirectUri) {
                this.redirectUri = redirectUri;
            }
        }
    }
}
