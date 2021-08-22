package com.hunmo.examplespring.repository;

import com.hunmo.examplespring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {

    Member save(Member member);
    //optional 가져올 떄 null 일 수 있는 이를 처리하기 위한 것
    Optional<Member> findById(Long id);
    Optional<Member> findByName(String name);
    List<Member> findAll();

}
