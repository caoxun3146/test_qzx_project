package com.qzx.dao.repository;

import com.qzx.dao.model.QuUserRedpack;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface QuUserRedpackRepository extends JpaRepository<QuUserRedpack, Long> {
    List<QuUserRedpack> findByUserId(int userId);

    // 删除数据时, 必须要在service层添加事务
    @Transactional
    void deleteByuserId(int userId);
}
