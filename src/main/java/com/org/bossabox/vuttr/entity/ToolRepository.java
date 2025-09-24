package com.org.bossabox.vuttr.entity;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ToolRepository extends JpaRepository<Tool, Integer> {
  boolean existsByTitle(String title);
}
