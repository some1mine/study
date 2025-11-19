package site.thedeny1106.study.interfaces.controller;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import site.thedeny1106.study.application.MemberService;
import site.thedeny1106.study.common.ResponseEntity;
import site.thedeny1106.study.domain.member.Member;
import site.thedeny1106.study.domain.member.MemberRepository;
import site.thedeny1106.study.domain.member.MemberRequest;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("${api.v1}/members")
public class MemberController {

    private final MemberService memberService;

    @Operation(
            summary = "전체 회원 조회",
            description = "전체 회원 목록을 조회한다."
    )
    @GetMapping
    public ResponseEntity<List<Member>> findAll() {
        return memberService.findAll();
    }

    @Operation(
            summary = "회원 등록",
            description = "요청으로 받은 회원 정보를 public.member에 저장한다."
    )
    @PostMapping
    public ResponseEntity<Member> create(@RequestBody MemberRequest request) {
        return memberService.create(request);
    }

    @Operation(
            summary = "회원 정보 수정",
            description = "수정할 정보를 받아 public.member의 레코드를 수정한다."
    )
    @PutMapping("/{id}")
    public ResponseEntity<Member> update(@RequestBody MemberRequest request, @PathVariable String id) {
        return memberService.update(id, request);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        return memberService.delete(id);
    }
}
