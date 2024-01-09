package com.paccy.firstSpringProject.repository;

import com.paccy.firstSpringProject.entity.Guardian;
import com.paccy.firstSpringProject.entity.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentRepositoryTest {
    @Autowired
    public StudentRepository studentRepository;

    @Test
    public void saveStudent() {
        Student student = Student.builder().
                emailId("paccy2@gmail.com")
                .firstName("Abayisenga")
                .lastName("Aime")
//                 .guardianName("Stanley")
//                 .guardianEmail("mwizstar@gmail.com")
//                 .guardianMobile("11111111")
                .build();
        studentRepository.save(student);
    }

    @Test
    public void saveStudentWithGuardian() {
        Guardian guardian = Guardian.builder().
                name("Stanley")
                .email("mwizstar@gmail.com")
                .mobile("111111111111")
                .build();
        Student student = Student.builder().
                emailId("paccy2@gmail.com")
                .firstName("Abayisenga")
                .lastName("Aime")
                .guardian(guardian)
                .build();
        studentRepository.save(student);
    }

    @Test
    public void getAllStudents() {
        List<Student> studentList = studentRepository.findAll();
        System.out.println("Students: " + studentList);
    }

    @Test
    public void getStudentsByFirstName() {

        List<Student> studentList = studentRepository.findByFirstName("Abayisenga");
        System.out.println("Student " + studentList);
    }

    @Test
    public void getStudentByEmailAddress() {
        Student student = studentRepository.getStudentByEmailIdNative("paccy2@gmail.com");
        System.out.println("Student " + student);


    }

    @Test
    public void getStudentFirstNameByEmailAddress() {
        String firstName = studentRepository.getStudentFirstNameByEmailAddress("paccy@gmail.com");
        System.out.println("Student: " + firstName);
    }

    @Test
    public void getStudentByEmailAddressNamedParam() {
        Student student = studentRepository.getStudentByEmailIdNativeNamedParam("paccy2@gmail.com");
        System.out.println("Student " + student);


    }

    @Test
    public  void  updateStudentFirstNameByEmailAddressNativeNamedParam(){
        studentRepository.updateStudentFirstNameByEmailAddressNativeNamedParam("Pacifique","paccy2@gmail.com");
    }
}