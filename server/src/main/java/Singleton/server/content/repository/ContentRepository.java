package Singleton.server.content.repository;

import Singleton.server.content.entity.Content;
import Singleton.server.reply.entity.Reply;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface ContentRepository extends JpaRepository<Content, Long> {
    @Query(value = "SELECT c FROM Content c WHERE c.contentId = :contentId")
    Optional<Content> findByContent(long contentId);
}
