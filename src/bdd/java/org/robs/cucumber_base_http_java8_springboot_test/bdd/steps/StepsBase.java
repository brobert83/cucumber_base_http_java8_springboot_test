package org.robs.cucumber_base_http_java8_springboot_test.bdd.steps;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.spring.CucumberContextConfiguration;
import io.github.brobert83.cucumber_http_java8.request_handlers.unirest.CucumberBaseSpringConfig;
import org.robs.cucumber_base_http_java8_springboot_test.CucumberBaseHttpJava8SpringBootTestApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.ActiveProfiles;

import java.util.function.Supplier;

@ActiveProfiles("cucumber")
@CucumberContextConfiguration
@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
        classes = {
                StepsBase.SpringTestConfig.class,
                CucumberBaseSpringConfig.class,
                CucumberBaseHttpJava8SpringBootTestApplication.class
        }
)
public class StepsBase {

    @Lazy
    @Profile("cucumber")
    @Configuration
    public static class SpringTestConfig {

        // ==== REQUIRED BY HttpSteps ====
        @Bean
        Supplier<ObjectMapper> objectMapperSupplier(ObjectMapper objectMapper) {
            return () -> objectMapper;
        }

        @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
        @Bean
        Supplier<String> baseUrl(@LocalServerPort int port) {
            return () -> "http://localhost:" + port;
        }

    }

}
