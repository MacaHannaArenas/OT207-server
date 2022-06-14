package com.alkemy.ong.service;
import com.alkemy.ong.dto.MemberDto;
import org.springframework.transaction.annotation.Transactional;

public interface IMemberService {

    @Transactional
    MemberDto addMember(MemberDto memberDto);

    void deleteById(Long id);
}
