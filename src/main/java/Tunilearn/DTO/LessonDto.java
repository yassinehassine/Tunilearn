package Tunilearn.DTO;

public record LessonDto(
        Long id,
        String title,
        String videoUrl,
        String pdfUrl,
        Integer orderIndex,
        Long chapterId
) { }
