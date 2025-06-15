package Tunilearn.Mapper;

import Tunilearn.DTO.CourseDto;
import Tunilearn.entities.Course;
import Tunilearn.entities.CourseStatus;

public class CourseMapper {

    public static CourseDto toDto(Course c) {
        return new CourseDto(
                c.getId(), c.getTitle(), c.getDescription(), c.getCategory(),
                c.getPrice(), c.getStatus().name(), c.getThumbnailUrl()
        );
    }

    public static Course toEntity(CourseDto dto) {
        return Course.builder()
                .id(dto.id())
                .title(dto.title())
                .description(dto.description())
                .category(dto.category())
                .price(dto.price() == null ? 0.0 : dto.price())
                .status(CourseStatus.valueOf(
                        dto.status() == null ? "DRAFT" : dto.status()))
                .thumbnailUrl(dto.thumbnailUrl())
                .build();
    }

    public static void update(Course c, CourseDto dto) {
        c.setTitle(dto.title());
        c.setDescription(dto.description());
        c.setCategory(dto.category());
        c.setPrice(dto.price());
        c.setStatus(CourseStatus.valueOf(dto.status()));
        c.setThumbnailUrl(dto.thumbnailUrl());
    }
}
