package com.basic.notadvance.services;


import com.basic.notadvance.entity.Member;
import com.basic.notadvance.repository.MemberRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberServiceImpl implements MemberService {
        private final MemberRepository memberrepository;
        public MemberServiceImpl(MemberRepository memberrepository) {
            this.memberrepository = memberrepository;
        }

        @Override
        public Member addMember(Member member){
              return  memberrepository.save(member);
        }
        @Override
        public Member getMemberById(Long id){
            return  memberrepository.findById(id).orElseThrow(()->new RuntimeException("not found"));
        }
        @Override
        public List<Member> getAllMembers(){
            return  memberrepository.findAll();
        }
        @Override
        public Member updateMember(Long id, Member member){
            Member memberIn= getMemberById(id);
            memberIn.setName(member.getName());
            memberIn.setEmail(member.getEmail());
            memberIn.setPhone(member.getPhone());
            return  memberrepository.save(memberIn);
        }
        @Override
        public  void deleteMember(Long id){
            memberrepository.deleteById(id);
        }

}
