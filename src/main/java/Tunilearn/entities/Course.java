package Tunilearn.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Course {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank  private String title;
    private String description;
    private String category;

    @PositiveOrZero private Double price = 0.0;

    @Enumerated(EnumType.STRING)
    private CourseStatus status = CourseStatus.DRAFT;

    private String thumbnailUrl;

    @CreationTimestamp
    private LocalDateTime createdAt;

    /* ─────  Relation bidirectionnelle  ───── */
    @OneToMany(mappedBy = "course",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<Chapter> chapters = new ArrayList<>();
}
