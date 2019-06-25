package com.qzx;

import com.alibaba.fastjson.JSON;
import com.qzx.dao.model.AlimamaOrder;
import com.qzx.service.service.AlimamaOrderService;
import com.qzx.utils.RandomNumbers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AlimamaOrderTests {
    @Autowired
    AlimamaOrderService alimamaOrderService;
    private final static Logger logger = LoggerFactory.getLogger(AlimamaOrderTests.class);
    @Test
    public void findByOrderId(){
        AlimamaOrder alimamaOrder = alimamaOrderService.findByOrderId("167734925762949573");
        logger.info("--------------------" + JSON.toJSONString(alimamaOrder,true));
    }

    @Test
    public void saveAlimamaOrder(){

        String orderId = RandomNumbers.getOrder();

        AlimamaOrder alimamaOrder = new AlimamaOrder(new Date(),new Date(),"运动耳机",525694095950L,"华胜天齐数码专营店","华胜天齐数码专营店",
                1,"88.00","订单付款","天猫","30.01 %","100.00 %","19.9900","6.00",
                "0.00","0.00","30.01 %","0","0.00 %","0","-","无线",
                "--",orderId,
                "影音电器","45368612","趣专享","23950950016","趣专享高佣","953470",new Date(),new Date(),0);

        logger.info("------------------->>" + orderId);
        alimamaOrderService.saveAlimamaOrder(alimamaOrder);
    }
}
