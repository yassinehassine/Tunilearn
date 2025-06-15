package Tunilearn.controllers;

import Tunilearn.DTO.ChapterDto;
import Tunilearn.services.ChapterService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController @RequiredArgsConstructor
@RequestMapping("/api/v1/chapters")   // ajouter /examen si context-path absent
public class ChapterController {

    private final ChapterService service;

    @PostMapping              @ResponseStatus(HttpStatus.CREATED)
    public ChapterDto create(@Valid @RequestBody ChapterDto dto) { return service.create(dto); }

    @GetMapping
    public List<ChapterDto> list() { return service.list(); }

    @GetMapping("/{id}")
    public ChapterDto get(@PathVariable Long id) { return service.get(id); }

    @PutMapping("/{id}")
    public ChapterDto update(@PathVariable Long id,
                             @Valid @RequestBody ChapterDto dto) { return service.update(id, dto); }

    @DeleteMapping("/{id}")  @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) { service.delete(id); }
}
