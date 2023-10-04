package com.hunmo.examplespring;

import com.hunmo.examplespring.aop.TimeTraceAop;
import com.hunmo.examplespring.repository.MemberRepository;
import com.hunmo.examplespring.repository.MemoryMemberRepository;
import com.hunmo.examplespring.repository.jdbcTemplateMemberRepository;
import com.hunmo.examplespring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {

    private DataSource dataSource;

    @Autowired
    public SpringConfig(DataSource dataSource){
        this.dataSource = dataSource;
    }

    @Bean
    public TimeTraceAop timeTraceAop() { return new TimeTraceAop();}

    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository(){

        //return new MemoryMemberRepository();
        return new jdbcTemplateMemberRepository(dataSource);
    }
}
