package com.study.springStudy.springmvc.chap01;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ResponseController {
    //jsp파일로 포워딩할 때 데이터 전달하기
    // 1. Model 객체 사용하기
    @RequestMapping("/hobbies")
    public String hobbies(Model model) {
        model.addAttribute("name", "김철수");
        model.addAttribute("hobbies", List.of("football", "swimming","watchMovies"));
        model.addAttribute("major", "business");

        return "mvc/hobbies";
    }

    // 2. ModelAndView 객체 사용하기
    @RequestMapping("/hobbies2")
    public ModelAndView hobbies2() {
        ModelAndView mv = new ModelAndView("mvc/hobbies");
        mv.addObject("name", "Christine");
        mv.addObject("hobbies", List.of("drawing", "Reading"));
        mv.addObject("major", "Social");
        return mv;
    }
}
