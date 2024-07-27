package com.Quiz.Quiz.service;

import com.Quiz.Quiz.DAO.QuizQuestionRepository;
import com.Quiz.Quiz.model.QuizQuestion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class QuizQuestionService {

    @Autowired
    private QuizQuestionRepository quizQuestionRepository;

    public QuizQuestion saveQuizQuestion(QuizQuestion quizQuestion) {
        return quizQuestionRepository.save(quizQuestion);
    }

    public List<QuizQuestion> getAllQuizQuestions() {
        return quizQuestionRepository.findAll();
    }

    public Optional<QuizQuestion> getQuizQuestionById(int id) {
        return quizQuestionRepository.findById(id);
    }

    public QuizQuestion getRandomQuizQuestion() {
        List<QuizQuestion> allQuestions = quizQuestionRepository.findAll();
        Random random = new Random();
        return allQuestions.get(random.nextInt(allQuestions.size()));
    }
}
