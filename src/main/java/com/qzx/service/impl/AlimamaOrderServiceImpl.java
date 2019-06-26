package com.qzx.service.impl;

import com.qzx.dao.model.AlimamaOrder;
import com.qzx.dao.repository.AlimamaOrderRepository;
import com.qzx.service.service.AlimamaOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlimamaOrderServiceImpl implements AlimamaOrderService {

    @Autowired
    AlimamaOrderRepository alimamaOrderRepository;

    @Override
    public AlimamaOrder findByOrderId(String id) {
        AlimamaOrder alimamaOrder = alimamaOrderRepository.findByOrderId(id);
        return alimamaOrder;
    }

    @Override
    public AlimamaOrder findById(long id) {
        AlimamaOrder alimamaOrder = alimamaOrderRepository.findById(id);
        return alimamaOrder;
    }

    @Override
    public void saveAlimamaOrder(AlimamaOrder alimamaOrder) {
        alimamaOrderRepository.save(alimamaOrder);
    }


}
