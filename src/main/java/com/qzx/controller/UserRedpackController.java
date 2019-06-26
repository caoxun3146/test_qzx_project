package com.qzx.controller;

import com.qzx.dao.model.UserRedpack;
import com.qzx.dao.repostiory.UserRedpackRepostiory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * 删除首页瀑布流 1-3元新人红包的领取记录
 */
@RestController
public class UserRedpackController {
    @Autowired
    private UserRedpackRepostiory userRedpackRepostiory;

    @GetMapping(value = "/redpack/{phoneId}")
    public String findAccessToken(@PathVariable("phoneId") String phoneId) {

        UserRedpack userRedpack = userRedpackRepostiory.findByPhoneId(phoneId);
        if (userRedpack == null || "".equals(userRedpack)) {
            return "数据不存在";
        }
        userRedpackRepostiory.deleteByPhoneId(phoneId);

        return "清除成功";
    }
}
