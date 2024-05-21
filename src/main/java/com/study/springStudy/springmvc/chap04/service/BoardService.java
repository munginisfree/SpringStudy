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

    public Board update(int boardNo){
        Board b = findOne(boardNo);

        if(b != null){
            upViewCount(boardNo);
        }
        return b;
    }

    public List<BoardListResponseDto> getList() {
        List<Board> boardList = repository.findAll();

        // 조회해온 게시물 리스트에서 각 게시물들의 조회수를 확인하여 조회수가 5 이상인 게시물에 특정 마킹

        List<BoardListResponseDto> dtoList = boardList.stream()
                .map(BoardListResponseDto::new)
                .collect(Collectors.toList());
        return dtoList;
    }

    public void convertEntity(BoardWriteRequestDto dto) {
        Board b = dto.toEntity();
        save(b);
    }
}
