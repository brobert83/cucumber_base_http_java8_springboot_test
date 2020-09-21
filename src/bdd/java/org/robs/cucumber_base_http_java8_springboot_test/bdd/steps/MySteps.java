package org.robs.cucumber_base_http_java8_springboot_test.bdd.steps;

import io.cucumber.java.en.Then;
import org.robs.cucumber_base_http_java8.HttpRequestStepsContext;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThat;

public class MySteps {

    @Autowired HttpRequestStepsContext httpRequestStepsContext;

    @Then("^the body size is '(.*)'$")
    public void myStep(int size) {
        assertThat(httpRequestStepsContext.getHttpResponse().getBody()).hasSize(size);
    }

}