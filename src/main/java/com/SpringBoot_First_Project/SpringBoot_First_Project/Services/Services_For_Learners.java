package com.SpringBoot_First_Project.SpringBoot_First_Project.Services;

import com.SpringBoot_First_Project.SpringBoot_First_Project.Entity.Courses;
import com.SpringBoot_First_Project.SpringBoot_First_Project.Entity.Learners;
import com.SpringBoot_First_Project.SpringBoot_First_Project.Repository.Repository_For_Learners;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;


@Service
public class Services_For_Learners
{
    @Autowired
    Repository_For_Learners repository_for_learners;

    @Transactional
    public List<Learners> findByEmailAddressAndLastname(String email, String last_name){
        return repository_for_learners.findByEmailAddressAndLastname(email,last_name);
    }

    @Transactional
    public List<Learners> findDistinctLeanerByLastnameOrFirstname(String first_name, String last_name){
        return repository_for_learners.findDistinctLeanerByLastnameOrFirstname(first_name,last_name);
    }

    @Transactional
    public List<Learners> findByLastnameIgnoreCase( String last_name){
        return repository_for_learners.findByLastnameIgnoreCase(last_name);
    }

    @Transactional
    public List<Learners> findByLastnameOrderByFirstnameAsc(String last_name){
        return repository_for_learners.findByLastnameOrderByFirstnameAsc(last_name);
    }

    public List<Learners> getAllLearner(){ return repository_for_learners.findAll();}

    public Learners getLearnerById(@PathVariable("id") int id){
        Optional<Learners> learner = repository_for_learners.findById(id);
        if(learner.isEmpty()) throw  new RuntimeException("Make Custom exception for Id not exist");
        return learner.get();
    }

    public Learners addLearner(Learners learner){ return repository_for_learners.save(learner);}

    public long numberOfLearner(){   return repository_for_learners.count();}

    public void deleteById(@PathVariable("id") int id){
        Optional<Learners> learner = repository_for_learners.findById(id);
        if(learner.isEmpty()) throw  new RuntimeException("Make Custom exception for Id not exist");
        repository_for_learners.delete(learner.get());
    }

    public String isExistById(@PathVariable("id") int id){
        Optional<Learners> learner = repository_for_learners.findById(id);
        return "{" +
                "\"id=\"" + id +
                ", \"isExist\"=" + learner.isPresent()+
                '}';
    }

    public Learners assignProfile(int id, Courses course){
        Learners learner = repository_for_learners.findById(id).get();
        learner.setCourse(course);
        return repository_for_learners.save(learner);
    }

    public Courses getCourseByLearner(int id) {
        Optional<Learners> learner = repository_for_learners.findById(id);
        if(learner.isEmpty()) throw  new RuntimeException("Make Custom exception for Id not exist");
        return learner.get().getCourse();
    }
}