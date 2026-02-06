package com.devmarzia.PuppyFriendBackend.repository;
// serve per assegnare i ruoli ADMIN, VOLUNTEER

import com.devmarzia.PuppyFriendBackend.entity.Role;
import com.devmarzia.PuppyFriendBackend.entity.Role.RoleType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByRoleType(RoleType roleType);
}