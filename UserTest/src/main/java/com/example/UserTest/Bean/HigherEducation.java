package com.example.UserTest.Bean;



import lombok.Getter;
import lombok.Setter;


@Getter
@Setter


public class HigherEducation {

    private String university;
    private String course;
    private String specialization;
    private int percentage;

    public HigherEducation(){
        
    }
    public HigherEducation(Builder userBuilder)
    {
        this.university = userBuilder.university;
        this.course = userBuilder.course;
        this.specialization = userBuilder.specialization;
        this.percentage = userBuilder.percentage;

    }

    
    public static class Builder {

        // instance fields
        private String university;
        private String course;
        private String specialization;
        private int percentage;

    public static Builder newInstance()
    {
        return new Builder();
    }

    private Builder() {}

    // Setter methods
    public Builder setUniversity(String university)
    {
        this.university = university;
        return this;
    }

    public Builder setSpecialization(String specialization)
    {
        this.specialization = specialization;
        return this;
    }

    public Builder setCourse(String course){
        this.course = course;
        return this;
    }

    public Builder setPercentage(int percentage )
    {
        this.percentage = percentage;
        return this;
    }

    public HigherEducation build()
    {
        return new HigherEducation(this);
    }

    }
}
