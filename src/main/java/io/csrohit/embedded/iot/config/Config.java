package io.csrohit.embedded.iot.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource({"classpath:api-keys.properties"})
public class Config {
    @Value("${slack.channel.portfolio.webhook}")
    private String PORTFOLIO_WEBHOOK;

    public String getPORTFOLIO_WEBHOOK() {
        return PORTFOLIO_WEBHOOK;
    }

}
