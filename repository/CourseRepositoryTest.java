package com.paccy.firstSpringProject.repository;

import com.paccy.firstSpringProject.entity.Course;
import com.paccy.firstSpringProject.entity.Student;
import com.paccy.firstSpringProject.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseRepositoryTest {
    @Autowired
    public CourseRepository courseRepository;
    @Test
    public void printAllCourses(){
        List<Course> courses= courseRepository.findAll();
        System.out.println("courses: "+ courses);
    }

    @Test
    public void saveCourseWithTeacher(){

        Teacher teacher = Teacher.builder()
                .firstName("John")
                .lastName("McLaren")
                .build();
        Course course= Course.builder()
                .title("Typescript")
                .credit(9)
                .teacher(teacher)
                .build();
        courseRepository.save(course);
    }

    @Test
    public void findAllPagination(){
        Pageable firstPageWithFourRecords= PageRequest.of(0,4);
        Pageable thirdPageWithTwoRecords= PageRequest.of(1,2);

        List<Course> courses=courseRepository.findAll(firstPageWithFourRecords).getContent();
        Long totalElements=courseRepository.findAll(firstPageWithFourRecords).getTotalElements();
        Long totalPages= (long) courseRepository.findAll(thirdPageWithTwoRecords).getTotalPages();

        System.out.println("courses :" + courses);

        System.out.println("totalPages :" + totalPages);

    }
    @Test
    public void findAllSorting(){
        Pageable sortByTitle= PageRequest.of(
                0,
                2,
                Sort.by("title")

        );
        Pageable sortByCreditDesc= PageRequest.of(
                0,
                2,
                Sort.by("credit").descending()
        );
        Pageable sortByTitleAndCreditDesc= PageRequest.of(
                0,
                2,
                Sort.by("title").descending()
                        .and(Sort.by("credit"))
        );

        List<Course> courses = courseRepository.findAll(sortByTitle).getContent();
        System.out.println("courses: "+ courses);
    }
    @Test
    public void saveCourseWithStudentAndTeacher(){

        Student student = Student.builder()
                .firstName("Noel")
                .lastName("Mugisha")
                .emailId("noel@gmail.com")
                .build();
        Teacher teacher= Teacher.builder()
                .firstName("Damas")
                .lastName("Habanabashaka")
                .build();
        Course course = Course.builder()
                .title("SpringBoot")
                .credit(9)
                .teacher(teacher)
                .build();
        course.addStudent(student);
        courseRepository.save(course);
    }
}