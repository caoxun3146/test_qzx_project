package com.qzx;

import com.alibaba.fastjson.JSONObject;
import com.qzx.service.service.RedisService;
import com.qzx.utils.RedisUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@RunWith(SpringRunner.class)
@SpringBootTest
public class QzxRedisTests {

    @Autowired
    private RedisUtil redisUtil;

    private final static Logger logger = LoggerFactory.getLogger(QzxRedisTests.class);

    /**
     * 趣专享项目访问 redis
     */
    @Test
    public void getTokenByUserId(){

        logger.info("----------------------------" + redisUtil.get("ActivityBusService:getActivityByOne:11"));

        //String key = "access_token_list:" + 662519;
        String key = "access_token_list:662519";
        Set<Object> setCache = redisUtil.sGet(key);
        logger.info("-----------------------1 " +  setCache);
        Map<String, String> map = new HashMap<String, String>();  // 创建map来存储token集

        String[] strArr;
        long max = 0; // 匹配出最新的token值
        for (Object setStr : setCache) {
            strArr = setStr.toString().split(": ");
            map.put(strArr[1], strArr[0]); // 将token存储到map中
            if (Long.parseLong(strArr[1]) > max) {
                max = Long.parseLong(strArr[1]);
            }
        }
        logger.info("---------------------2" + map.get(max + ""));  // map参数, 必须传字符串类型
    }
}
