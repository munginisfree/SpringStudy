package com.study.springStudy.springmvc.chap01;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/spring/chap01/*")
public class BasicController {

    //디테일한 요청
    @RequestMapping("/hello")
    public String hello() {
        System.out.println("hello request!!!!");
        return "hello";
    }

    // ======= 요청 파라미터 (Query String) 읽기 ======= //
    // URL에 붙어있거나 from태그에서 전송된 데이터
    @RequestMapping("/person")
    public String person(HttpServletRequest request) {
        System.out.println("person request!!!!");
        String name = request.getParameter("name");
        String age = request.getParameter("age");

        System.out.println("name = " + name);
        System.out.println("age = " + age);
        return "";
    }

    // 2. @RequestParam 사용하기

    @RequestMapping("/major")
    public String major(@RequestParam String stu,
                        @RequestParam("major") String mj,
                        @RequestParam int grade) {
        String major = "null";
        System.out.println("stu = " + stu);
        System.out.println("major = " + mj);
        System.out.println("grade = " + grade);
        return "";
    }

    // 3. 커맨드 객체 (RequestDTO) 사용하기
    // ex) /spring/chap01/order?orderNum=22&goods=구두&amount=3&price=20000...
    @RequestMapping("/order")
    public String order(OrderDto order){
        System.out.println("주문번호 = " + order.getOrderNum());
        System.out.println("주문상품명 = " + order.getGoods());
        System.out.println("주문갯수 = " + order.getAmount());
        System.out.println("주문가격 = " + order.getPrice());
        return "";
    }
}
