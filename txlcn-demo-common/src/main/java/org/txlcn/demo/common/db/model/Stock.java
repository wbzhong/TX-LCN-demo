package org.txlcn.demo.common.db.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName Stock
 * @Description TODO
 * @Author zwb
 * @Date 2019/4/23 14:33
 * @Vision 1.0
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Stock {
    private int id;
    private String groupId;
    private String goodsName;
    private int goodsAmount;
}
