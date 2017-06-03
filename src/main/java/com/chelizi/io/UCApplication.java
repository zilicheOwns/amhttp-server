package com.chelizi.io;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 *  Created by chelizi on 17/5/18.
 *
 */

@SpringBootApplication
public class UCApplication extends SpringBootServletInitializer implements EmbeddedServletContainerCustomizer {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(UCApplication.class, args);
    }

    @Override
    public void customize(ConfigurableEmbeddedServletContainer container) {
        container.setPort(8090);
    }
}
