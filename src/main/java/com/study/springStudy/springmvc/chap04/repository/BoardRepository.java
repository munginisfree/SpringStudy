package com.study.springStudy.springmvc.chap04.repository;

import com.study.springStudy.springmvc.chap04.entity.Board;
import org.springframework.stereotype.Repository;

import java.util.List;

//게시판 CRUD
public interface BoardRepository {

    // 게시물 목록조회
    List<Board> findAll();
    // 게시물 상세조회
    Board findOne(int boardNo);
    // 게시물 등록
    boolean save(Board board);
    // 게시물 삭제
    boolean delete(int boardNo);
}
