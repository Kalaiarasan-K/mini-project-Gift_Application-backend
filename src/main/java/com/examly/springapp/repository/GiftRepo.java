package com.examly.springapp.repository;

import com.examly.springapp.model.Gift;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GiftRepo extends JpaRepository<Gift, Integer> {}
