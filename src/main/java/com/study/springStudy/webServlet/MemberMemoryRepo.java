package com.study.springStudy.webServlet;

import com.study.springStudy.webServlet.entity.Member;

import java.util.*;
import java.util.stream.Collectors;

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

    // 멤버 삭제 기능
    public void delete(String accont){
        List<Member> members = memberList.stream()
                .filter(member -> member.getAccount().equals(accont))
                .collect(Collectors.toList());
        if(members.size() > 0){
            memberList.remove(members.get(0));
        }
    }

    // 멤버 단일 조회 가능
    public Member findOne(String accont){
        return memberList.stream()
                .filter(member -> member.getAccount().equals(accont))
                .collect(Collectors.toList())
                .get(0);
    }
}
