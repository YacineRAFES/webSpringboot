package fr.afpa.pompey.appweb;

import fr.afpa.pompey.appweb.config.CustomProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class AppWebApplication implements CommandLineRunner {

    @Autowired
    private CustomProperties customProperties;

    public static void main(String[] args) {
        SpringApplication.run(AppWebApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("API URL: " + customProperties.getApiUrl());
    }

}
