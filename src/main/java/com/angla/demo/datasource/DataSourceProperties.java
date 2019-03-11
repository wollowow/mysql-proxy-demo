package com.angla.demo.datasource;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * Title:DataSourceProperties
 *
 * @author angla
 **/

@Data
@Component
@ConfigurationProperties(prefix = "spring")
public class DataSourceProperties {

    private List<Map<String,String>> mastersources;

    private List<Map<String,String>> slavesources;

}
