package com.study.springStudy.webServlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// JSP파일을 포워딩하는 역할
public class View {
    private String viewName;
    private String prefix; // 경로에 있는 공통 접두사
    private String suffix; // 경로에 있는 공통 접미사
    private boolean redirect;

    public View(String viewName) {
        this.prefix = "/WEB-INF/views/";
        this.suffix = ".jsp";

        if (!isRedirect(viewName)) {
            this.viewName = prefix + viewName + suffix;
        }else{
            this.viewName = viewName.substring(viewName.indexOf(":")+1);
        }
    }

    // 포워딩 or redirect 기능
    public void render(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(!this.redirect) {
            RequestDispatcher dp = request.getRequestDispatcher(viewName);
            dp.forward(request,response);
        }else{
            response.sendRedirect(viewName);
        }
    }
    //리다이렉트인지 확인
    private boolean isRedirect(String viewName){
        this.redirect = viewName.startsWith("redirect:");
        return this.redirect;
    }

}
