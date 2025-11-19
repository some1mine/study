package site.thedeny1106.study.application.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import site.thedeny1106.study.infrastructure.common.ResponseEntity;
import site.thedeny1106.study.domain.member.Member;
import site.thedeny1106.study.domain.member.MemberRepository;
import site.thedeny1106.study.domain.member.MemberRequest;
import site.thedeny1106.study.domain.member.MemberResponse;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    public ResponseEntity<List<MemberResponse>> findAll() {
        List<MemberResponse> result = memberRepository.findAll().stream().map(m ->
                new MemberResponse(m.getId(), m.getEmail(), m.getName(),
                        m.getPhone(), m.getRegId(), m.getRegDt(), m.getModifyId(), m.getModifyDt()))
                .toList();
        return new ResponseEntity<>(HttpStatus.OK.value(), result, memberRepository.count());
    }

    public ResponseEntity<MemberResponse> create(MemberRequest request) {
        Member member = new Member(
                UUID.randomUUID(),
                request.email(),
                request.name(),
                request.password(),
                request.phone(),
                request.saltKey(),
                request.flag()
        );
        Member result = memberRepository.save(member);
        MemberResponse response = new MemberResponse(result.getId(), result.getEmail(), result.getName(),
                result.getPhone(), result.getRegId(), result.getRegDt(), result.getModifyId(), result.getModifyDt());

        return new ResponseEntity<>(HttpStatus.OK.value(), response, 1);
    }

    public ResponseEntity<MemberResponse> update(String id, MemberRequest request) {
        Member found = memberRepository.findById(UUID.fromString(id)).orElse(null);
        if (found == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND.value(),  null, 0);

        Member member = new Member(
                UUID.fromString(id),
                request.email(),
                request.name(),
                request.password(),
                request.phone(),
                request.saltKey(),
                request.flag()
        );

        Member result = memberRepository.save(member);
        MemberResponse response = new MemberResponse(result.getId(), result.getEmail(), result.getName(),
                result.getPhone(), result.getRegId(), result.getRegDt(), result.getModifyId(), result.getModifyDt());

        return new ResponseEntity<>(HttpStatus.OK.value(), response, 1);
    }

    public ResponseEntity<?> delete(String id) {
        memberRepository.deleteById(UUID.fromString(id));
        return new ResponseEntity<>(HttpStatus.OK.value(), 1, 1);
    }
}
