package com.example.myhome.controller;


import com.example.myhome.model.Board;
import com.example.myhome.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/board")
public class BoardController {

    // DI => 서버 기동될 때 인스턴스가 들어온다.
    @Autowired
    private BoardRepository boardRepository;

    @GetMapping("/list")
    public String list(Model model) {
        List<Board> boards = boardRepository.findAll();
        // boards 라는 key값에 boards 라는 데이터를 준다.
        // 모델에 담긴 데이터를 thymeleaf를 통해서 사용할 수 있다.
        model.addAttribute("boards", boards);
        return "board/list";
    }
}
