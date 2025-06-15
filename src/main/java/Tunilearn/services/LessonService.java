package Tunilearn.services;

import Tunilearn.DTO.LessonDto;
import Tunilearn.Mapper.LessonMapper;
import Tunilearn.entities.Chapter;
import Tunilearn.entities.Lesson;
import Tunilearn.repositories.LessonRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class LessonService {

    private final LessonRepository repo;
    private final ChapterService chapterService;

    public LessonDto create(LessonDto dto) {
        Chapter chapter = chapterService.find(dto.chapterId());
        Lesson saved = repo.save(LessonMapper.toEntity(dto, chapter));
        return LessonMapper.toDto(saved);
    }

    public List<LessonDto> findAll() {
        return repo.findAll().stream()
                .map(LessonMapper::toDto)
                .toList();
    }

    public LessonDto findById(Long id) {
        Lesson lesson = repo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Lesson " + id + " not found"));
        return LessonMapper.toDto(lesson);
    }

    public LessonDto update(Long id, LessonDto dto) {
        Lesson lesson = repo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Lesson "+id+" not found"));
        Chapter chapter = chapterService.find(dto.chapterId());
        LessonMapper.updateEntity(lesson, dto);      // titre, urls, orderIndex
        lesson.setChapter(chapter);                  // change / confirme le chapitre
        return LessonMapper.toDto(lesson);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}
