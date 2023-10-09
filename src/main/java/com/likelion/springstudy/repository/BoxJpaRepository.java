package com.likelion.springstudy.repository;

import com.likelion.springstudy.domain.entity.BoxEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoxJpaRepository extends JpaRepository<BoxEntity, Long> {
}
