package com.hunmo.examplespring;

import com.hunmo.examplespring.repository.MemberRepository;
import com.hunmo.examplespring.repository.MemoryMemberRepository;
import com.hunmo.examplespring.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }
}
