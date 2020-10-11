package org.robs.cucumber_base_http_java8_springboot_test.bdd.steps;

import io.cucumber.java.en.Then;
import io.github.brobert83.cucumber_http_java8.CucumberHttpContext;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThat;

public class MySteps {

    @SuppressWarnings("SpringJavaAutowiredMembersInspection")
    @Autowired CucumberHttpContext cucumberHttpContext;

    @Then("^the body size is '(.*)'$")
    public void myStep(int size) {
        assertThat(cucumberHttpContext.getHttpResponse().getBody()).hasSize(size);
    }

}
