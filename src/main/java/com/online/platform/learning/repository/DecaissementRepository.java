package com.online.platform.learning.repository;

import com.online.platform.learning.models.Decaissement;
import com.online.platform.learning.models.Encaissment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DecaissementRepository extends JpaRepository<Decaissement, Integer> {
}
