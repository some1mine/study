package site.thedeny1106.projectPay.member.applicaation;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import site.thedeny1106.projectPay.common.ResponseEntity;
import site.thedeny1106.projectPay.member.applicaation.dto.MemberCommand;
import site.thedeny1106.projectPay.member.applicaation.dto.MemberInfo;
import site.thedeny1106.projectPay.member.domain.Member;
import site.thedeny1106.projectPay.member.domain.MemberRepository;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    public ResponseEntity<List<MemberInfo>> findAll(Pageable pageable) {
        Page<Member> page = memberRepository.findAll(pageable);
        List<MemberInfo> members = page.stream()
                .map(MemberInfo::from)
                .toList();
        return new ResponseEntity<>(HttpStatus.OK.value(), members, page.getTotalElements());
    }

    public ResponseEntity<MemberInfo> create(MemberCommand command) {
        Member member = Member.create(
                command.email(),
                command.name(),
                command.password(),
                command.phone(),
                command.saltKey(),
                command.flag()
        );
        MemberInfo response = MemberInfo.from(memberRepository.save(member));

        return new ResponseEntity<>(HttpStatus.OK.value(), response, 1);
    }

    public ResponseEntity<MemberInfo> update(String id, MemberCommand command) {
        Member found = memberRepository.findById(UUID.fromString(id)).orElse(null);
        if (found == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND.value(),  null, 0);

        Member member = Member.create(
                command.email(),
                command.name(),
                command.password(),
                command.phone(),
                command.saltKey(),
                command.flag()
        );

        MemberInfo response = MemberInfo.from(memberRepository.save(member));

        return new ResponseEntity<>(HttpStatus.OK.value(), response, 1);
    }

    public ResponseEntity<?> delete(String id) {
        memberRepository.deleteById(UUID.fromString(id));
        return new ResponseEntity<>(HttpStatus.OK.value(), 1, 1);
    }
}
