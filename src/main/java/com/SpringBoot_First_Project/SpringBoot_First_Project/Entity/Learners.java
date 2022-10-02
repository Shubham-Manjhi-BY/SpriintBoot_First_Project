package com.SpringBoot_First_Project.SpringBoot_First_Project.Entity;


import javax.persistence.*;

@Entity
@NamedQuery(name="get_all_Learners",query = "SELECT p FROM Learners p")
@Table(name="Learners")
public class Learners
{
    @Id
    @GeneratedValue

    private int id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "course_id",referencedColumnName = "course_Id")
    private Courses course;

    private String learner_first_name ;
    private String learner_last_name ;
    private String learner_email ;
    private String learner_password;

    public Learners()
    {

    }

    public Learners(int id, Courses course, String learner_first_name, String learner_last_name, String learner_email, String learner_password) {
        this.id = id;
        this.course = course;
        this.learner_first_name = learner_first_name;
        this.learner_last_name = learner_last_name;
        this.learner_email = learner_email;
        this.learner_password = learner_password;
    }




    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Courses getCourse() {
        return course;
    }

    public void setCourse(Courses course) {
        this.course = course;
    }

    public String getLearner_first_name() {
        return learner_first_name;
    }

    public void setLearner_first_name(String learner_first_name) {
        this.learner_first_name = learner_first_name;
    }

    public String getLearner_last_name() {
        return learner_last_name;
    }

    public void setLearner_last_name(String learner_last_name) {
        this.learner_last_name = learner_last_name;
    }

    public String getLearner_email() {
        return learner_email;
    }

    public void setLearner_email(String learner_email) {
        this.learner_email = learner_email;
    }

    public String getLearner_password() {
        return learner_password;
    }

    public void setLearner_password(String learner_password) {
        this.learner_password = learner_password;
    }

    @Override
    public String toString() {
        return "Learners{" +
                "id=" + id +
                ", course=" + course +
                ", learner_first_name='" + learner_first_name + '\'' +
                ", learner_last_name='" + learner_last_name + '\'' +
                ", learner_email='" + learner_email + '\'' +
                ", learner_password='" + learner_password + '\'' +
                '}';
    }
}