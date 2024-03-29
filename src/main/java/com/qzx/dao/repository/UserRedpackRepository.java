package com.qzx.dao.repository;

import com.qzx.dao.model.UserRedpack;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

public interface UserRedpackRepository extends JpaRepository<UserRedpack, Long> {
    UserRedpack findByPhoneId(String PhoneId);

    // 删除数据时, 必须要在service层添加事务
    @Transactional
    void deleteByPhoneId(String PhoneId);
}
