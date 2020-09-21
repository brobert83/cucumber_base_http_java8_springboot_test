package org.robs.cucumber_base_http_java8_springboot_test;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RequestMapping("/api")
@RestController
public class TestController {

    @RequestMapping(method = RequestMethod.POST, consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public String createSomething(@RequestBody String request) {

        if (request.equals("{\"name\":\"eve\",\"status\":\"new\"}"))
            return "{\"id\":123,\"name\":\"eve\",\"status\":\"new\"}";

        throw new RuntimeException("no good");
    }


    @RequestMapping(path = "/{id}", method = RequestMethod.GET, produces = APPLICATION_JSON_VALUE)
    public String getSomething(@PathVariable("id") int id) {

        if (id == 234) return "{\"name\":\"john\",\"status\":\"active\"}";

        throw new RuntimeException("no good");
    }

}
