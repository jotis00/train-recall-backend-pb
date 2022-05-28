package com.jo.trainrecallbackend.repositories;

import com.jo.trainrecallbackend.models.Test;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TestRepository extends JpaRepository<Test, Long> {
    List<Test> findByUserId(Long userId);
}
