package org.txlcn.demo.common.spring;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;


@FeignClient(value = "txlcn-demo-spring-service-c", fallback = ServiceCFallback.class)
public interface ServiceCClient {

    @GetMapping("/checkstock")
    String checkStock(@RequestParam("goodsname") String goodsName, @RequestParam("count") int count);


}
