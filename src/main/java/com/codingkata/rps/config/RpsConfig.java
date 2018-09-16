package com.codingkata.rps.config;

import com.codingkata.rps.service.RpsFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Configuration for RPS related classes.
 *
 * @author Tim Silhan
 */
@Configuration
public class RpsConfig {
    @Bean
    RpsFactory rpsFactory() {
        return new RpsFactory();
    }
}
