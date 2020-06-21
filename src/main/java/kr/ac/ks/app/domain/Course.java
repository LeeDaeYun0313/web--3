package kr.ac.ks.app.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Entity
@Getter
@Setter
public class Course {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Student student;

    @ManyToOne(fetch = FetchType.LAZY)
    private Lesson lesson;

    public void setStudent(Student student) {
        this.student = student;
    }


    public void modify(Student student, Lesson... lessons) {
        this.lesson.setQuota(this.lesson.getQuota() + 1);

        this.student = student;
        Arrays.stream(lessons).forEach(this::setLesson);
    }

    private void setLesson(Lesson lesson) {
        this.lesson = lesson;
        this.lesson.setQuota(this.lesson.getQuota()-1);
    }

    public void deleteCourse(){
        this.student.getCourses().remove(this);
        this.lesson.getCourses().remove(this);
        this.lesson.setQuota(this.lesson.getQuota()+1);

    }
    public static Course createCourse(Student student, Lesson... lessons) {
        Course course = new Course();
        course.setStudent(student);
        Arrays.stream(lessons).forEach(course::setLesson);
        return course;
    }



}
