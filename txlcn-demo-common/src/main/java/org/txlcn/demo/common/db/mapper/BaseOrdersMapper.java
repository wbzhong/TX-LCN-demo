package org.txlcn.demo.common.db.mapper;

import org.apache.ibatis.annotations.*;
import org.txlcn.demo.common.db.model.Orders;

/**
 * @ClassName BaseOrdersMapper
 * @Description TODO
 * @Author zwb
 * @Date 2019/4/23 14:35
 * @Vision 1.0
 */
@Mapper
public interface BaseOrdersMapper {
    @Insert("insert into orders(group_id, goods_name, goods_count,app_name, create_time) values(#{groupId},#{goodsName}, #{goodsCount},#{appName}, #{createTime})")
    void saveOrders(Orders orders);

    /*@Delete("delete from orders where id=#{id}")
    void deleteByGoodsId(int id);*/

}
