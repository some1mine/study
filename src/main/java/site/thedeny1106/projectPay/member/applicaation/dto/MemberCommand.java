package site.thedeny1106.projectPay.member.applicaation.dto;

public record MemberCommand(
        String email,
        String name,
        String password,
        String phone,
        String saltKey,
        String flag
) {
}
