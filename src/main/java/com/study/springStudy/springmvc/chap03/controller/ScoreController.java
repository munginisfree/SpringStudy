package com.study.springStudy.springmvc.chap03.controller;

import com.study.springStudy.springmvc.chap03.dto.ScoreDetailResponseDto;
import com.study.springStudy.springmvc.chap03.dto.ScoreListResponseDto;
import com.study.springStudy.springmvc.chap03.dto.ScoreModifyRequestDto;
import com.study.springStudy.springmvc.chap03.dto.ScorePostDto;
import com.study.springStudy.springmvc.chap03.entity.Score;
import com.study.springStudy.springmvc.chap03.repository.ScoreJdbcRepository;
import com.study.springStudy.springmvc.chap03.repository.ScoreRepository;
import com.study.springStudy.springmvc.chap03.service.ScoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.stream.Collectors;

/*
    # 요청 URL
    1. 학생 성적정보 등록화면을 보여주고 및 성적정보 목록조회 처리
    - /score/list : GET

    2. 성적 정보 등록 처리 요청
    - /score/register : POST

    3. 성적정보 삭제 요청
    - /score/remove : GET 원래는 삭제는 절대절대 get쓰면 안됨 주소창으로 바로 접근 가능하기 때문에

    4. 성적정보 상세 조회 요청
    - /score/detail : GET
 */
@Component
@Controller
@RequestMapping("/score")
@RequiredArgsConstructor
public class ScoreController {

    //의존객체 설정
    //ScoreJdbc 대신 그냥 ScoreRepository로 만들어서 DIP를 위반하지 않도록 함
    private final ScoreService service;

//    public ScoreController(ScoreRepository repository) {
//        this.repository = repository;
//    }

    @GetMapping("/list")
    public String list(@RequestParam(defaultValue = "num") String sort, Model model) {
        System.out.println("/score/list: GET!!");
//        List<Score> scoreList = repository.findAll(sort);

//        List<ScoreListResponseDto> dtos = scoreList.stream()
//                .map(ScoreListResponseDto::new)
//                .collect(Collectors.toList());
        List<ScoreListResponseDto> dtos = service.getList(sort);
        model.addAttribute("sList", dtos);

        return "score/score-list";
    }

    @PostMapping("/register")
    public String register(ScorePostDto dto) {
        System.out.println("/score/register: POST!!");
        System.out.println("dto = " + dto);

        // 데이터베이스에 저장
//        Score score = new Score(dto);
//        repository.save(score);
        service.insert(dto);
        return "redirect:/score/list";
    }

    @GetMapping("/remove")
    public String remove(@RequestParam("sn") long stuNum) {
        System.out.println("/score/remove: POST!!");

        // 1. 지우기 원하는 학번 읽기

        // 2. DB에 지우기 요청
//        repository.delete(stuNum);
        service.deleteScore(stuNum);
        return "redirect:/score/list";
    }

    @GetMapping("/detail")
    public String detail(long stuNum, Model model) {
//        System.out.println("/score/detail: GET!!");
        // 1. 상세조회를 원하는 학번을 읽기

        // 2. DB에 상세조회 요청
        ScoreDetailResponseDto dto = service.retrieve(stuNum);
        model.addAttribute("s", dto);
        return "/score/score-detail";
    }

    // 수정화면 열기 요청
    @GetMapping("/modify")
    public String modify(long stuNum, Model model) {
        ScoreDetailResponseDto dto = service.retrieve(stuNum);
        model.addAttribute("s", dto);
        return "score/score-modify";
    }

    // 수정 데이터 반영 요청
    @PostMapping("/modify")
    public String modify(ScoreModifyRequestDto dto) {
        // 1. 수정을 원하는 새로운 데이터 읽기 (국영수점수 + 학번)
        System.out.println("dto = " + dto);
        // 2. 서비스에게 수정 위임
        service.update(dto);

        return "redirect:/score/detail?stuNum=" + dto.getStuNum(); // 상세조회로 리다이렉트
    }

}
