package org.txlcn.demo.common.db.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @ClassName Orders
 * @Description TODO
 * @Author zwb
 * @Date 2019/4/23 14:29
 * @Vision 1.0
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Orders {
    private int id;
    private String groupId;
    private String appName;
    private String goodsName;
    private int goodsCount;
    private Date createTime;
}
