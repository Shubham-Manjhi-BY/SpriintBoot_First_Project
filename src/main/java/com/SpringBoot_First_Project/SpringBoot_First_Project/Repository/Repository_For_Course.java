package com.SpringBoot_First_Project.SpringBoot_First_Project.Repository;

import com.SpringBoot_First_Project.SpringBoot_First_Project.Entity.Courses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface Repository_For_Course extends JpaRepository<Courses,Integer>
{

}
