package com.qzx.dao.repostiory;

import com.qzx.dao.model.UserOrder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserOrderRepostiory extends JpaRepository<UserOrder, Long> {
    List<UserOrder> findByUserId(Long id);

    List<UserOrder> findByTbId(String id);

    void deleteById(Long id);

    void deleteByUserId(Long id);

}
