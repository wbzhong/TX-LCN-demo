package org.txlcn.demo.common.spring;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@FeignClient(value = "txlcn-demo-spring-service-b", fallback = ServiceBFallback.class)
public interface ServiceBClient {


    @GetMapping("/checkuser")
    String checkUser(@RequestParam("username") String username);

}
