package Tunilearn.Mapper;

import Tunilearn.DTO.LessonDto;
import Tunilearn.entities.Chapter;
import Tunilearn.entities.Lesson;

public class LessonMapper {

    public static LessonDto toDto(Lesson entity) {
        return new LessonDto(
                entity.getId(),
                entity.getTitle(),
                entity.getVideoUrl(),
                entity.getPdfUrl(),
                entity.getOrderIndex(),
                entity.getChapter() != null ? entity.getChapter().getId() : null
        );
    }

    public static Lesson toEntity(LessonDto dto ,  Chapter chapter) {
        return Lesson.builder()
                .id(dto.id())
                .title(dto.title())
                .videoUrl(dto.videoUrl())
                .pdfUrl(dto.pdfUrl())
                .orderIndex(dto.orderIndex())
                .chapter(chapter)
                .build();
    }

    public static void updateEntity(Lesson entity, LessonDto dto) {
        entity.setTitle(dto.title());
        entity.setVideoUrl(dto.videoUrl());
        entity.setPdfUrl(dto.pdfUrl());
        entity.setOrderIndex(dto.orderIndex());
    }
}
