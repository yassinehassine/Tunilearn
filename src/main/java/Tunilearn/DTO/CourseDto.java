package Tunilearn.DTO;

public record CourseDto(
        Long id,
        String title,
        String description,
        String category,
        Double price,
        String status,       // "DRAFT"…
        String thumbnailUrl
) { }
