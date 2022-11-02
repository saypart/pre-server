package Singleton.server.content.dto;

import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import java.time.LocalDateTime;

@Getter
@Builder
public class ContentPostDto {

    private long memberId;
    private String title;
    private String body;
    private int rec;
    private String tags;

//    public Member getMember() {
//        Member member = new Member();
//        member.setMemberId(memberId);
//        return member;
//    }
}
