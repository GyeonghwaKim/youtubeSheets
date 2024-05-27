package com.example.youtubeSheet.repository;

import com.example.youtubeSheet.entity.SiteUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;


@Repository
public interface UserRepository extends JpaRepository<SiteUser, UUID> {


    Optional<SiteUser> findByUsername(String username);
    boolean existsByUsername(String username);
}