package com.qzx.dao.repository;

import com.qzx.dao.model.Settlement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SettlementRepostiory extends JpaRepository<Settlement, Long> {
    Settlement findById(long id);

    Settlement findByOrderId(String orderId);
}
