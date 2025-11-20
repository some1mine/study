package site.thedeny1106.projectPay.member.applicaation.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import site.thedeny1106.projectPay.member.domain.Member;

import java.time.LocalDateTime;
import java.util.UUID;

@Schema(description = "유저 정보")
@Data
@Entity
@NoArgsConstructor
@Table(name = "\"member\"", schema = "public")
public class MemberInfo {

    @Schema(description = "유저의 UUID")
    @Id
    private UUID id;

    @Schema(description = "유저의 email")
    @Column(nullable = false, length = 50, unique = true)
    private String email;

    @Schema(description = "유저명")
    @Column(name = "\"name\"", length = 20)
    private String name;

    @Schema(description = "비밀번호")
    @Column(name = "\"password\"", nullable = false, length = 100)
    private String password;

    @Schema(description = "핸드폰번호")
    @Column(nullable = false, length = 20, unique = true)
    private String phone;

    @Column(name = "reg_id", updatable = false)
    private UUID regId;

    @Column(name = "reg_dt", updatable = false)
    private LocalDateTime regDt;

    @Column(name = "modify_id", nullable = false)
    private UUID modifyId;

    @Column(name = "modify_dt", nullable = false)
    private LocalDateTime modifyDt;

    @Column(name = "saltkey", nullable = false, length = 14)
    private String saltKey;

    @Column(name = "flag", length = 5)
    private String flag;


    public MemberInfo(UUID id,
                      String email,
                      String name,
                      String phone,
                      String flag) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.phone = phone;
        this.flag = flag;
    }

    public static MemberInfo from(Member member) {
        return new MemberInfo(
                member.getId(),
                member.getEmail(),
                member.getName(),
                member.getPhone(),
                member.getFlag()
        );
    }

    @PrePersist
    public void prePersist() {
        if (regId == null) {
            regId = id != null ? id : UUID.randomUUID();
        }
        if (modifyId == null) {
            modifyId = regId;
        }
        if (regDt == null) {
            regDt = LocalDateTime.now();
        }
        if (modifyDt == null) {
            modifyDt = LocalDateTime.now();
        }
        if (id == null) {
            id = UUID.randomUUID();
        }
    }

    @PreUpdate
    public void preUpdate() {
        modifyDt = LocalDateTime.now();
        if (modifyId == null) {
            modifyId = id;
        }
    }

}