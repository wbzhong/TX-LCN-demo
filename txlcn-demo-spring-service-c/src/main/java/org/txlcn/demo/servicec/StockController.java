package org.txlcn.demo.servicec;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;


@RestController
public class StockController {

    @Autowired
    private StockService stockService;

    @GetMapping("/checkstock")
    public String checkStock(@RequestParam("goodsname") String goodsName, @RequestParam("count") int count) {
        return stockService.checkStock(goodsName, count);
    }
}
