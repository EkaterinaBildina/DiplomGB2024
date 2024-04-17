package com.diploma.dbpatterns.repository;

import com.diploma.dbpatterns.model.PatternSew;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatternRepository extends JpaRepository<PatternSew, Long> {
}
