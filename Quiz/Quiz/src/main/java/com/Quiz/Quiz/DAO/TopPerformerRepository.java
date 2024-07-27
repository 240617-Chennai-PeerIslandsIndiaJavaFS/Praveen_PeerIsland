package com.Quiz.Quiz.DAO;

import com.Quiz.Quiz.model.TopPerformer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TopPerformerRepository extends JpaRepository<TopPerformer, Integer> {
    List<TopPerformer> findTop3ByOrderByScoreDesc();
}
