package com.SpringBoot_First_Project.SpringBoot_First_Project.Controller;


import com.SpringBoot_First_Project.SpringBoot_First_Project.Entity.Courses;
import com.SpringBoot_First_Project.SpringBoot_First_Project.Services.Services_For_Courses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Courses")
public class Controller_For_Courses
{

    private Services_For_Courses services_for_courses;

    @GetMapping
    public List<Courses> getAllCourse(){    return services_for_courses.getAllCourse();}

    @GetMapping("/{id}")
    public Courses getCourseById(@PathVariable int id){    return services_for_courses.getCourseById(id);}

    @GetMapping("/count")
    public long numberOfCourses(){ return services_for_courses.numberOfCourse();}

    @GetMapping(value="/isExist/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public String isCourseExistById(@PathVariable int id){    return services_for_courses.isExistById(id);}

    @PostMapping
    public Courses addCourse(@RequestBody Courses course){    return services_for_courses.addCourse(course);}

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable int id){   services_for_courses.deleteById(id);}
}
