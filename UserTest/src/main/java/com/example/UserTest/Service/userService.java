package com.example.UserTest.Service;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.UserTest.Bean.HigherEducation;
import com.example.UserTest.Bean.UserBean;

@Service
public class userService {
    static ArrayList<UserBean> users = new ArrayList<UserBean>();
    private int counter = 1000;
    static {

        System.out.println("Getting users");
        HigherEducation hed = HigherEducation.Builder.newInstance().setUniversity("Anna Univeristy").setCourse("MCA")
                .setSpecialization("Masters Applications").setPercentage(80).build();
        HigherEducation hed1 = HigherEducation.Builder.newInstance().setUniversity("Anna Univeristy").setCourse("BCA")
                .setSpecialization("Bachelors Applications").setPercentage(90).build();
        UserBean user1 = UserBean.Builder.newInstance().setId(1).setName("Avinesh").setAge(40).setGender("Male")
                .setMobile("9923434434").setEmail("avinesh12@gmail.com").addHigherEducation(hed)
                .addHigherEducation(hed1).build();
        UserBean user2 = UserBean.Builder.newInstance().setId(2).setName("Sujith").setAge(36).setGender("Male")
                .setMobile("9844332332").setEmail("sujith@gmail.com").addHigherEducation(hed1).addHigherEducation(hed)
                .build();
        UserBean user3 = UserBean.Builder.newInstance().setId(3).setName("Jeeva").setAge(41).setGender("Female")
                .setMobile("6234343433").setEmail("jeeva@gmail.com").addHigherEducation(hed1).addHigherEducation(hed)
                .build();
        users.add(user1);
        users.add(user2);
        users.add(user3);
    }

    public synchronized void increment() {
        counter++;
        System.out.println("Counter: " + counter + " by " + Thread.currentThread().getName());
    }

    public int getCounter() {
        return counter;
    }

    public ArrayList<UserBean> getUsersDetails() {
        System.out.println("Getting User Details---->");
        return users;

    }

    public UserBean getUsersDetailsById(int id) {
        System.out.println("Inside User getUsersDetailsById---->");
        Optional<UserBean> userbean = users.stream().filter(user -> user.getId() == id).findAny();
        if (userbean.isPresent())
            return userbean.get();
        else
            return null;

    }

    public String getUsersDetailsRiskScore(UserBean user) {
        System.out.println("Inside User getUsersDetailsRiskScore---->");
        String riskScore = "Low";
        if (user != null) {
            if (user.getAge() > 40 && user.getGender().equalsIgnoreCase("Female"))
                riskScore = "High";
        }
        return riskScore;

    }

    public boolean validateUserExists(String username) {
        System.out.println("Inside User validateUserExists---->");
        boolean userExists = false;
        if (username != null) {
            Optional<UserBean> userbean = users.stream().filter(user -> user.getName().equalsIgnoreCase(username))
                .findAny();
            if(userbean.isPresent())
                userExists= true;
        }
        return userExists;

    }

    public UserBean AddUsersDetails(UserBean addUserDetails) {
        System.out.println("Inside User AddUsersDetails---->");
            increment(); // Counter value increment for each User addition
            int id = getCounter();
            System.out.println(" User Id value for AddUsersDetails---->" + id);
            addUserDetails.setId(id);
            users.add(addUserDetails);
            return addUserDetails;
        

    }

    public String deleteUsersDetailsById(int id) {
        System.out.println("Inside User getUsersDetailsById---->");
        Optional<UserBean> userDetail = users.stream().filter(user -> user.getId() == id).findAny();
        if (userDetail.isPresent()) {
            users.remove(userDetail.get());
            return " User Id " + id + " is deleted";
        }

        else
            return " User Id " + id + " is not deleted";

    }

}
