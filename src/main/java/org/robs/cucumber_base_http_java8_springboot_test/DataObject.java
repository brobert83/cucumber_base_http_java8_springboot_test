package org.robs.cucumber_base_http_java8_springboot_test;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DataObject {
    private String name, status;
}
