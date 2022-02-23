package com.example.board;

import com.example.board.Repo.BoardEntityRepository;
import com.example.board.entity.BoardEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
@Controller
public class MainController {
    @Autowired
    BoardEntityRepository boardRepo;

    @RequestMapping("/bbs")
    public ModelAndView bbs(ModelAndView mav){
        mav.setViewName("/boardwrite");

        return mav ;
    }

    @RequestMapping("/")
    public ModelAndView main(ModelAndView mav){
        mav.addObject("boardRepo", boardRepo.findAll());
        mav.setViewName("/index");
        return mav ;
    }
}