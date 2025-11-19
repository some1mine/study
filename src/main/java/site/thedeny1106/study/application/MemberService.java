package site.thedeny1106.study.application;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import site.thedeny1106.study.common.ResponseEntity;
import site.thedeny1106.study.domain.member.Member;
import site.thedeny1106.study.domain.member.MemberRepository;
import site.thedeny1106.study.domain.member.MemberRequest;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    public ResponseEntity<List<Member>> findAll() {
        return new ResponseEntity<>(HttpStatus.OK.value(), memberRepository.findAll(), memberRepository.count());
    }

    public ResponseEntity<Member>  create(MemberRequest request) {
        Member member = new Member(
                UUID.randomUUID(),
                request.email(),
                request.name(),
                request.password(),
                request.phone(),
                request.saltKey(),
                request.flag()
        );
        return new ResponseEntity<>(HttpStatus.OK.value(), memberRepository.save(member), 1);
    }

    public ResponseEntity<Member> update(String id, MemberRequest request) {
        Member found = memberRepository.findById(UUID.fromString(id)).orElseGet(null);
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

        return  new ResponseEntity<>(HttpStatus.OK.value(), memberRepository.save(member), 1);
    }

    public ResponseEntity<?> delete(String id) {
        memberRepository.deleteById(UUID.fromString(id));
        return new ResponseEntity<>(HttpStatus.OK.value(), 1, 1);
    }
}
