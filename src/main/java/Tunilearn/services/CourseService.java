package Tunilearn.services;

import Tunilearn.DTO.ChapterDto;
import Tunilearn.DTO.CourseDto;
import Tunilearn.Mapper.CourseMapper;
import Tunilearn.entities.Chapter;
import Tunilearn.Mapper.ChapterMapper;
import Tunilearn.entities.Course;
import Tunilearn.repositories.ChapterRepository;
import Tunilearn.repositories.CourseRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service @RequiredArgsConstructor @Transactional
public class CourseService {

    private final CourseRepository repo;

    public CourseDto create(CourseDto dto) {
        return CourseMapper.toDto(repo.save(CourseMapper.toEntity(dto)));
    }

    public List<CourseDto> list() {
        return repo.findAll().stream().map(CourseMapper::toDto).toList();
    }

    public CourseDto get(Long id) { return CourseMapper.toDto(find(id)); }

    public CourseDto update(Long id, CourseDto dto) {
        Course c = find(id);
        CourseMapper.update(c, dto);
        return CourseMapper.toDto(c);
    }

    public void delete(Long id) { repo.deleteById(id); }

    /* Helper */
    public Course find(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Course "+id+" introuvable"));
    }
}
