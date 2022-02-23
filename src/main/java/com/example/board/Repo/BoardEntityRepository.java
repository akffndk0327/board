package com.example.board.Repo;

import com.example.board.entity.BoardEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface BoardEntityRepository extends JpaRepository<BoardEntity, String> {

}