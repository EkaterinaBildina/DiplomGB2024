package com.diploma.dbpatterns.repository;

import com.diploma.dbpatterns.model.Pattern;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatternRepository extends JpaRepository<Pattern, Long> {
}
