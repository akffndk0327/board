package com.example.board;

import com.example.board.Repo.BoardEntityRepository;
import com.example.board.entity.BoardEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Optional;

@org.springframework.web.bind.annotation.RestController
public class RestController {
    @Autowired
    BoardEntityRepository boardRepo;

    //게시판 데이터 저장하기
    @PostMapping("/bbsSave")
    public String bbsSave(@RequestBody BoardEntity board){

        boardRepo.save(board);
        return "ok";
    }

    //게시판 상세보기
    @RequestMapping("/bbsView")
    public ModelAndView bbsView(@RequestParam("index") String index){
        //index값 가져오기 -ok - >
        //2. db 랑 조회 -> 전체 가져옴
         ModelAndView mav = new ModelAndView();
        Optional<BoardEntity> view= boardRepo.findByIndex(Integer.parseInt(index)); // ?
        mav.addObject("view", view);
        mav.setViewName("bbsView");
        return mav;
    }




}