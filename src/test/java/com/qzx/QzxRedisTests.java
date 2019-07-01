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
     * 访问 趣专享项目 redis
     */
    @Test
    public void getTokenByUserId(){
       // IosAudit_1342
        //ActivityBusService:getActivityByOne:11
        logger.info("----------------------------" + redisUtil.get("IosAudit_1342"));

     /*   //String key = "access_token_list:" + 662519;
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
        logger.info("---------------------2" + map.get(max + ""));  // map参数, 必须传字符串类型*/
    }

    /**
     * 访问本地redis服务器
     */
    @Test
    public void redisUtil() {
        //logger.info("----------------------------" + redisUtil.get("redis_obj_test"));

        //  设置set
        redisUtil.sSet("setfirstkey", "service", "component", "repository");
        redisUtil.sSet("setsecondkey", "FCB52388645E554D32F68BBDE00AD86249D6056C4BC372D0D7BF592D93FAA32EA9A423A0F2E901AE96A3C81DE1ED65E1FCEFEA50E4CB287B6C7D86BCF2F558DC: 1558678509429", "FCB52388645E554D32F68BBDE00AD86249D6056C4BC372D0D7BF592D93FAA32E39B0034002F82357D3C79F682E43595BB6CBE8E2B12B1701EE871D981A183E50: 1558767951516", "FCB52388645E554D32F68BBDE00AD86249D6056C4BC372D0D7BF592D93FAA32E70D6F89E5AA645577D3BF956F030F325B019E5D3BB838D743FD3DBCCC9030168: 1559292030587");
        //  获取set
        logger.info("-----------------------------"  + redisUtil.sGet("setfirstkey"));
        logger.info("-----------------------------"  + redisUtil.sGet("setsecondkey"));
        Set<Object> setCache = redisUtil.sGet("setsecondkey");

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
        logger.info("---------------------" + map.get(max + ""));  // map参数, 必须传字符串类型

        //  删除set,  1个或多个 key
        //redisUtil.del("setfirstkey","setsecondkey");

    }
}
