package com.diploma.dbtextile.repository;

import com.diploma.dbtextile.model.Textile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TextileRepository extends JpaRepository<Textile, Long> {
}
