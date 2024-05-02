package com.online.platform.learning.repository;

import java.util.List;
import java.util.Optional;

import com.online.platform.learning.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.online.platform.learning.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
  Optional<User> findByEmail(String email);
  Optional<User> findByUsername(String username);
  List<User> findAllByRoles(Role role);
  List<User> findAllByRolesNot(Role role);
  List<User> findProfileByEmail(String email);
  Boolean existsByUsername(String username);
  Boolean existsByEmail(String email);

}
