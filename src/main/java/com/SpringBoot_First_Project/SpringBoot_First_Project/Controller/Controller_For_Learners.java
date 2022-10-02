package com.SpringBoot_First_Project.SpringBoot_First_Project.Controller;



import com.SpringBoot_First_Project.SpringBoot_First_Project.Entity.Courses;
import com.SpringBoot_First_Project.SpringBoot_First_Project.Entity.Learners;
import com.SpringBoot_First_Project.SpringBoot_First_Project.Services.Services_For_Courses;
import com.SpringBoot_First_Project.SpringBoot_First_Project.Services.Services_For_Learners;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/learners")
public class Controller_For_Learners
{
    @Autowired
    private Services_For_Learners services_for_learners;

    @Autowired
    private Services_For_Courses services_for_courses;

    @GetMapping
    public List<Learners> getAllLeaners(){    return services_for_learners.getAllLearner();}

    @GetMapping("/{id}")
    public Learners getLeanerById(@PathVariable int id){    return services_for_learners.getLearnerById(id);}

    @GetMapping("/count")
    public long numberOfLearners(){ return services_for_learners.numberOfLearner();}

    @GetMapping(value = "/isExist/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public String isLeanerExistById(@PathVariable int id){    return services_for_learners.isExistById(id);}

    @PostMapping
    public Learners addLearner(@RequestBody Learners learner){    return services_for_learners.addLearner(learner);}

    @PutMapping("/getCourseByLearnerId/{id}")
    public Courses getCourseByLearnerId(@PathVariable int id) {  return services_for_learners.getCourseByLearner(id);}

    @PutMapping("/{id}/course/{c_id}")
    public Learners assignCourseToLearner(@PathVariable int c_id, @PathVariable int id)
    {     return
            services_for_learners.assignProfile(
                    id,
                    services_for_courses.getCourseById(c_id)
            );
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable int id){   services_for_learners.deleteById(id);}



    // -------------------------------- Queries Based Rest API --------------------------------------
    @PostMapping(value = "/findByEmailAndLastName")
    public List<Learners> findByEmailAndLastName(@RequestBody Map<String,String> response)
    {
        return services_for_learners.findByEmailAddressAndLastname(response.get("learner_email").toString(),response.get("learner_last_name").toString());
    }

    @PostMapping(value = "/findDistinctLeanerByLastnameOrFirstname")
    public List<Learners> findDistinctLeanerByLastnameOrFirstname(@RequestBody Map<String,String> response){
        return services_for_learners.findDistinctLeanerByLastnameOrFirstname(response.get("learner_first_name").toString(),response.get("learner_last_name").toString());
    }

    @PostMapping(value = "/findByLastnameIgnoreCase")
    public List<Learners> findByLastnameIgnoreCase(@RequestBody Map<String,String> response){
        return services_for_learners.findByLastnameIgnoreCase(response.get("learner_last_name").toString());
    }

    @PostMapping(value = "/findByLastnameOrderByFirstnameAsc")
    public List<Learners> findByLastnameOrderByFirstnameAsc(@RequestBody Map<String,String> response){
        return services_for_learners.findByLastnameOrderByFirstnameAsc(response.get("learner_last_name").toString());
    }
}
