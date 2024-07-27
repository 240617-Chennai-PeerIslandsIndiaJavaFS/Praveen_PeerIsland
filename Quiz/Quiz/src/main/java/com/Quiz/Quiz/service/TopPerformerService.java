package com.Quiz.Quiz.service;

import com.Quiz.Quiz.DAO.TopPerformerRepository;
import com.Quiz.Quiz.model.TopPerformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TopPerformerService {

    @Autowired
    private TopPerformerRepository topPerformerRepository;

    public List<TopPerformer> getTopPerformers() {
        return topPerformerRepository.findTop3ByOrderByScoreDesc();
    }

    public TopPerformer saveTopPerformer(TopPerformer topPerformer) {
        return topPerformerRepository.save(topPerformer);
    }

    public void deleteTopPerformerById(int id) {
        topPerformerRepository.deleteById(id);
    }

    public void updateTopPerformers(TopPerformer newScore) {
        List<TopPerformer> currentTopPerformers = getTopPerformers();
        if (currentTopPerformers.size() < 3) {
            saveTopPerformer(newScore);
        } else if (newScore.getScore() > currentTopPerformers.get(2).getScore()) {
            saveTopPerformer(newScore);
            deleteTopPerformerById(currentTopPerformers.get(2).getId());
        }
    }
}