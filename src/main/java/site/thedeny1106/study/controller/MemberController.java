package site.thedeny1106.study.controller;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import site.thedeny1106.study.common.ResponseEntity;
import site.thedeny1106.study.member.Member;
import site.thedeny1106.study.member.MemberRepository;
import site.thedeny1106.study.member.MemberRequest;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("${api.v1}/members")
public class MemberController {

    private final MemberRepository memberRepository;

    @Operation(
            summary = "전체 회원 조회",
            description = "전체 회원 목록을 조회한다."
    )
    @GetMapping
    public ResponseEntity<List<Member>> findAll() {
        List<Member> found = memberRepository.findAll();
        return new ResponseEntity<>(200, found, found.size());
    }

    @Operation(
            summary = "회원 등록",
            description = "요청으로 받은 회원 정보를 public.member에 저장한다."
    )
    @PostMapping
    public Member create(@RequestBody MemberRequest request) {
        Member member = new Member(
                UUID.randomUUID(),
                request.email(),
                request.name(),
                request.password(),
                request.phone(),
                request.saltKey(),
                request.flag()
        );
        return memberRepository.save(member);
    }

    @Operation(
            summary = "회원 정보 수정",
            description = "수정할 정보를 받아 public.member의 레코드를 수정한다."
    )
    @PutMapping("/{id}")
    public Member update(@RequestBody MemberRequest request, @PathVariable String id) {
        Member member = new Member(
                UUID.fromString(id),
                request.email(),
                request.name(),
                request.password(),
                request.phone(),
                request.saltKey(),
                request.flag()
        );
        return memberRepository.save(member);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        memberRepository.deleteById(UUID.fromString(id));
    }
}
