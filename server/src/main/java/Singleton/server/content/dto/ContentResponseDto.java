package Singleton.server.content.dto;

import Singleton.server.member.entity.Member;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Builder
@Getter
public class ContentResponseDto {
    private long memberId;
    private long contentId;
    private String title;
    private String body;
    private int rec;
    private String tags;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;

    public void setMember(Member member) {
        this.memberId = member.getMemberId();
    }
}
