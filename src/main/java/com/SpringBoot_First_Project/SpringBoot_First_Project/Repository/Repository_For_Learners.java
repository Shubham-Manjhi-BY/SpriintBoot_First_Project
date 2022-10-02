package com.SpringBoot_First_Project.SpringBoot_First_Project.Repository;



import com.SpringBoot_First_Project.SpringBoot_First_Project.Entity.Learners;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Repository_For_Learners extends JpaRepository<Learners,Integer>
{
    @Modifying
    @Query("SELECT l FROM Learners l Where l.learner_email = :email AND l.learner_last_name = :last_name" )
    List<Learners> findByEmailAddressAndLastname(@Param("email") String email, @Param("last_name") String last_name );

    @Modifying
    @Query("SELECT DISTINCT l FROM Learners l Where l.learner_first_name = :first_name OR l.learner_last_name = :last_name")
    List<Learners> findDistinctLeanerByLastnameOrFirstname(@Param("first_name") String firstname, @Param("last_name") String lastname );

    @Modifying
    @Query("SELECT l FROM Learners l Where UPPER(l.learner_last_name) = UPPER(:last_name)")
    List<Learners> findByLastnameIgnoreCase( @Param("last_name") String last_name );

    @Modifying
    @Query("SELECT l FROM Learners l Where l.learner_last_name = :last_name ORDER BY l.learner_first_name ASC")
    List<Learners> findByLastnameOrderByFirstnameAsc(@Param("last_name") String last_name );

}
