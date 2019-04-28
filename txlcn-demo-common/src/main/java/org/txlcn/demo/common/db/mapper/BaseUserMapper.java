package org.txlcn.demo.common.db.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * @ClassName BaseUserMapper
 * @Description TODO
 * @Author zwb
 * @Date 2019/4/23 17:32
 * @Vision 1.0
 */
@Mapper
public interface BaseUserMapper {
    @Select("select vip from user where username=#{username}")
    int checkifVip(String username);

    @Update("update user set group_id=#{groupId},app_name=#{appName} where username=#{username}")
    void updateUser(@Param("groupId") String groupId, @Param("appName") String appName, @Param("username") String username);
}
