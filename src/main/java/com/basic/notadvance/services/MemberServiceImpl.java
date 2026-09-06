package com.basic.notadvance.services;
import com.basic.notadvance.dto.MemberRequestDTO;
import com.basic.notadvance.dto.MemberResponseDTO;
import com.basic.notadvance.entity.Member;
import com.basic.notadvance.repository.MemberRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;
@Service
public class MemberServiceImpl implements MemberService {
        private final MemberRepository memberrepository;
        public MemberServiceImpl(MemberRepository memberrepository) {
            this.memberrepository = memberrepository;
        }
        @Override
        public MemberResponseDTO addMember(MemberRequestDTO member){
             Member newMember = new Member();
             newMember.setName(member.getName());
             newMember.setPhone(member.getPhone());
             newMember.setEmail(member.getEmail());
             Member savedMember = memberrepository.save(newMember);
            return toMemberResponseDTO(savedMember);
        }
        @Override
        public MemberResponseDTO getMemberById(Long id){
            Member member = memberrepository.findById(id).orElseThrow(()-> new RuntimeException("member not found"));
            return  toMemberResponseDTO(member);
        }
        @Override
        public List<MemberResponseDTO> getAllMembers(){
            return  memberrepository.findAll().stream().map(this::toMemberResponseDTO).collect(Collectors.toList());
        }
        @Override
        public MemberResponseDTO updateMember(Long id, MemberRequestDTO member){
            Member memberIn= memberrepository.findById(id).orElseThrow(()->new RuntimeException("id not found"));
            memberIn.setName(member.getName());
            memberIn.setEmail(member.getEmail());
            memberIn.setPhone(member.getPhone());
            Member updatedMember = memberrepository.save(memberIn);
            return toMemberResponseDTO(updatedMember);
        }
        @Override
        public  void deleteMember(Long id){
            memberrepository.deleteById(id);
        }




        private  MemberResponseDTO toMemberResponseDTO(Member member){
            return   new MemberResponseDTO(
                    member.getId(),
                    member.getName(),
                    member.getPhone(),
                    member.getEmail(),
                    member.getMembershipDate()
            );

        }
}
