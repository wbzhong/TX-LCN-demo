package org.txlcn.demo.common.db.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName User
 * @Description TODO
 * @Author zwb
 * @Date 2019/4/23 17:29
 * @Vision 1.0
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {
    private int id;
    private String groupId;
    private String appName;
    private String username;
    private int vip;
}
