package org.robs.cucumber_base_http_java8_springboot_test.bdd.steps;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.spring.CucumberContextConfiguration;
import io.github.brobert83.cucumber_http_java8.request_handlers.HttpRequestHandler;
import io.github.brobert83.cucumber_http_java8.CucumberHttpSpringConfig;
import io.github.brobert83.cucumber_http_java8.request_handlers.unirest.common.SendUnirestRequestWithBody;
import kong.unirest.HttpResponse;
import kong.unirest.Unirest;
import org.robs.cucumber_base_http_java8_springboot_test.CucumberBaseHttpJava8SpringBootTestApplication;
import org.slf4j.Logger;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.ActiveProfiles;

import java.util.Map;
import java.util.function.Supplier;

import static org.slf4j.LoggerFactory.getLogger;

@ActiveProfiles("cucumber")
@CucumberContextConfiguration
@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
        classes = {
                CucumberHttpStepsConfiguration.SpringTestConfig.class,
                CucumberHttpSpringConfig.class,
                CucumberBaseHttpJava8SpringBootTestApplication.class
        }
)
public class CucumberHttpStepsConfiguration {

    private static final Logger logger = getLogger(CucumberHttpStepsConfiguration.class);

    @Lazy
    @Profile("cucumber")
    @Configuration
    public static class SpringTestConfig {

        // ==== Customizations ====
        @Bean
        Supplier<ObjectMapper> objectMapperSupplier(ObjectMapper objectMapper) {
            return () -> objectMapper;
        }

        @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
        @Bean
        Supplier<String> baseUrl(@LocalServerPort int port) {
            return () -> "http://localhost:" + port;
        }

        @Bean
        boolean customPostHandler(Map<String, HttpRequestHandler<HttpResponse<String>>> unirestHttpHandlers, SendUnirestRequestWithBody sendUnirestRequestWithBody) {
            unirestHttpHandlers.put("post", context -> {
                logger.info("Sending custom post request");
                return sendUnirestRequestWithBody.apply(Unirest.post(context.getUrl()), context);
            });
            return true;
        }
    }

}
