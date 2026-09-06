package com.basic.notadvance.controller;
import com.basic.notadvance.dto.MemberRequestDTO;
import com.basic.notadvance.dto.MemberResponseDTO;
import com.basic.notadvance.services.MemberService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/members")
public class MemberController {
    private  final MemberService memberService;
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping
    public ResponseEntity<MemberResponseDTO> createMember(@RequestBody MemberRequestDTO member) {
        MemberResponseDTO savedMember = memberService.addMember(member);
        return  ResponseEntity.ok(savedMember);

    }
    @GetMapping("/{id}")
    public ResponseEntity<MemberResponseDTO> getMember(@PathVariable Long id) {
        MemberResponseDTO existMember =  memberService.getMemberById(id);
         return ResponseEntity.ok(existMember);
    }
    @GetMapping
    public ResponseEntity<List<MemberResponseDTO>> getAllMembers() {
        List<MemberResponseDTO> members = memberService.getAllMembers();
        return ResponseEntity.ok(members);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MemberResponseDTO> updateMember(@PathVariable Long id,  @RequestBody MemberRequestDTO member) {
        MemberResponseDTO updatedMember = memberService.updateMember(id, member);
        return ResponseEntity.ok(updatedMember);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteMember (@PathVariable Long id){
        memberService.deleteMember(id);
        return ResponseEntity.ok("Deleted" + id);
    }
}
