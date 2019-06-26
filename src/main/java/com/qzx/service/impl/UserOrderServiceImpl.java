package com.qzx.service.impl;

import com.qzx.dao.model.UserOrder;
import com.qzx.dao.repostiory.UserOrderRepostiory;
import com.qzx.service.service.UserOrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserOrderServiceImpl implements UserOrderService {

    private final static Logger logger = LoggerFactory.getLogger(UserOrderServiceImpl.class);

    @Autowired
    private UserOrderRepostiory userOrderRepostiory;

    @Override
    public UserOrder findUserOrder(Long id) {
        return userOrderRepostiory.findById(id).get();
    }

    @Override
    public List<UserOrder> findByTbId(String id) {
        List<UserOrder> userOrders = userOrderRepostiory.findByTbId(id);
        return userOrders;
    }

    @Override
    public List<UserOrder> findByUserId(Long id) {
        List<UserOrder> userOrders = userOrderRepostiory.findByUserId(id);
        return userOrders;
    }

    @Transactional
    @Override
    public void deleteById(Long id) {
        UserOrder userOrder = userOrderRepostiory.findById(id).get();

        List<UserOrder> userOrders = userOrder.getAccount().getUserOrders();
        for (UserOrder userOrder1 : userOrders) {
            if (id.equals(userOrder1.getId())) {
                logger.info("userOrder1.getId() -------------------" + userOrder1.getId());
                userOrders.remove(userOrder1);
            }
        }

        userOrderRepostiory.deleteById(id);
    }

    @Transactional
    @Override
    public void deleteByUserId(Long id) {
        UserOrder userOrder = userOrderRepostiory.findById(id).get();
        userOrder.clearUserOrder();
        ;
        userOrderRepostiory.deleteById(id);
    }


}
