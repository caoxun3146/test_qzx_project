package com.qzx.dao.repostiory;

import com.qzx.dao.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepostiory extends JpaRepository<Account, Long> {
    Account findById(long id);

    Account findByTbId(String tbId);

    Account findByPrdIdAndTbIdAndStatus(String prdId, String tbId, byte status);  // 注意两个以上条件时, 顺序不能弄反 ,否则查询出的结果为空
}