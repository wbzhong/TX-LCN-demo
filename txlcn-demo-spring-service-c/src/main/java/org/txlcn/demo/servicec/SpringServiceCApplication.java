package org.txlcn.demo.servicec;

import com.codingapi.txlcn.tc.config.EnableDistributedTransaction;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@SpringBootApplication
@EnableDiscoveryClient
@EnableDistributedTransaction
public class SpringServiceCApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringServiceCApplication.class, args);
    }
}
