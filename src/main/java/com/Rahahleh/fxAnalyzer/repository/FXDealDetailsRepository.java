package com.Rahahleh.fxAnalyzer.repository;

import com.Rahahleh.fxAnalyzer.entity.Deal;
import com.Rahahleh.fxAnalyzer.entity.DealDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FXDealDetailsRepository extends JpaRepository<DealDetail, Integer> {
}
