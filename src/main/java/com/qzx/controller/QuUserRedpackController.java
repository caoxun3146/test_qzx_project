package com.qzx.controller;

import com.qzx.dao.model.QuUserRedpack;
import com.qzx.dao.model.Result;
import com.qzx.dao.repostiory.QuUserRedpackRepostiory;
import com.qzx.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 删除营销红包
 */
@RestController
public class QuUserRedpackController {
    @Autowired
    private QuUserRedpackRepostiory quUserRedpackRepostiory;

    private final static Logger logger = LoggerFactory.getLogger(QuUserRedpackController.class);

    @GetMapping(value = "/quredpack/{userId}")
    public Result DeleteQuRedpack(@PathVariable("userId") int userId) {

        List<QuUserRedpack> quUserRedpack = quUserRedpackRepostiory.findByUserId(userId);
        logger.info("-----------" + quUserRedpack);
        if (quUserRedpack.isEmpty() || "".equals(quUserRedpack)) {  // quUserRedpack == null || "".equals(quUserRedpack)
            return ResultUtil.error(1, "无可删数据");
        } else {
            quUserRedpackRepostiory.deleteByuserId(userId);
            //JSON.toJSONString(ResultUtil.success(print),true);
            return ResultUtil.success(quUserRedpack);
        }

    }

    @GetMapping(value = "/findquredpack/{userId}")
    public Result FindQuRedpackByUserId(@PathVariable("userId") int userId) {

        List<QuUserRedpack> quUserRedpack = quUserRedpackRepostiory.findByUserId(userId);
        logger.info("-----------" + quUserRedpack);
        if (quUserRedpack.isEmpty() || "".equals(quUserRedpack)) {  // quUserRedpack == null || "".equals(quUserRedpack)
            return ResultUtil.error(1, "该账号无营销红包数据");
        } else {
            return ResultUtil.success(quUserRedpack);
        }

    }
}
