package com.qzx;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class Redis2 {
    @Qualifier("stringRedisTemplate")
    @Autowired
    StringRedisTemplate stringRedisTemplate;

    private final static Logger logger = LoggerFactory.getLogger(Redis2.class);
    @Test
    public void test()  {

        // 保存字符串
        logger.info("-----------------------------------" + stringRedisTemplate.opsForValue().get("ActivityBusService:getActivityByOne:11"));
        logger.info("===================================" + stringRedisTemplate.opsForValue().get("redis_obj_test"));

    }
}
