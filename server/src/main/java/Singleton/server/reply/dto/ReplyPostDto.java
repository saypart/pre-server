package Singleton.server.reply.dto;

import Singleton.server.member.entity.Member;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

@Getter
@Builder
public class ReplyPostDto {
    @Positive
    private long memberId;

    @Positive
    private long contentId;

    private String replyBody;

//    public Member getMember() {
//        Member member = new Member();
//        member.setMemberId(memberId);
//        return member;
//    }
}
