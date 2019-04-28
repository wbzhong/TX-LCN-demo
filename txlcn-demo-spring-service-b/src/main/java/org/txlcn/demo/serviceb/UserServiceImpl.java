package org.txlcn.demo.serviceb;

import com.codingapi.txlcn.common.util.Transactions;
import com.codingapi.txlcn.tc.annotation.DTXPropagation;
import com.codingapi.txlcn.tc.annotation.TxcTransaction;
import com.codingapi.txlcn.tracing.TracingContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;

    @Autowired
    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    @TxcTransaction(propagation = DTXPropagation.SUPPORTS)
    @Transactional
    public String checkUser(String username) {                  //检查是否为企业用户
        String checkResp;
        int vipCode = userMapper.checkifVip(username);
        String appName = Transactions.getApplicationId();
        String groupId = TracingContext.tracing().groupId();
        userMapper.updateUser(groupId, appName, username);
        if (vipCode != 1) {
            throw new IllegalStateException("sorry ,you are not vip user");
        } else {
            checkResp = "验证用户为企业用户，可以下单";
        }
        return checkResp;
    }

}
