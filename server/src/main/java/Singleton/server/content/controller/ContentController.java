package Singleton.server.content.controller;

import Singleton.server.content.dto.ContentPatchDto;
import Singleton.server.content.dto.ContentPostDto;
import Singleton.server.content.entity.Content;
import Singleton.server.content.mapper.ContentMapper;
import Singleton.server.content.service.ContentService;
import Singleton.server.response.SingleResponseDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/content")
@Validated
@Slf4j
public class ContentController {
    private ContentService contentService;
    private ContentMapper contentMapper;

    public ContentController(ContentService contentService, ContentMapper contentMapper){
        this.contentService = contentService;
        this.contentMapper = contentMapper;
    }

    @PostMapping
    public ResponseEntity postContent(
            @Valid @RequestBody ContentPostDto contentPostDto){
        Content content =
                contentService.createContent(contentMapper.contentPostDtoToReply(contentPostDto));
        return new ResponseEntity<>(
                new SingleResponseDto<>(contentMapper.contentToContentResponseDto(content)),
                HttpStatus.CREATED);
    }

    @PatchMapping("/{content-id}")
    public ResponseEntity patchContent(@PathVariable("content-id") long contentId,
                                       @Valid @RequestBody ContentPatchDto contentPatchDto) {
        contentPatchDto.setContentId(contentId);
        Content content = contentService.updateContent(contentMapper.contentPatchDtoToReply(contentPatchDto));

        return new ResponseEntity<>(
                new SingleResponseDto<>(contentMapper.contentToContentResponseDto(content)),HttpStatus.OK);
    }

    @GetMapping("/{content-id}")
    public ResponseEntity getContent(@PathVariable("content-id") long contentId){
        Content content = contentService.findContent(contentId);

        return new ResponseEntity<>(
                new SingleResponseDto<>(contentMapper.contentToContentResponseDto(content)),
                HttpStatus.OK);
    }

    @DeleteMapping("/{content-id}")
    public ResponseEntity deleteContent(@PathVariable("content-id") long contentId){
        contentService.deleteContent(contentId);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
