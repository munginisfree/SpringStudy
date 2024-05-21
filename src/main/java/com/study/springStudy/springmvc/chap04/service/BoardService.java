package com.study.springStudy.springmvc.chap04.service;

import com.study.springStudy.springmvc.chap04.dto.BoardListResponseDto;
import com.study.springStudy.springmvc.chap04.dto.BoardWriteRequestDto;
import com.study.springStudy.springmvc.chap04.entity.Board;
import com.study.springStudy.springmvc.chap04.mapper.BoardMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardMapper repository;

    // 게시물 목록조회
    // 게시물 상세조회
    public Board findOne(int boardNo){
        return repository.findOne(boardNo);
    }
    // 게시물 등록
    public boolean save(Board board){
        return repository.save(board);
    }
    // 게시물 삭제
    public boolean delete(int boardNo){
        return repository.delete(boardNo);
    }

    // 조회수 상승
    public void upViewCount(int boardNo){
        repository.upViewCount(boardNo);
    }

    public List<BoardListResponseDto> getList() {
        List<Board> boardList = repository.findAll();

        List<BoardListResponseDto> bList = boardList.stream()
                .map(BoardListResponseDto::new)
                .collect(Collectors.toList());
        return bList;
    }

    public void convertEntity(BoardWriteRequestDto dto) {
        Board b = dto.toEntity();
        save(b);
    }
}
