package com.study.springStudy.springmvc.chap04.mapper;

import com.study.springStudy.springmvc.chap04.entity.Board;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {
    // 게시물 목록조회
    List<Board> findAll();
    // 게시물 상세조회
    Board findOne(int boardNo);
    // 게시물 등록
    boolean save(Board board);
    // 게시물 삭제
    boolean delete(int boardNo);

    // 조회수 상승
    void upViewCount(int boardNo);
}
