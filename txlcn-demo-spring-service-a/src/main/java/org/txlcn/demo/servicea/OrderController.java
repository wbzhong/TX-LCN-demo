package org.txlcn.demo.servicea;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @RequestMapping("/saveorder")
    public String saveOrder(@RequestParam("username") String username, @RequestParam("goodsname") String goodsName, @RequestParam("count") int count) {
        return orderService.saveOrder(username, goodsName, count);
    }

}
