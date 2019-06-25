package com.qzx.controller;

import com.alibaba.fastjson.JSON;
import com.qzx.dao.model.AlimamaOrder;
import com.qzx.dao.model.Result;
import com.qzx.service.service.AlimamaOrderService;
import com.qzx.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AlimamaOrderController {
    @Autowired
    AlimamaOrderService alimamaOrderService;

    private final static Logger logger = LoggerFactory.getLogger(AlimamaOrderController.class);

    @RequestMapping("/alimama/{orderId}")
    @ResponseBody
    public Result getUserOrderByUserId(@PathVariable("orderId") String orderId ) {
        AlimamaOrder alimamaOrder = alimamaOrderService.findByOrderId(orderId);
        logger.info("------------------>" + JSON.toJSONString(alimamaOrder,true));
        return ResultUtil.success(alimamaOrder);
    }
}
