package com.qzx.dao.repostiory;

import com.qzx.dao.model.AlimamaOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlimamaOrderRepostiory extends JpaRepository<AlimamaOrder, Long> {
    AlimamaOrder findById(long id);

    AlimamaOrder findByOrderId(String id);
}
