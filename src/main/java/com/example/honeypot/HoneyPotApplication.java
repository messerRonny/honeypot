package com.example.honeypot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.Environment;

import javax.annotation.PostConstruct;
import java.util.Arrays;

@SpringBootApplication@EnableFeignClients(
        basePackages = { "com.example.smallinvoicespringfeign.api"}
)
@ComponentScan({"com.example.smallinvoicespringfeign","com.example.honeypot"})
public class HoneyPotApplication {

    @Autowired
    private Environment env;

    public static void main(String[] args) {
        SpringApplication.run(HoneyPotApplication.class, args);
    }

    @PostConstruct
    public void afterInit() {
        String applicationName = env.getProperty("spring.application.name");
        boolean hasDevProfile = Arrays.asList(env.getActiveProfiles()).contains("dev");
        String openApiInfo="";
        if (hasDevProfile) {
            openApiInfo = "http://localhost:8080/v3/api-docs\n" +
                    "http://localhost:8080/v3/api-docs.yaml -> yaml file is downloaded -> https://editor.swagger.io/\n" +
                    "http://localhost:8080/swagger-ui.html \n";
        }

        System.out.println("\n\nApplication [" + applicationName + "] - Enter in Browser:\nhttp://localhost:8080 \n" +
                openApiInfo + "\n" +
                "Active Profiles: " + Arrays.toString(env.getActiveProfiles()) + "\n\n");
    }
}
