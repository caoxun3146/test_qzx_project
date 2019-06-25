package com.qzx.service.service;

import com.qzx.dao.model.UserOrder;

import java.util.List;

public interface UserOrderService {
    UserOrder findUserOrder(Long id);
    List<UserOrder> findByUserId(Long id);
    List<UserOrder> findByTbId(String id);
    void deleteById(Long id);
    void deleteByUserId(Long id);

}
