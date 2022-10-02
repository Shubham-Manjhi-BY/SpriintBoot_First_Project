package com.SpringBoot_First_Project.SpringBoot_First_Project.Services;

import com.SpringBoot_First_Project.SpringBoot_First_Project.Entity.Courses;
import com.SpringBoot_First_Project.SpringBoot_First_Project.Repository.Repository_For_Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class Services_For_Courses {
    @Autowired
    Repository_For_Course repository_for_course;

    public List<Courses> getAllCourse(){ return repository_for_course.findAll();}

    public Courses getCourseById(@PathVariable("course_Id") int course_Id){
        Optional<Courses> course = repository_for_course.findById(course_Id);
        if(course.isEmpty()) throw  new RuntimeException("Make Custom exception for Id not exist");
        return course.get();
    }

    public Courses addCourse(Courses course){ return repository_for_course.save(course);}

    public long numberOfCourse(){   return repository_for_course.count();}

    public void deleteById(@PathVariable("id") int id){
        Optional<Courses> course = repository_for_course.findById(id);
        if(course.isEmpty()) throw  new RuntimeException("Make Custom exception for Id not exist");
        repository_for_course.delete(course.get());
    }

    public String isExistById(@PathVariable("id") int id){
        Optional<Courses> course = repository_for_course.findById(id);
        return "{" +
                "\"id=\"" + id +
                ", \"isExist\"=" + course.isPresent()+
                '}';
    }
}
