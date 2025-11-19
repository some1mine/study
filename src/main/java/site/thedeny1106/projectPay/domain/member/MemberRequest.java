package site.thedeny1106.projectPay.domain.member;

public record MemberRequest(
        String email,
        String name,
        String password,
        String phone,
        String saltKey,
        String flag
) {
}
