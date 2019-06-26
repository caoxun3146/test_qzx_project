package com.qzx;

import com.alibaba.fastjson.JSON;
import com.qzx.controller.AccountController;
import com.qzx.dao.model.Account;
import com.qzx.dao.model.UserOrder;
import com.qzx.service.service.AccountService;
import com.qzx.service.service.UserOrderService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserOrderTests {

    @Autowired
    private UserOrderService userOrderService;
    @Autowired
    private AccountService accountService;

    private final static Logger logger = LoggerFactory.getLogger(AccountController.class);

    @Test
    public void FindUserOrder() {
        UserOrder userOrder = userOrderService.findUserOrder(2286895L);
        logger.info("----------------------------------- " + JSON.toJSONString(userOrder, true));
    }

    @Test
    public void FindAccountAndUserOrder() {
        Account account = accountService.findById(662454L);
        logger.info("----------------------------------- " + JSON.toJSONString(account, true));
    }

    @Test
    public void FindByUserId() {
        List<UserOrder> userOrders = userOrderService.findByUserId(662454L);
        logger.info("--------------------" + JSON.toJSONString(userOrders, true));
    }

    @Test
    public void DeleteById() {
        userOrderService.deleteById(2286911L);
    }

    @Test
    public void DeleteByUserId() {
        userOrderService.deleteByUserId(2286958L);
    }

}
