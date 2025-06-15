package Tunilearn.services;

import Tunilearn.DTO.ChapterDto;
import Tunilearn.entities.Chapter;
import Tunilearn.Mapper.ChapterMapper;
import Tunilearn.entities.Course;
import Tunilearn.repositories.ChapterRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service @RequiredArgsConstructor @Transactional
public class ChapterService {

    private final ChapterRepository repo;
    private final CourseService courseService;

    public ChapterDto create(ChapterDto dto) {
        Course course = courseService.find(dto.courseId());   // vérifie course
        Chapter saved = repo.save(ChapterMapper.toEntity(dto, course));
        return ChapterMapper.toDto(saved);
    }

    public List<ChapterDto> list() {
        return repo.findAll().stream().map(ChapterMapper::toDto).toList();
    }

    public ChapterDto get(Long id) { return ChapterMapper.toDto(find(id)); }

    public ChapterDto update(Long id, ChapterDto dto) {
        Chapter ch = find(id);
        ChapterMapper.update(ch, dto);
        if (!ch.getCourse().getId().equals(dto.courseId())) {     // on veut changer de course ?
            Course newCourse = courseService.find(dto.courseId());
            ch.setCourse(newCourse);
        }
        return ChapterMapper.toDto(ch);
    }

    public void delete(Long id) { repo.deleteById(id); }

    /* -------- util -------- */
    public Chapter find(Long id) {
        return repo.findById(id).orElseThrow(() ->
                new EntityNotFoundException("Chapter " + id + " not found"));
    }
}
