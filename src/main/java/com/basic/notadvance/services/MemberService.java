package com.basic.notadvance.services;
import com.basic.notadvance.dto.MemberRequestDTO;
import com.basic.notadvance.dto.MemberResponseDTO;

import java.util.List;

public interface MemberService {
    MemberResponseDTO addMember(MemberRequestDTO member);
    MemberResponseDTO getMemberById(Long id);
    List<MemberResponseDTO> getAllMembers();
    MemberResponseDTO updateMember(Long id, MemberRequestDTO member);
    void deleteMember(Long id);
}