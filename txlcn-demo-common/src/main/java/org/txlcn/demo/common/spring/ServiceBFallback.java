package org.txlcn.demo.common.spring;

import com.codingapi.txlcn.tc.support.DTXUserControls;
import com.codingapi.txlcn.tracing.TracingContext;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;


@Component
public class ServiceBFallback implements ServiceBClient {

    @Override
    public String checkUser(@RequestParam("username") String username) {
        DTXUserControls.rollbackGroup(TracingContext.tracing().groupId());
        return "fallback-b";
    }
}
