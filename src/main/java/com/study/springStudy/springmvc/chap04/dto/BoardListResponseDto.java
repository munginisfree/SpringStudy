package com.study.springStudy.springmvc.chap04.dto;

import com.study.springStudy.springmvc.chap04.entity.Board;
import lombok.Getter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

// 서버에서 조회한 데이터 중 화면에 필요한 데이터만 모아놓은 클래르 (민감한 정보 싹 빼고)
@Getter
public class BoardListResponseDto {
    /*
    {
        shortTitle: ""
    }
     */
    // 필드명은 클라이언트 개발자가 원하는 데로 해야햠 왜냐하면 나중에 위에 같이 들어가기때문에
    private int bno;
    private String shortTitle; // 5글자 이상 줄임 처리된 제목
    private String shortContent; // 30자 이상 줄임 처리된 글 내용
    private String date; // 포맷팅된 날짜 문자열
    private int view; // 조회 수
    private boolean hit; // HIT 게시물인가?
    private boolean newArticle;

    // 엔터티를 DTO로 변환하는 생성자
    public BoardListResponseDto(Board b) {
        this.bno = b.getBoardNo();
        this.shortTitle = makeShortText(b.getTitle(), 5);
        this.shortContent = makeShortText(b.getContent(), 30);
        this.date = dateFormatting(b.getRegDateTime());
        this.view = b.getViewCount();
        this.hit = this.view > 5;
        this.newArticle = LocalDateTime.now().isBefore(b.getRegDateTime().plusHours(1));
    }

    private String makeShortText(String text, int n) {
        return (text.length() > n)? text.substring(0, n)+"..." : text;
    }

//    private String makeShortContent(String content) {
//        return (content.length() > 30)? content.substring(0, 30)+"..." : content;
//    }

    private String dateFormatting(LocalDateTime regDateTime) {
        String pattern = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm").format(regDateTime);
        return pattern;
    }
}
