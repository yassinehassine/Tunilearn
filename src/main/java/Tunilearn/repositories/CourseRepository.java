package Tunilearn.repositories;
import Tunilearn.entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import Tunilearn.entities.Chapter;
public interface CourseRepository extends JpaRepository<Course, Long> {}

