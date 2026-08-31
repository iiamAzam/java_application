package com.basic.notadvance.controller;
import com.basic.notadvance.entity.Member;
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
    public ResponseEntity<Member> createMember(@RequestBody Member member) {
        Member savedmember = memberService.addMember(member);
        return  ResponseEntity.ok(savedmember);

    }
    @GetMapping("/{id}")
    public ResponseEntity<Member> getMember(@PathVariable Long id) {
         Member existMember =  memberService.getMemberById(id);
         return ResponseEntity.ok(existMember);
    }
    @GetMapping
    public ResponseEntity<List<Member>> getAllMembers() {
        List<Member> members = memberService.getAllMembers();
        return ResponseEntity.ok(members);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Member> updateMember(@PathVariable Long id,  @RequestBody Member member) {
        Member updatedMember = memberService.updateMember(id, member);
        return ResponseEntity.ok(updatedMember);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteMember (@PathVariable Long id){
        memberService.deleteMember(id);
        return ResponseEntity.ok("Deleted" + id);
    }
}
