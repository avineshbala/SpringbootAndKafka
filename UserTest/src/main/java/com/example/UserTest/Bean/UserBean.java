package com.example.UserTest.Bean;

import java.util.ArrayList;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class UserBean {

    private int id;

    @NotNull
    private String name;
    
    @Min (value=21)
    private int age;


    private String gender;

    @Email
    private String email;

    @Size (min =10, max = 10)
    @Pattern(regexp="(^$|[0-9]{10})")
    private String mobile;

    private ArrayList<HigherEducation> higher_education;
    
    public UserBean()
    {
        
    }

    public UserBean(Builder userBuilder)
    {
        this.id = userBuilder.id;
        this.name = userBuilder.name;
        this.age = userBuilder.age;
        this.gender = userBuilder.gender;
        this.mobile= userBuilder.mobile;
        this.email=userBuilder.email;
        this.higher_education=userBuilder.higher_education;

    }

    public static class Builder {

        // instance fields
        private int id;
        private String name;
        private int age;
        private String gender;
        private String email;
        private String mobile;
        private ArrayList<HigherEducation> higher_education;

        public Builder addHigherEducation(HigherEducation higher_education){
            if(this.higher_education != null){
                this.higher_education.add(higher_education);
            }
            else{
                this.higher_education = new ArrayList<HigherEducation>();
                this.higher_education.add(higher_education);
            }             

         
            return this;
        }

        public static Builder newInstance()
        {
            return new Builder();
        }

        private Builder() {}

        // Setter methods
        public Builder setId(int id)
        {
            this.id = id;
            return this;
        }
        public Builder setName(String name)
        {
            this.name = name;
            return this;
        }

        public Builder setGender(String gender)
        {
            this.gender = gender;
            return this;
        }

        public Builder setEmail(String email)
        {
            this.email = email;
            return this;
        }

        public Builder setMobile(String mobile)
        {
            this.mobile = mobile;
            return this;
        }

        public Builder setAge(int age)
        {
            this.age = age;
            return this;
        }

        public UserBean build()
        {
            return new UserBean(this);
        }

    }

}
