package com.study.springStudy.springmvc.chap04.controller;

import com.study.springStudy.springmvc.chap04.dto.BoardListResponseDto;
import com.study.springStudy.springmvc.chap04.dto.BoardWriteRequestDto;
import com.study.springStudy.springmvc.chap04.entity.Board;
import com.study.springStudy.springmvc.chap04.repository.BoardRepository;
import com.study.springStudy.webServlet.OurModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.swing.text.html.parser.Entity;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
@Controller
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {

    private final BoardRepository repository;
    // 1. 목록조회 요청 (/board/list:GET)
    @GetMapping("/list")
    public String list(Model model){
        System.out.println("/board/list GET");

        // 1. 데이터 베이스로부터 게시글 목록 조회
        List<Board> boardList = repository.findAll();

        // 2. 클라이언트에 데이터를 보내기 전에 렌드링에 필요한
        //    데이터만 추출하기
        List<BoardListResponseDto> bList = boardList.stream()
                .map(BoardListResponseDto::new)
                        .collect(Collectors.toList());
        // 3. JSP파일에 해당 목록 데이터를 보냄
        model.addAttribute("bList", bList);
        return "board/list";
    }


    // 2. 글쓰기 양식 화면 열기 요청 (/board/write:GET)
    @GetMapping("/write")
    public String write(Board board, Model model){
        return "board/write";
    }
    // 3. 게시글 등록요청 (/board/write/ :POST)
    // -> 목록조회 요청 리다이렉션
    @PostMapping("/write")
    public String write(BoardWriteRequestDto dto){
        // 1. 브라우저가 전달한 게시글 내용 읽기
        System.out.println("dto = " + dto);

        // 2. 해당 게시글을 데이터베이스에 저장하기 위해 엔터티 클래스로 변환
        Board b = dto.toEntity();
        repository.save(b);
        // 3. 데이터베이스 저장 명령
        return "board/write";
    }

    // 4. 게시글 삭제요청 (/board/delete/ :GET)
    // -> 목록조회 요청 리다이렉션
    @GetMapping
    public String delete(int boardNo){
        return "redirect:/board/list";
    }

    // 5. 게시글 상세조회 요청 (/board/detail/ :GET)
    // -> 목록조회 요청 리다이렉션
//    @GetMapping
//    public String detail(int boardNo){
//        return "board/detail";
//    }
}
