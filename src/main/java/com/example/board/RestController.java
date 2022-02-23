package com.example.board;

import com.example.board.Repo.BoardEntityRepository;
import com.example.board.entity.BoardEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.sql.Timestamp;
import java.time.LocalDateTime;

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


}