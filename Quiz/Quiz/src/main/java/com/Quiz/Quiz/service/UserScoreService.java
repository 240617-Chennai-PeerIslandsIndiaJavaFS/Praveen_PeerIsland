package com.Quiz.Quiz.service;

import com.Quiz.Quiz.DAO.UserScoreRepository;
import com.Quiz.Quiz.model.TopPerformer;
import com.Quiz.Quiz.model.UserScore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserScoreService {

    @Autowired
    private UserScoreRepository userScoreRepository;

    @Autowired
    private TopPerformerService topPerformerService;

    public UserScore saveUserScore(UserScore userScore) {
        UserScore savedScore = userScoreRepository.save(userScore);
        TopPerformer topPerformer = new TopPerformer();
        topPerformer.setUser(userScore.getUser());
        topPerformer.setScore(userScore.getScore());
        topPerformerService.updateTopPerformers(topPerformer);
        return savedScore;
    }

    public List<UserScore> getTopPerformers() {
        return userScoreRepository.findTop3ByOrderByScoreDesc();
    }
}
