package com.basic.notadvance.services;
import com.basic.notadvance.entity.Member;
import java.util.List;

public interface MemberService {
    Member addMember(Member member);
    Member getMemberById(Long id);
    List<Member> getAllMembers();
    Member updateMember(Long id, Member member);
    void deleteMember(Long id);
}