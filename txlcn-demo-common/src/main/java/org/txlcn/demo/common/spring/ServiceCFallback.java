package org.txlcn.demo.common.spring;

import com.codingapi.txlcn.tc.support.DTXUserControls;
import com.codingapi.txlcn.tracing.TracingContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;



@Component
@Slf4j
public class ServiceCFallback implements ServiceCClient {

    @Override
    public String checkStock(@RequestParam("goodsname") String goodsName, @RequestParam("count") int count){
        DTXUserControls.rollbackGroup(TracingContext.tracing().groupId());
        return "fallback-c";
    }
}
