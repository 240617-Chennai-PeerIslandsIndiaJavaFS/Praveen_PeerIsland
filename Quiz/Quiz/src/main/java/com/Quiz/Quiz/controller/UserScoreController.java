package com.Quiz.Quiz.controller;


import com.Quiz.Quiz.model.UserScore;
import com.Quiz.Quiz.service.UserScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/score")
public class UserScoreController {

    @Autowired
    private UserScoreService userScoreService;

    @PostMapping("/submit")
    public UserScore submitScore(@RequestBody UserScore userScore) {
        return userScoreService.saveUserScore(userScore);
    }
}
