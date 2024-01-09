package com.paccy.firstSpringProject.repository;

import com.paccy.firstSpringProject.entity.Course;
import com.paccy.firstSpringProject.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TeacherRepositoryTest {
    @Autowired
    public  TeacherRepository teacherRepository;
    @Test
    public void saveTeacher(){
        Course courseGui = Course.builder()
                .title("GUI")
                .credit(6)
                .build();
        Course courseWui = Course.builder()
                .title("WUI")
                .credit(8)
                .build();

        Teacher teacher = Teacher.builder()
                .firstName("Louis")
                .lastName("MUkama")
//                .courses(List.of(courseWui,courseGui))
                .build();

        teacherRepository.save(teacher);

    }

}