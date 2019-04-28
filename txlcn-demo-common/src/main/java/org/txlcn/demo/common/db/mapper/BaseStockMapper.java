package org.txlcn.demo.common.db.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * @ClassName BaseStockMapper
 * @Description TODO
 * @Author zwb
 * @Date 2019/4/23 14:39
 * @Vision 1.0
 */
@Mapper
public interface BaseStockMapper {
    @Select("select goods_amount from stock where goods_name=#{name}")
    int selectAmountbyGoodsName(@Param("name") String name);

    @Update("update stock set goods_amount=#{amount},group_id=#{groupId},app_name=#{appName} where goods_name=#{name}")
    void updateStock(@Param("amount") int amount, @Param("groupId") String groupId, @Param("appName") String appName, @Param("name") String name);
}
