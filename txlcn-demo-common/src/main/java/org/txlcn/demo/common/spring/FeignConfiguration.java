package org.txlcn.demo.common.spring;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@ComponentScan
@Configuration
@EnableFeignClients
public class FeignConfiguration {
}
