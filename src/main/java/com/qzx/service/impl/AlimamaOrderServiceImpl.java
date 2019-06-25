package com.qzx.service.impl;

import com.qzx.dao.model.AlimamaOrder;
import com.qzx.dao.repostiory.AlimamaOrderRepostiory;
import com.qzx.service.service.AlimamaOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlimamaOrderServiceImpl implements AlimamaOrderService {

    @Autowired
    AlimamaOrderRepostiory alimamaOrderRepostiory;

    @Override
    public AlimamaOrder findByOrderId(String id) {
        AlimamaOrder alimamaOrder = alimamaOrderRepostiory.findByOrderId(id);
        return alimamaOrder;
    }

    @Override
    public AlimamaOrder findById(long id) {
        AlimamaOrder alimamaOrder = alimamaOrderRepostiory.findById(id);
        return alimamaOrder;
    }

    @Override
    public void saveAlimamaOrder(AlimamaOrder alimamaOrder) {
        alimamaOrderRepostiory.save(alimamaOrder);
    }


}
