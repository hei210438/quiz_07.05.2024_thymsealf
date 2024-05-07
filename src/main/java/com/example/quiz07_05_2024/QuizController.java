package com.example.quiz07_05_2024;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/quiz")
public class QuizController {

    private QuizRepository repo;

    private int id = 1;
    private int score = 0;
    private int questions;
    private QQuestions q;

    public QuizController(QuizRepository repo) {

        this.repo = repo;
        this.questions = repo.findAll().size();
    }


    @GetMapping("/main")
    public String test(Model model) {
        q = repo.findById(id).get();
        model.addAttribute("question", q);
        return "quiz_main";
    }


    @GetMapping("/endpage")
    public String endpage(Model model) {
        model.addAttribute("score",score);
        return "endpage";
    }
    @PostMapping("/reset")
    public String reset() {
        score = 0;
        id = 1;
        return "redirect:/quiz/main";
    }

    @PostMapping("/next")
    public String next(String answer) {
        AAnswers a = q.getaAnswersByQId().stream().filter(x -> x.getAcorrect()).findFirst().get();
        if (a.getaText().equals(answer)) {
            score++;
        }
        id++;
        if (id > questions) {
            return "redirect:/quiz/endpage";
        }
        return "redirect:/quiz/main";
    }


}

