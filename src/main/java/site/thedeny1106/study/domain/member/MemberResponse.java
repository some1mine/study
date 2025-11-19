package site.thedeny1106.study.domain.member;

import java.time.LocalDateTime;
import java.util.UUID;

public record MemberResponse (
    UUID id,
    String email,
    String name,
    String phone,
    UUID regId,
    LocalDateTime regDt,
    UUID modifyId,
    LocalDateTime modifyDt
){}
