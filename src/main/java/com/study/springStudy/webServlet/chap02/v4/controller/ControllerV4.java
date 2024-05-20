package com.study.springStudy.webServlet.chap02.v4.controller;

import com.study.springStudy.webServlet.OurModel;

import java.util.Map;

/*
    이 인터페이스를 구현하는 다양한 하위 객체들이
    요청정보나 응답정보를 모두가 사용하는 것이 아니기 때문에
    요청, 응답 정보 처리를 외부로 위임
 */

public interface ControllerV4 {
    /*
     * 요청이 들어오면 적절한 처리를 수행
     * @param1 paramMap : 요청 정보(Query Parameter)를 모두 읽어서 맵에 담음
     * @param2 model : 응답시 보여줄 JSP에 보낼 데이터를 담는 수송객체
     *
     * @return - 응답시 포워딩하거나 리다이렉트 할 경로 문자열
     */
    String process(Map<String, String> paramMap, OurModel model);
}
