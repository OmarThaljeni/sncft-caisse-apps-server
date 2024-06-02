package com.online.platform.learning.repository;

import com.online.platform.learning.models.Decaissement;
import com.online.platform.learning.models.Encaissment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DecaissementRepository extends JpaRepository<Decaissement, Integer> {
    List<Decaissement> findAllByEmailUser(String emailUser);
}
