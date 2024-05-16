package com.study.springStudy.springmvc.chap02;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/coffee/*")
public class CoffeeController {
    /**
     * @request-uri : /coffee/order
     * @forwarding-jsp : /WEB-INF/views/mvc/coffee-form.jsp
     */
    @RequestMapping("/order")
    public String order() {
        return "mvc/coffee-form";
    }

    @PostMapping("/result")
    public String result(String menu, int price, Model model){

        // 1. 주문한 데이터(menu, price) 읽어오기

        // 2. jsp에 보내서 랜더링
        model.addAttribute("mmm", menu);
        model.addAttribute("ppp", price);

        return "mvc/coffee-result";
    }
}
