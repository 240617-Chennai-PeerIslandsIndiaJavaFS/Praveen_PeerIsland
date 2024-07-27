package com.Quiz.Quiz.controller;

import com.Quiz.Quiz.model.QuizQuestion;
import com.Quiz.Quiz.service.QuizQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/quiz/questions")
public class QuizQuestionController {

    @Autowired
    private QuizQuestionService quizQuestionService;

    @PostMapping
    public QuizQuestion createQuizQuestion(@RequestBody QuizQuestion quizQuestion) {
        return quizQuestionService.saveQuizQuestion(quizQuestion);
    }

    @GetMapping
    public List<QuizQuestion> getAllQuizQuestions() {
        return quizQuestionService.getAllQuizQuestions();
    }

    @GetMapping("/{id}")
    public Optional<QuizQuestion> getQuizQuestionById(@PathVariable int id) {
        return quizQuestionService.getQuizQuestionById(id);
    }

    @GetMapping("/random")
    public QuizQuestion getRandomQuizQuestion() {
        return quizQuestionService.getRandomQuizQuestion();
    }

    @PostMapping("/{id}/submit")
    public boolean submitAnswer(@PathVariable int id, @RequestParam String answer) {
        Optional<QuizQuestion> quizQuestion = quizQuestionService.getQuizQuestionById(id);
        return quizQuestion.isPresent() && quizQuestion.get().getCorrectanswer().equalsIgnoreCase(answer);
    }
}