package com.qzx.dao.repository;

import com.qzx.dao.model.AlimamaOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlimamaOrderRepository extends JpaRepository<AlimamaOrder, Long> {
    AlimamaOrder findById(long id);

    AlimamaOrder findByOrderId(String id);
}
