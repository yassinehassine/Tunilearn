
package Tunilearn.Mapper;

import Tunilearn.DTO.ChapterDto;
import Tunilearn.entities.Chapter;
import Tunilearn.entities.Course;

public class ChapterMapper {
    public static ChapterDto toDto(Chapter ch) {
        return new ChapterDto(ch.getId(), ch.getTitle() ,  ch.getCourse() != null ? ch.getCourse().getId() : null);
    }
    public static Chapter toEntity(ChapterDto dto , Course course) {
        return Chapter.builder()
                .id(dto.id())
                .title(dto.title())
                .course(course)
                .build();
    }
    public static void update(Chapter ch, ChapterDto dto) {
        ch.setTitle(dto.title());
    }
}
