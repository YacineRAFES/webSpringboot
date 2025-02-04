package fr.afpa.pompey.appweb.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "fr.afpa.pompey.appweb")
@Data
public class CustomProperties {

    private String apiUrl;
}
