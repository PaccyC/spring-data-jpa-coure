package com.paccy.firstSpringProject.repository;

import com.paccy.firstSpringProject.entity.Course;
import com.paccy.firstSpringProject.entity.CourseMaterial;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class CourseMaterialRepositoryTest {
    @Autowired
    public CourseMaterialRepository repository;

 @Test
    public void saveCourseMaterial(){
     Course course = Course.builder()
             .title(".net")
             .credit(6)
             .build();
     CourseMaterial courseMaterial= CourseMaterial.builder()
             .url("www.geeksforgeeks.com")
             .course(course)
             .build();
     repository.save(courseMaterial);
    }

    @Test
    public void printAllCourseMaterials(){
        List<CourseMaterial> courseMaterials= repository.findAll();
        System.out.println("courseMaterials: "+courseMaterials);
    }
}