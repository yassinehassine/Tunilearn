package Tunilearn.controllers;

import Tunilearn.DTO.ChapterDto;
import Tunilearn.DTO.CourseDto;
import Tunilearn.services.ChapterService;
import Tunilearn.services.CourseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;

@RestController @RequiredArgsConstructor
@RequestMapping("/api/v1/courses")   // ajoute /examen devant si besoin
public class CourseController {

    private final CourseService service;

    @PostMapping                              @ResponseStatus(CREATED)
    public CourseDto create(@Valid @RequestBody CourseDto dto){ return service.create(dto); }

    @GetMapping
    public List<CourseDto> list(){ return service.list(); }

    @GetMapping("/{id}")
    public CourseDto get(@PathVariable Long id){ return service.get(id); }

    @PutMapping("/{id}")
    public CourseDto update(@PathVariable Long id,
                            @Valid @RequestBody CourseDto dto){ return service.update(id,dto); }

    @DeleteMapping("/{id}")                   @ResponseStatus(NO_CONTENT)
    public void delete(@PathVariable Long id){ service.delete(id); }
}
