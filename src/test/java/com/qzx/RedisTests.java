package com.qzx;

import com.alibaba.fastjson.JSONObject;
import com.qzx.dao.model.Person;
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

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTests {
    @Autowired
    RedisService redisService;

    @Autowired
    private RedisTemplate<String, ?> redisTemplate;

    @Autowired
    private RedisUtil redisUtil;

    private final static Logger logger = LoggerFactory.getLogger(RedisTests.class);

    private JSONObject json = new JSONObject();

    /**
     * 插入字符串
     */
    @Test
    public void setString() {
        redisService.set("redis_string_test", "springboot redis test");
        logger.info("----------------------------" + redisService.expire("redis_string_test", 20));
    }

    /**
     * 获取字符串
     */
    @Test
    public void getString() {
        String result = redisService.get("redis_string_test");
        logger.info("----------------------" + result);
    }

    /**
     * 插入对象
     */
    @Test
    public void setObject() {
        Person person = new Person("person", "male");
        redisService.set("redis_obj_test", json.toJSONString(person));
    }

    /**
     * 获取对象
     */
    @Test
    public void getObject() {
        String result = redisService.get("redis_obj_test");
        Person person = json.parseObject(result, Person.class);
        System.out.println(json.toJSONString(person));
    }

    /**
     * 插入对象List
     */
    @Test
    public void setList() {
        Person person1 = new Person("person1", "male");
        Person person2 = new Person("person2", "female");
        Person person3 = new Person("person3", "male");
        List<Person> list = new ArrayList<>();
        list.add(person1);
        list.add(person2);
        list.add(person3);
        redisService.set("redis_list_test", json.toJSONString(list));
    }

    /**
     * 获取list
     */
    @Test
    public void getList() {
        String result = redisService.get("redis_list_test");
        List<String> list = json.parseArray(result, String.class);
        logger.info("---------------->> " + list);
    }

    /**
     * 获取set
     */
    @Test
    public void getSet() {
        redisService.set("redis_string_test", "springboot redis test");
        logger.info("---------------->>1 " + redisTemplate.opsForValue().get("redis_string_test"));
        logger.info("---------------->>2 " + redisTemplate.expire("redis_string_test", 20, TimeUnit.SECONDS));

        //redisTemplate.opsForSet().members(key);
        logger.info("---------------->>3 " + redisTemplate.opsForSet().members("test-set"));
        Set<String> setCache = (Set<String>) redisTemplate.opsForSet().members("test-set");
        logger.info("---------------->>4 " + setCache.size());
        for (String str : setCache) {
            logger.info("---------------->>5 " + str);
        }

        String key = "redis_list_test";
        logger.info("---------------->>6" + redisTemplate.opsForValue().get(key));
    }

    @Test
    public void remove() {
        redisService.remove("redis_list_test");
    }

    @Test
    public void expire() {
        logger.info("---------------------------->> " + redisService.expire("redis_string_test", 120));
    }

    /**
     * redis 工具类测试
     */
    @Test
    public void redisUtil() {
        //logger.info("----------------------------" + redisUtil.get("redis_obj_test"));

        redisUtil.sSet("setkey", "service", "component", "repository");
    }

}
