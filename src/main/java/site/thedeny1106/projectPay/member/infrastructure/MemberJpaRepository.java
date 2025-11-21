package site.thedeny1106.projectPay.member.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import site.thedeny1106.projectPay.member.domain.Member;

import java.util.UUID;

public interface MemberJpaRepository extends JpaRepository<Member, UUID> {

}
