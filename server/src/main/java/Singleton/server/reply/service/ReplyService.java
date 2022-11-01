package Singleton.server.reply.service;

import Singleton.server.exception.BusinessLogicException;
import Singleton.server.exception.ExceptionCode;
import Singleton.server.reply.entity.Reply;
import Singleton.server.reply.repository.ReplyRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class ReplyService {
    private final ReplyRepository replyRepository;

    public ReplyService(ReplyRepository replyRepository){this.replyRepository = replyRepository;}

    public Reply createReply(Reply reply){

        return replyRepository.save(reply);
    }

    public Reply findReply(long replyId) { return findVerifiedReplyByQuery(replyId);}

    private Reply findVerifiedReplyByQuery(long replyId) {
        Optional<Reply> optionalReply = replyRepository.findByReply(replyId);
        Reply findReply =
                optionalReply.orElseThrow(() ->
                        new BusinessLogicException(ExceptionCode.REPLY_NOT_FOUND));

        return findReply;
    }

    public Reply updateReply(Reply reply) {
        Reply findReply = findVerifiedReply(reply.getReplyId());

        Optional.ofNullable(reply.getReplyBody())
                .ifPresent(replyBody -> findReply.setReplyBody(replyBody));

        return replyRepository.save(findReply);
    }

    public void deleteReply(long replyId) {
        Reply reply = findVerifiedReply(replyId);
        replyRepository.delete(reply);
    }

    public Reply findVerifiedReply(long replyId) {
        Optional<Reply> optionalReply = replyRepository.findByReply(replyId);
        Reply findReply =
                optionalReply.orElseThrow(() ->
                        new BusinessLogicException(ExceptionCode.REPLY_NOT_FOUND));
        return findReply;
    }
}
