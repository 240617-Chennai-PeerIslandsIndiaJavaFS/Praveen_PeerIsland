package com.Quiz.Quiz.DAO;

import com.Quiz.Quiz.model.UserScore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserScoreRepository extends JpaRepository<UserScore, Integer> {
    List<UserScore> findTop3ByOrderByScoreDesc();
}
