package Tunilearn.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import Tunilearn.entities.Chapter;
public interface ChapterRepository extends JpaRepository<Chapter, Long> { }
