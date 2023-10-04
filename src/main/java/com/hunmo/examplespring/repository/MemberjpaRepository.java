package com.hunmo.examplespring.repository;

import com.hunmo.examplespring.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberjpaRepository extends JpaRepository<Member, Long> {

    Optional<Member> findByName(String name);
}
