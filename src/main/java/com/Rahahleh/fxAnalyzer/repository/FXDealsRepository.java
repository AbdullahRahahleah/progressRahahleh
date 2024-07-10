package com.Rahahleh.fxAnalyzer.repository;

import com.Rahahleh.fxAnalyzer.entity.Deal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface FXDealsRepository extends JpaRepository<Deal, Integer> {

    // Custom query
    @Query(value = "SELECT d FROM Deal d JOIN d.dealDetail dt WHERE dt.dealIdString = :dealStringID")
    List<Optional<Deal>> findDealByDealStringID(@Param("dealStringID") String dealStringID);

}
