package com.study.springStudy.webServlet.chap02.v4.controller;

import com.study.springStudy.webServlet.OurModel;

import java.util.Map;

public class JoinController implements ControllerV4{
    @Override
    public String process(Map<String, String> paramMap, OurModel model) {
        return "v4/reg_form";
    }
}
