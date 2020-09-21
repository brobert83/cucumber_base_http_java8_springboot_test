package org.robs.cucumber_base_http_java8_springboot_test.bdd;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/bdd/resources/features",
        plugin = {"pretty", "html:target/cucumber.html"},
        extraGlue = {"org.robs.cucumber_base_http_java8"}
)
public class CucumberTest {

}
