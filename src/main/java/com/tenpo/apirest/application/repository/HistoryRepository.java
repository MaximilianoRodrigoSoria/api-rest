package com.tenpo.apirest.application.repository;

import com.tenpo.apirest.infrastructure.entity.HistoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HistoryRepository extends JpaRepository<HistoryEntity, Integer> {
}
