package org.txlcn.demo.servicec;

import com.codingapi.txlcn.common.util.Transactions;
import com.codingapi.txlcn.tc.annotation.DTXPropagation;
import com.codingapi.txlcn.tc.annotation.TxcTransaction;
import com.codingapi.txlcn.tracing.TracingContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;


@Service
@Slf4j
public class StockServiceImpl implements StockService {

    private final StockMapper stockMapper;

    private ConcurrentHashMap<String, Set<Long>> ids = new ConcurrentHashMap<>();

    @Autowired
    public StockServiceImpl(StockMapper stockMapper) {
        this.stockMapper = stockMapper;
    }

    @Override
    @TxcTransaction(propagation = DTXPropagation.SUPPORTS)
    @Transactional
    public String checkStock(String goodsName, int count) {                 //检查库存是否充足
        String msg;
        int goods_amount = stockMapper.selectAmountbyGoodsName(goodsName);
        if (goods_amount < count) {
            throw new IllegalStateException("sorry , goods stock is not enough");
        } else {
            int newAmount = goods_amount - count;
            String groupId = TracingContext.tracing().groupId();
            String appName = Transactions.getApplicationId();
            stockMapper.updateStock(newAmount, groupId, appName, goodsName);

            if (newAmount > 10) {
                msg = "库存充足，可放心下单";
            } else {
                msg = "还有少量库存，请尽快下单";
            }
        }
        return goodsName + msg;
    }

}
