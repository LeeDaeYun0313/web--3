package kr.ac.ks.app.domain;

import kr.ac.ks.app.controller.LessonForm;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class Lesson {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private int quota;

    @OneToMany
    private List<Course> courses = new ArrayList<>();

    public Lesson() {
    }

    @Builder
    public Lesson(String name, int quota) {
        this.name = name;
        this.quota = quota;
    }

    public void modify(LessonForm lessonForm) {
        setName(lessonForm.getName());
        setQuota(lessonForm.getQuota());
    }


}
