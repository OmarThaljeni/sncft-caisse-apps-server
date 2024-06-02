package com.online.platform.learning.repository;

import com.online.platform.learning.models.Encaissment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EncaissmentRepository extends JpaRepository<Encaissment, Integer> {
    List<Encaissment> findAllByEmailUser(String emailUser);
}
