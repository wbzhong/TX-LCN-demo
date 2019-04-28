package org.txlcn.demo.servicea;

import com.codingapi.txlcn.common.util.Transactions;
import com.codingapi.txlcn.tracing.TracingContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.txlcn.demo.common.db.model.Orders;
import org.txlcn.demo.common.spring.ServiceBClient;
import org.txlcn.demo.common.spring.ServiceCClient;

import java.util.Date;


@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    private final OrderMapper orderMapper;

    private final ServiceBClient serviceBClient;

    private final ServiceCClient serviceCClient;

    private final RestTemplate restTemplate;

    @Autowired
    public OrderServiceImpl(OrderMapper orderMapper, ServiceBClient serviceBClient, ServiceCClient serviceCClient, RestTemplate restTemplate) {
        this.orderMapper = orderMapper;
        this.serviceBClient = serviceBClient;
        this.serviceCClient = serviceCClient;
        this.restTemplate = restTemplate;
    }


    @Override
    public String saveOrder(String username, String goodsName, int count) {

        // step1. 创建订单
        Orders orders = new Orders();
        orders.setGroupId(TracingContext.tracing().groupId());
        orders.setAppName(Transactions.getApplicationId());
        orders.setGoodsName(goodsName);
        orders.setGoodsCount(count);
        orders.setCreateTime(new Date());
        orderMapper.saveOrders(orders);
        String orderResp = "创建订单： 商品名称-" + goodsName + "- 数量-" + count;
        //step2. 检查用户是否为企业用户
        String checkResp = serviceBClient.checkUser(username);
        //String checkResp = restTemplate.getForObject("http://127.0.0.1:12002/checkuser?username=" + username, String.class);

        //step3. 检查库存
        String stockResp = serviceCClient.checkStock(goodsName, count);
        /*String stockResp = restTemplate.getForObject("http://127.0.0.1:12003/checkstock?goodsname=" + goodsName + "&count=" + count, String.class);*/

        if (checkResp.equals("fallback-b")) {
            return "非企业用户，订单创建失败";
        }
        if (stockResp.equals("fallback-c")) {
            return "库存不足，订单创建失败";
        }
        return orderResp + "  >>>>>>>>>>" + checkResp + "  >>>>>>>>>>" + stockResp + "  >>>>>>>>>>" + "创建成功，事务执行完毕";

    }
}
