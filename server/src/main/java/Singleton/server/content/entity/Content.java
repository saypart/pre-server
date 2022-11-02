package Singleton.server.content.entity;

import Singleton.server.audit.Auditable;
import Singleton.server.member.entity.Member;
import Singleton.server.reply.entity.Reply;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class Content extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long contentId;

    @Column
    private String title;

    @Column
    private String body;

    @Column
    private int rec;

    @Column
    private String tags;

    @Column
    private Long memberId;

    @Column(nullable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    @Column (nullable = false, name = "LAST_MODIFIED_AT")
    private LocalDateTime modifiedAt = LocalDateTime.now();

    public Content(String title, String body,int rec,String tags){
        this.title = title;
        this.body = body;
        this.rec = rec;
        this.tags = tags;
    }
//    @ManyToOne
//    @JoinColumn(name = "memberId")
//    private Member member;
}
