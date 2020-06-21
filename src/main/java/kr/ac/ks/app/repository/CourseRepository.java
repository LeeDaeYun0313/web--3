package kr.ac.ks.app.repository;

import kr.ac.ks.app.domain.Course;
import kr.ac.ks.app.domain.Lesson;
import kr.ac.ks.app.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
    Course findCourseByStudent(Student student);
    Course findCourseByLesson(Lesson lesson);
}
