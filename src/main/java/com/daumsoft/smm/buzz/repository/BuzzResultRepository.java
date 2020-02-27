package com.daumsoft.smm.buzz.repository;

import java.util.List;

import com.daumsoft.smm.buzz.entity.BuzzResult;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BuzzResultRepository extends JpaRepository <BuzzResult, String> {

  List<BuzzResult> findSumByPeriod (@Param("startDate") String startDate, @Param("endDate") String endDate);

}