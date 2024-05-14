package com.study.springStudy.webServlet;

import com.study.springStudy.webServlet.entity.Member;

import java.util.*;

public class MemberMemoryRepo {

    private MemberMemoryRepo() {
    }
    private static MemberMemoryRepo repo = new MemberMemoryRepo();

    public static MemberMemoryRepo getInstance() {
        return repo;
    }


    // field
    private List<Member> memberList = new ArrayList<>();

    // 멤버 저장 기능
    public void save(Member member) {
        memberList.add(member);
//        System.out.println("memberList = " + memberList);
    }

    // 멤버 전체 조회 가능
    public List<Member> findAll() {
        return memberList;
    }
}
