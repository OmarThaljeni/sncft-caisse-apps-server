package com.online.platform.learning.repository;

import com.online.platform.learning.models.Transcation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<Transcation, Integer> {
}
