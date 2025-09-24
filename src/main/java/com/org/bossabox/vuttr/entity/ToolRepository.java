package com.org.bossabox.vuttr.entity;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ToolRepository extends JpaRepository<Tool, Integer> {
  boolean existsByTitle(String title);
  Iterable<Tool> findToolsByTagsContainingIgnoreCase(String queryString);
}
