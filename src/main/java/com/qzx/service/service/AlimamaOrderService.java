package com.qzx.service.service;

import com.qzx.dao.model.AlimamaOrder;

// AlimamaOrderRepostiory
public interface AlimamaOrderService {
    AlimamaOrder findByOrderId(String id);

    AlimamaOrder findById(long id);

    void saveAlimamaOrder(AlimamaOrder alimamaOrder);
}
