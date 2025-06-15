package Tunilearn.controllers;

import Tunilearn.DTO.LessonDto;
import Tunilearn.services.LessonService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/lessons")
@RequiredArgsConstructor
public class LessonController {

    private final LessonService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public LessonDto create(@Valid @RequestBody LessonDto dto) {
        return service.create(dto);
    }

    @GetMapping
    public List<LessonDto> list() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public LessonDto get(@PathVariable Long id) {
        return service.findById(id);
    }

    @PutMapping("/{id}")
    public LessonDto update(@PathVariable Long id, @Valid @RequestBody LessonDto dto) {
        return service.update(id, dto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
