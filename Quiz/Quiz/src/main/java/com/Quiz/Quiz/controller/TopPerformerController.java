package com.Quiz.Quiz.controller;

import com.Quiz.Quiz.model.TopPerformer;
import com.Quiz.Quiz.service.TopPerformerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/top-performers")
public class TopPerformerController {

    @Autowired
    private TopPerformerService topPerformerService;

    @GetMapping
    public List<TopPerformer> getTopPerformers() {
        return topPerformerService.getTopPerformers();
    }
}
