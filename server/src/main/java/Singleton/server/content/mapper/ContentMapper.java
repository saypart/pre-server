package Singleton.server.content.mapper;

import Singleton.server.content.dto.ContentPatchDto;
import Singleton.server.content.dto.ContentPostDto;
import Singleton.server.content.dto.ContentResponseDto;
import Singleton.server.content.entity.Content;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ContentMapper {
    Content contentPostDtoToReply(ContentPostDto contentPostDto);
    Content contentPatchDtoToReply(ContentPatchDto contentPatchDto);
    ContentResponseDto contentToContentResponseDto(Content content);
}
